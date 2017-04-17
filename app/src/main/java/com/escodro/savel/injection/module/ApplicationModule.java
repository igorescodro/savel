package com.escodro.savel.injection.module;

import android.app.Application;
import android.content.Context;

import com.escodro.savel.SavelApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} exposing the {@link Application} main attributes.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
@Module
public class ApplicationModule {

    private final SavelApplication mApplication;

    public ApplicationModule(SavelApplication app) {
        mApplication = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApplication.getApplicationContext();
    }
}
