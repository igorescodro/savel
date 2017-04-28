package com.escodro.savel.injection.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} responsible to provide the {@link Gson} to the requests.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
@Module
public class GsonModule {

    @Provides
    @Singleton
    GsonBuilder provideDefaultGsonBuilder() {
        final GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        builder.setDateFormat(DateFormat.FULL);
        return builder;
    }

    @Provides
    @Singleton
    Gson provideGson(GsonBuilder builder) {
        return builder.create();
    }
}
