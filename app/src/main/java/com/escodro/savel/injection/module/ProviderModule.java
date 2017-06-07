package com.escodro.savel.injection.module;

import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.local.provider.ObservableProvider;
import com.escodro.savel.data.local.provider.TimelineProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} to provide the {@link ObservableProvider}s.
 * <p/>
 * Created by Igor Escodro on 05/05/17.
 */
@Module
public class ProviderModule {

    @Singleton
    @Provides
    ArtistProvider provideArtistProvider() {
        return new ArtistProvider();
    }

    @Singleton
    @Provides
    TimelineProvider provideTimelineProvider() {
        return new TimelineProvider();
    }
}
