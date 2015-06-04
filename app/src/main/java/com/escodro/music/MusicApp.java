package com.escodro.music;

import android.app.Application;
import android.content.Context;

import com.escodro.music.rest.echonest.EchoNestAPI;
import com.escodro.music.rest.echonest.EchoNestClient;

/**
 * {@link Application} class with app Singletons.
 * <p/>
 * Created by IgorEscodro on 23/05/15.
 */
public class MusicApp extends Application {

    /**
     * {@link MusicApp} application reference.
     */
    private static MusicApp appInstance;

    /**
     * {@link EchoNestAPI} reference.
     */
    private static EchoNestAPI mEchoNestAPI;

    /**
     * {@link Context} reference.
     */
    private static Context mContext;

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

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        mContext = appInstance.getApplicationContext();
    }
}
