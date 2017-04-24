package com.escodro.savel.injection.component;

import com.escodro.savel.SavelApplication;
import com.escodro.savel.injection.module.ApplicationModule;
import com.escodro.savel.injection.module.GsonModule;
import com.escodro.savel.injection.module.NetworkModule;
import com.escodro.savel.injection.module.OkHttpInterceptorModule;
import com.escodro.savel.ui.activity.ArtistActivity;
import com.escodro.savel.ui.activity.SearchActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Main application {@link Component}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        GsonModule.class,
        NetworkModule.class,
        OkHttpInterceptorModule.class})
public interface ApplicationComponent {

    void inject(SavelApplication savelApplication);

    void inject(ArtistActivity artistActivity);

    void inject(SearchActivity searchActivity);
}
