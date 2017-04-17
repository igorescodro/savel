package com.escodro.savel;

import android.app.Application;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Savel {@link Application} class.
 * <p>
 * Created by Igor Escodro on 17/04/17.
 */

public class SavelApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        enableLogging();
    }

    private void enableLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }
}
