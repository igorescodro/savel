package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.spotify.SpotifyArtist;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service API containing the methods to communicate with Spotify endpoints.
 * <p/>
 * Created by Igor Escodro on 30/04/17.
 *
 * @see <a href="https://developer.spotify.com/web-api/endpoint-reference/">Spotify API
 * Documentation</a>
 */
public interface SpotifyService {

    /**
     * Connect to artist endpoints and retrieve a {@link SpotifyArtist} based on the Spotify id.
     *
     * @param artistId artist Spotify id
     *
     * @return observable of Sporify artist
     *
     * @see <a href="https://developer.spotify.com/web-api/get-artist/">Spotify API Documentation |
     * Get an Artist</a>
     */
    @GET("artists/{artistId}")
    Observable<SpotifyArtist> getArtistById(@Path("artistId") String artistId);
}
