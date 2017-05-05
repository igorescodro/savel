package com.escodro.savel.injection.module;

import com.escodro.savel.data.local.provider.ArtistProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Igor Escodro on 05/05/17.
 */
@Module
public class ProviderModule {

    @Singleton
    @Provides
    ArtistProvider provideArtistProvider() {
        return new ArtistProvider();
    }
}
