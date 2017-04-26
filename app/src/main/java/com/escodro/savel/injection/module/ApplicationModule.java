package com.escodro.savel.injection.module;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

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

    @Provides
    public LinearLayoutManager provideLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    public DividerItemDecoration provideDividerItemDecoration(Context context,
                                                              LinearLayoutManager layoutManager) {
        return new DividerItemDecoration(context, layoutManager.getOrientation());
    }
}
