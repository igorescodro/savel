package com.escodro.music;

import android.app.Application;

import com.echonest.api.v4.EchoNestAPI;

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
    private EchoNestAPI mEchoNestAPI;

    /**
     * Get {@link MusicApp} instance.
     *
     * @return {@link MusicApp} instance
     */
    public static MusicApp getInstance() {
        return appInstance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    /**
     * Get {@link EchoNestAPI} instance.
     *
     * @return {@link EchoNestAPI} instance
     */
    public EchoNestAPI getEchoNestAPI() {
        if (mEchoNestAPI == null) {
            mEchoNestAPI = new EchoNestAPI(this.getResources().getString(R.string
                    .api_echonest_key));
        }
        return mEchoNestAPI;
    }
}
