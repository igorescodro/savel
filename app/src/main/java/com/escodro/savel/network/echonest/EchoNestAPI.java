package com.escodro.savel.network.echonest;

import com.escodro.savel.network.echonest.model.EchoNestResponse;
import com.escodro.savel.network.spotify.SpotifyAPI;
import com.escodro.savel.network.spotify.model.Item;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Interface containing the methods to create requests to EchoNest.
 *
 * @see <a href="http://developer.echonest.com/docs/v4">Echo Nest API Overview</a>
 * <p/>
 * Created by IgorEscodro on 29/05/15.
 */
public interface EchoNestAPI {

    /**
     * * {@link EchoNestAPI} request to search artists by {@link SpotifyAPI} id. This request is
     * used to get the MusicBrainz id of the {@link Item}, which is an "universal" id for other
     * services.
     *
     * @param id       {@link SpotifyAPI} id
     * @param callback {@link Callback} to be implemented to handle request response
     *
     * @see <a href="http://developer.echonest.com/docs/v4/artist.html#profile">Echo Nest API
     * Overview - Profile</a>
     */
    @GET(EchoNestClient.PROFILE_SEARCH_URL)
    void searchArtistBySpotifyId(@Query("id") String id, Callback<EchoNestResponse> callback);
}
