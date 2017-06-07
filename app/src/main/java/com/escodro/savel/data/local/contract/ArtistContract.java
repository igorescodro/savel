package com.escodro.savel.data.local.contract;

import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.local.provider.TimelineProvider;
import com.escodro.savel.data.local.repository.SavelRepository;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzRelation;
import com.escodro.savel.ui.artist.ArtistViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

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
    public ArtistContract() {
    }

    /**
     * Get the artist from the {@link SavelRepository} and apply the {@link
     * io.reactivex.Scheduler}s.
     *
     * @param artistId artist MBID
     *
     * @return observable of artist
     */
    public Observable<SavelArtist> getArtist(String artistId) {
        final Observable<SavelArtist> observable =
                mSavelRepository.getArtist(artistId).compose(applySchedulers()).share();
        observable.subscribe(this::processArtist);
        return observable;
    }

    /**
     * On receive the {@link SavelArtist}, store it on the {@link ArtistProvider}. After that, get
     * the {@link java.util.List} of {@link com.escodro.savel.data.model.SavelTimeline} and stores
     * it on the {@link TimelineProvider}.
     *
     * @param savelArtist savel artist
     */
    private void processArtist(SavelArtist savelArtist) {
        mArtistProvider.storeData(savelArtist);

        final List<MusicBrainzRelation> relations = savelArtist.getRelations();
        mSavelRepository.getArtistTimeLine(relations).subscribe(mTimelineProvider::storeData);
    }
}
