package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.spotify.SpotifyArtist;
import com.escodro.savel.data.model.spotify.SpotifySearch;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
     * @return observable of Spotify artist
     *
     * @see <a href="https://developer.spotify.com/web-api/get-artist/">Spotify API Documentation |
     * Get an Artist</a>
     */
    @GET("artists/{artistId}")
    Observable<SpotifyArtist> getArtistById(@Path("artistId") String artistId);

    /**
     * Connect to artist endpoints and retrieve a list of {@link SpotifyArtist} based on the Spotify
     * id. This endpoint is called once the search done by {@link MusicBrainzService} does not
     * include popularity.
     *
     * @param artistName artist name
     *
     * @return observable of Spotify Search entity
     *
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Spotify API Documentation |
     * Search for an Item</a>
     */
    @GET("search?type=artist&limit=5")
    Observable<SpotifySearch> getPrediction(@Query("q") String artistName);
}
