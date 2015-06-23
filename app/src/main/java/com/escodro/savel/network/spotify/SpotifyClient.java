package com.escodro.savel.network.spotify;

import com.escodro.savel.network.spotify.model.Item;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * {@link SpotifyAPI} client to build the request.
 * <p/>
 * Created by IgorEscodro on 07/06/15.
 */
public class SpotifyClient {

    /**
     * URL to create a {@link Item} search request.
     */
    public static final String SEARCH_URL = "/search/";
    /**
     * Base URL to request the data to {@link SpotifyAPI}.
     */
    private static final String BASE_URL = "https://api.spotify.com/v1/";
    /**
     * {@link SpotifyAPI} reference.
     */
    private SpotifyAPI mInterface;

    /**
     * Create a new instance of {@link SpotifyClient}.
     */
    public SpotifyClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog(SpotifyAPI.class.getSimpleName()))
                .build();
        mInterface = restAdapter.create(SpotifyAPI.class);
    }

    /**
     * Get instance of {@link SpotifyAPI}.
     *
     * @return instance of {@link SpotifyAPI}
     */
    public SpotifyAPI getSpotifyAPI() {
        return mInterface;
    }
}
