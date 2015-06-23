package com.escodro.savel.network.spotify;

import com.escodro.savel.network.spotify.model.Artist;
import com.escodro.savel.network.spotify.model.Item;
import com.escodro.savel.network.spotify.model.SpotifyResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Interface containing the methods to create requests to Spotify.
 *
 * @see <a href="https://developer.spotify.com/web-api/">Spotify Web API</a>
 * <p/>
 * Created by IgorEscodro on 07/06/15.
 */
public interface SpotifyAPI {

    /**
     * {@link SpotifyAPI} request to search artists by name.
     *
     * @param name     {@link Artist} name
     * @param type     {@link Item} type
     * @param callback {@link Callback} to be implemented to handle request response
     */
    @GET(SpotifyClient.SEARCH_URL)
    void searchItemByName(@Query("q") String name, @Query("type") String type,
                          Callback<SpotifyResponse> callback);
}
