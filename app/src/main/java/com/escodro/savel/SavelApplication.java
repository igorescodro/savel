package com.escodro.savel;

import android.app.Application;

import com.escodro.savel.injection.Injector;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Savel {@link Application} class.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class SavelApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
        enableLogging();
    }

    /**
     * Initialize Dagger components.
     */
    private void initializeComponent() {
        Injector.initializeApplicationComponent(this);
        Injector.getApplicationComponent().inject(this);
    }

    /**
     * Initialize {@link Timber} logs if in {@link BuildConfig#DEBUG} mode.
     */
    private void enableLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }
}
