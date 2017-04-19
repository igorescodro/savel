package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.discogs.DiscogsArtist;
import com.escodro.savel.data.remote.service.DiscogsService;
import com.escodro.savel.injection.qualifier.Discogs;

import javax.inject.Inject;

import io.reactivex.Observable;
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
     * Get a {@link DiscogsArtist} entity from {@link DiscogsService} server.
     *
     * @param artistId artist Discogs id
     * @return observable of Discogs Artist entity
     */
    public Observable<DiscogsArtist> getArtist(String artistId) {
        return mService.getArtist(artistId);
    }
}
