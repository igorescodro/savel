package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.discogs.DiscogsArtist;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service API containing the methods to communicate with Discogs endpoints.
 * <p/>
 * Created by Igor Escodro on 19/04/17.
 *
 * @see <a href="https://www.discogs.com/developers/">Discogs API Documentation</a>
 */
public interface DiscogsService {

    /**
     * Connect to artist endpoints and retrieve an {@link DiscogsArtist} based on the Discogs id.
     *
     * @param artistId artist Discogs id
     * @return observable of Discogs artist
     * @see
     * <a href="https://www.discogs.com/developers/#page:database,header:database-artist-releases-get">Discogs
     * API Documentation | Artists</a>
     */
    @GET("artists/{artistId}")
    Observable<DiscogsArtist> getArtist(@Path("artistId") String artistId);
}
