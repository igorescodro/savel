package com.escodro.savel;

import android.app.Application;
import android.content.Context;

import com.escodro.savel.network.echonest.EchoNestAPI;
import com.escodro.savel.network.echonest.EchoNestClient;
import com.escodro.savel.network.lastfm.LastFmAPI;
import com.escodro.savel.network.lastfm.LastFmClient;
import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.escodro.savel.network.musicbrainz.MusicBrainzClient;
import com.escodro.savel.network.spotify.SpotifyAPI;
import com.escodro.savel.network.spotify.SpotifyClient;
import com.escodro.savel.requests.RequestManager;

/**
 * {@link Application} class with app Singletons.
 * <p/>
 * Created by IgorEscodro on 23/05/15.
 */
public class SavelApp extends Application {

    /**
     * {@link Context} reference.
     */
    private static Context mContext;

    /**
     * {@link RequestManager} reference.
     */
    private static RequestManager mRequestManager;

    /**
     * {@link EchoNestAPI} reference.
     */
    private static EchoNestAPI mEchoNestAPI;

    /**
     * {@link SpotifyAPI} reference.
     */
    private static SpotifyAPI mSpotifyAPI;

    /**
     * {@link LastFmAPI} reference.
     */
    private static LastFmAPI mLastFmAPI;

    /**
     * {@link MusicBrainzAPI} reference.
     */
    private static MusicBrainzAPI mMusicBrainzAPI;

    /**
     * Get {@link SavelApp} instance.
     *
     * @return {@link SavelApp} instance
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * Singleton to get {@link EchoNestAPI} instance.
     *
     * @return {@link EchoNestAPI} instance
     */
    public static EchoNestAPI getEchoNestAPI() {
        if (mEchoNestAPI == null) {
            mEchoNestAPI = new EchoNestClient().getEchoNestAPI();
        }
        return mEchoNestAPI;
    }

    /**
     * Singleton to get {@link SpotifyAPI} instance.
     *
     * @return {@link SpotifyAPI} instance
     */
    public static SpotifyAPI getSpotifyAPI() {
        if (mSpotifyAPI == null) {
            mSpotifyAPI = new SpotifyClient().getSpotifyAPI();
        }
        return mSpotifyAPI;
    }

    /**
     * Singleton to get {@link LastFmAPI} instance.
     *
     * @return {@link LastFmAPI} instance
     */
    public static LastFmAPI getLastFmAPI() {
        if (mLastFmAPI == null) {
            mLastFmAPI = new LastFmClient().getLastFmAPI();
        }
        return mLastFmAPI;
    }

    /**
     * Singleton to get {@link MusicBrainzAPI} instance.
     *
     * @return {@link LastFmAPI} instance
     */
    public static MusicBrainzAPI getMusicBrainzAPI() {
        if (mMusicBrainzAPI == null) {
            mMusicBrainzAPI = new MusicBrainzClient().getMusicBrainzAPI();
        }
        return mMusicBrainzAPI;
    }

    /**
     * Singleton to get {@link RequestManager} instance.
     *
     * @return {@link RequestManager} instance
     */
    public static RequestManager getRequestManager() {
        if (mRequestManager == null) {
            mRequestManager = new RequestManager();
        }
        return mRequestManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }
}
