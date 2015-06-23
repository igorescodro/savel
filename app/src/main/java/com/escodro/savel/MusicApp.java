package com.escodro.savel;

import android.app.Application;
import android.content.Context;

import com.escodro.savel.network.echonest.EchoNestAPI;
import com.escodro.savel.network.echonest.EchoNestClient;
import com.escodro.savel.network.spotify.SpotifyAPI;
import com.escodro.savel.network.spotify.SpotifyClient;

/**
 * {@link Application} class with app Singletons.
 * <p/>
 * Created by IgorEscodro on 23/05/15.
 */
public class MusicApp extends Application {

    /**
     * {@link Context} reference.
     */
    private static Context mContext;

    /**
     * {@link EchoNestAPI} reference.
     */
    private static EchoNestAPI mEchoNestAPI;

    /**
     * {@link SpotifyAPI} reference.
     */
    private static SpotifyAPI mSpotifyAPI;

    /**
     * Get {@link MusicApp} instance.
     *
     * @return {@link MusicApp} instance
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

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }
}
