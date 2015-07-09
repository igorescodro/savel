package com.escodro.savel.network.lastfm;

import com.escodro.savel.R;
import com.escodro.savel.SavelApp;
import com.escodro.savel.network.lastfm.model.Artist;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * {@link LastFmAPI} client to build the request.
 * <p/>
 * Created by IgorEscodro on 27/06/15.
 */
public class LastFmClient implements RequestInterceptor {

    /**
     * URL to create an {@link Artist} Profile search request.
     */
    public static final String PROFILE_URL = "/?method=artist.getinfo";
    /**
     * Base URL to request the data to {@link LastFmAPI}.
     */
    private static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    /**
     * Constant to represent the request format.
     */
    private static final String FORMAT = "json";

    /**
     * Developer API Key provided by LastFM to request the data.
     */
    private static final String API_KEY = SavelApp.getContext()
            .getString(R.string.api_lastfm_key);

    /**
     * {@link LastFmAPI} reference.
     */
    private LastFmAPI mInterface;

    /**
     * Create a new instance of {@link LastFmClient}.
     */
    public LastFmClient() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(this)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog(LastFmClient.class.getSimpleName()))
                .build();
        mInterface = restAdapter.create(LastFmAPI.class);
    }

    /**
     * Get instance of {@link LastFmAPI}.
     *
     * @return instance of {@link LastFmAPI}
     */
    public LastFmAPI getLastFmAPI() {
        return mInterface;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("api_key", API_KEY);
        request.addQueryParam("format", FORMAT);
    }
}
