package com.escodro.savel.network.musicbrainz;

import com.escodro.savel.network.musicbrainz.model.MusicBrainzResponse;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * {@link MusicBrainzAPI} client to build the request.
 * <p/>
 * Created by IgorEscodro on 09/07/15.
 */
public class MusicBrainzClient implements RequestInterceptor {

    /**
     * URL to create an {@link MusicBrainzResponse} Profile search request.
     */
    public static final String PROFILE_URL = "/artist/{mbid}?inc=release-groups%20url-rels";
    /**
     * Base URL to request the data to {@link MusicBrainzAPI}.
     */
    private static final String BASE_URL = "https://musicbrainz.org/ws/2/";
    /**
     * Constant to represent the request format.
     */
    private static final String FORMAT = "json";

    /**
     * {@link MusicBrainzAPI} reference.
     */
    private MusicBrainzAPI mInterface;

    /**
     * Create a new instance of {@link MusicBrainzAPI}.
     */
    public MusicBrainzClient() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(this)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog(MusicBrainzClient.class.getSimpleName()))
                .build();
        mInterface = restAdapter.create(MusicBrainzAPI.class);
    }

    /**
     * Get instance of {@link MusicBrainzAPI}.
     *
     * @return instance of {@link MusicBrainzAPI}
     */
    public MusicBrainzAPI getMusicBrainzAPI() {
        return mInterface;
    }

    @Override
    public void intercept(RequestInterceptor.RequestFacade request) {
        request.addQueryParam("fmt", FORMAT);
    }
}
