package com.escodro.savel.data.remote.repository;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtistList;
import com.escodro.savel.data.remote.service.MusicBrainzService;
import com.escodro.savel.injection.qualifier.MusicBrainz;
import com.escodro.savel.util.adapter.NetworkErrorHandler;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;
import timber.log.Timber;

/**
 * Repository to connect to {@link MusicBrainzService}.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
public class MusicBrainzRepository {

    private final MusicBrainzService mService;

    @Inject
    NetworkErrorHandler mNetworkErrorHandler;

    @Inject
    public MusicBrainzRepository(@MusicBrainz Retrofit retrofit) {
        mService = retrofit.create(MusicBrainzService.class);
    }

    /**
     * Get a {@link MusicBrainzArtist} entity from {@link MusicBrainzService} server.
     *
     * @param artistId artist MBID
     *
     * @return observable of MusicBrainz Artist entity
     */
    public Observable<MusicBrainzArtist> getArtistInfo(String artistId) {
        return mService.getArtistById(artistId)
                .retryWhen(retryOnUnknownHost());
    }

    /**
     * Get a {@link MusicBrainzArtistList} entity from {@link MusicBrainzService} server.<br>
     * This method refactor the given parameter to fit the API endpoint, following the given
     * example:
     * <p>
     * <code>
     * artist/?query=artist:fred%20AND%20type:group%20AND%20country:US
     * </code>
     *
     * @param artistName artist name
     *
     * @return observable of MusicBrainz Artist List entity
     */
    public Observable<MusicBrainzArtistList> searchArtist(String artistName) {
        return mService.searchArtist(artistName)
                .retryWhen(retryOnUnknownHost());
    }

    /**
     * Returns a function that verifies if the threw exception is HTTP 503 and retry, otherwise
     * it throws the error for further handling.
     *
     * @return function to retry on 503
     */
    @NonNull
    private Function<Observable<Throwable>, ObservableSource<?>> retryOnUnknownHost() {
        return throwableObservable -> throwableObservable.flatMap(
                (Function<Throwable, ObservableSource<?>>) throwable -> {
                    Observable result = Observable.error(throwable);
                    if (mNetworkErrorHandler.isServerUnavailable(throwable)) {
                        Timber.w("MusicBrainz server is not available. Retrying...");
                        result = Observable.just(new Object());
                    }
                    return result;
                });
    }
}
