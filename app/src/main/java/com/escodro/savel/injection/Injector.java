package com.escodro.savel.injection;

import com.escodro.savel.SavelApplication;
import com.escodro.savel.injection.component.ApplicationComponent;
import com.escodro.savel.injection.component.DaggerApplicationComponent;
import com.escodro.savel.injection.module.ApplicationModule;
import com.escodro.savel.injection.module.GsonModule;
import com.escodro.savel.injection.module.NetworkModule;
import com.escodro.savel.injection.module.OkHttpInterceptorModule;

import java.util.Objects;

/**
 * Class responsible to initialize the {@link ApplicationComponent}, setting all the applicable
 * {@link dagger.Module}s.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class Injector {

    private static ApplicationComponent mApplicationComponent;

    /**
     * Private constructor to avoid instantiation.
     */
    private Injector() {
    }

    /**
     * Initialize the {@link ApplicationComponent}, setting all the related {@link dagger.Module}.
     *
     * @param app application class
     */
    public static void initializeApplicationComponent(SavelApplication app) {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .gsonModule(new GsonModule())
                .networkModule(new NetworkModule())
                .okHttpInterceptorModule(new OkHttpInterceptorModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        Objects.requireNonNull(mApplicationComponent, "ApplicationComponent is null");
        return mApplicationComponent;
    }
}
