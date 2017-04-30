package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.spotify.SpotifyArtist;
import com.escodro.savel.data.remote.service.SpotifyService;
import com.escodro.savel.injection.qualifier.Spotify;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link SpotifyArtist}.
 * <p/>
 * Created by Igor Escodro on 30/04/17.
 */
public class SpotifyRepository {

    private final SpotifyService mService;

    @Inject
    public SpotifyRepository(@Spotify Retrofit retrofit) {
        mService = retrofit.create(SpotifyService.class);
    }

    /**
     * Get a {@link SpotifyArtist} entity from {@link SpotifyService} server.
     *
     * @param artistId artist Spotify id
     *
     * @return observable of Spotify Artist entity
     */
    public Observable<SpotifyArtist> getArtistInfo(String artistId) {
        return mService.getArtistById(artistId);
    }
}
