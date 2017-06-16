package com.escodro.savel.data.local.contract;

import com.escodro.savel.data.local.database.ArtistDAO;
import com.escodro.savel.data.local.database.model.ArtistRealm;
import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.local.provider.TimelineProvider;
import com.escodro.savel.data.local.repository.SavelRepository;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.ui.artist.ArtistViewModel;

import java.net.UnknownHostException;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Class containing the contract methods related to {@link ArtistViewModel}.
 * <p>
 * Created by Igor Escodro on 18/04/17.
 */
public class ArtistContract extends BaseContract {

    @Inject
    SavelRepository mSavelRepository;

    @Inject
    ArtistProvider mArtistProvider;

    @Inject
    TimelineProvider mTimelineProvider;

    @Inject
    ArtistDAO mArtistDAO;

    @Inject
    public ArtistContract() {
    }

    /**
     * Get the {@link ArtistRealm} from the {@link SavelRepository} and saves it to the database.
     * If already exists one in the table, it is used as cache while the query to retrieve new
     * data is being executed.
     *
     * @param artistId artist MBID
     *
     * @return observable of artist
     *
     * @see <a href="https://medium.com/@Miqubel/caching-with-realm-and-rxjava-80f48c5f5e37">Caching
     * With Realm and RxJava | Medium</a>
     */
    public Observable<ArtistRealm> getArtist(String artistId) {
        final Observable<SavelArtist> observable = mSavelRepository.getArtist(artistId).share();

        Observable<ArtistRealm> realmObservable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(mArtistDAO::writeToRealm)
                .observeOn(AndroidSchedulers.mainThread())
                .map(mArtistDAO::readFromRealm);

        final ArtistRealm cachedArtist = mArtistDAO.readFromRealm(artistId);
        if (cachedArtist != null) {
            realmObservable = realmObservable.mergeWith(Observable.just(cachedArtist));
        }

        realmObservable.subscribe(this::processArtist, this::processError);
        return realmObservable;
    }

    /**
     * On receive the {@link SavelArtist}, store it on the {@link ArtistProvider}. After that, get
     * the {@link java.util.List} of {@link com.escodro.savel.data.model.SavelTimeline} and stores
     * it on the {@link TimelineProvider}.
     *
     * @param savelArtist savel artist
     */
    private void processArtist(ArtistRealm savelArtist) {
        mArtistProvider.storeData(savelArtist);

//        final List<MusicBrainzRelation> relations = savelArtist.getRelations();
//        mSavelRepository.getArtistTimeLine(relations).subscribe(mTimelineProvider::storeData);
    }

    /**
     * Ignore the errors and log if there is no connection.
     *
     * @param error error to be processed
     */
    private void processError(Throwable error) {
        if (error instanceof UnknownHostException) {
            Timber.w("Trying to search without internet connection. Loading cache if available.");
        }
    }
}
