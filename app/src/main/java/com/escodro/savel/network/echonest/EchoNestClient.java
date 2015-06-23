package com.escodro.savel.network.echonest;

import com.escodro.savel.MusicApp;
import com.escodro.savel.R;
import com.escodro.savel.network.echonest.model.Artist;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * {@link EchoNestAPI} client to build the request.
 * <p/>
 * Created by IgorEscodro on 29/05/15.
 */
public class EchoNestClient implements RequestInterceptor {

    /**
     * URL to create a {@link Artist} search request.
     */
    public static final String ARTIST_SEARCH_URL = "/artist/search?bucket=images";
    /**
     * Base URL to request the data to {@link EchoNestAPI}.
     */
    private static final String BASE_URL = "http://developer.echonest.com/api/v4/";
    /**
     * Developer API Key provided by EchoNest to request the data.
     */
    private static final String API_KEY = MusicApp.getContext()
            .getString(R.string.api_echonest_key);

    /**
     * Constant to represent the request format.
     */
    private static final String FORMAT = "json";

    /**
     * {@link EchoNestAPI} reference.
     */
    private EchoNestAPI mInterface;

    /**
     * Create a new instance of {@link EchoNestClient}.
     */
    public EchoNestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(this)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog(EchoNestAPI.class.getSimpleName()))
                .build();
        mInterface = restAdapter.create(EchoNestAPI.class);
    }

    /**
     * Get instance of {@link EchoNestAPI}.
     *
     * @return instance of {@link EchoNestAPI}
     */
    public EchoNestAPI getEchoNestAPI() {
        return mInterface;
    }

    /**
     * Method which intercepts all the request made to {@link EchoNestAPI} and add common parameters
     * to all requests.
     *
     * @param request {@link retrofit.RequestInterceptor.RequestFacade} made
     */
    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("api_key", API_KEY);
        request.addQueryParam("format", FORMAT);
    }
}
