package com.escodro.savel.injection.component;

import com.escodro.savel.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Main application {@link dagger.Module}
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class})
public interface ApplicationComponent {
}
