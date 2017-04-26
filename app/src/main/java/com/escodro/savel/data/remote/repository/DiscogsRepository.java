package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.discogs.DiscogsArtist;
import com.escodro.savel.data.remote.service.DiscogsService;
import com.escodro.savel.injection.qualifier.Discogs;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link DiscogsService}.
 * <p/>
 * Created by Igor Escodro on 19/04/17.
 */
public class DiscogsRepository {

    private final DiscogsService mService;

    @Inject
    public DiscogsRepository(@Discogs Retrofit retrofit) {
        mService = retrofit.create(DiscogsService.class);
    }

    /**
     * Get a {@link DiscogsArtist} entity from {@link DiscogsService} server. If an error occurs
     * during the request, a new empty {@link DiscogsArtist} will be returned.
     *
     * @param artistId artist Discogs id
     *
     * @return observable of Discogs Artist entity
     */
    public Observable<DiscogsArtist> getArtist(String artistId) {
        return mService.getArtist(artistId).onErrorReturnItem(new DiscogsArtist()).subscribeOn(
                Schedulers.newThread());
    }
}
