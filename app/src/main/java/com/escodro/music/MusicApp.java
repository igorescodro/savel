package com.escodro.music;

import android.app.Application;

import com.echonest.api.v4.EchoNestAPI;

/**
 * {@link Application} class with app Singletons.
 * <p/>
 * Created by IgorEscodro on 23/05/15.
 */
public class MusicApp extends Application {

    private static MusicApp appInstance;
    private EchoNestAPI mEchoNestAPI = new EchoNestAPI(getResources().getString(R.string
            .api_echonest_key));

    public static MusicApp getInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public EchoNestAPI getEchoNestAPI() {
        return mEchoNestAPI;
    }
}
