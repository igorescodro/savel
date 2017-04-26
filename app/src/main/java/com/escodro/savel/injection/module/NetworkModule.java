package com.escodro.savel.injection.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.escodro.savel.BuildConfig;
import com.escodro.savel.injection.qualifier.Discogs;
import com.escodro.savel.injection.qualifier.MusicBrainz;
import com.escodro.savel.injection.qualifier.Twitter;
import com.google.gson.Gson;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * {@link Module} to provide the Service APIs interfaces to network requests.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
@Module
public class NetworkModule {

    /**
     * Maximum cache size in bytes.
     */
    private static final int DISK_CACHE_SIZE = (int) 1_000_000L;

    @MusicBrainz
    @Provides
    @Singleton
    public OkHttpClient provideMusicBrainzClient(Context app,
                                                 @MusicBrainz @NonNull List<Interceptor>
                                                         interceptors) {
        final File cacheDir = new File(app.getCacheDir(), "musicbrainz");
        final Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        interceptors.forEach(okHttpBuilder::addInterceptor);

        okHttpBuilder.cache(cache);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);

        return okHttpBuilder.build();
    }

    @MusicBrainz
    @Provides
    @Singleton
    public Retrofit provideMusicBrainzApi(@MusicBrainz @NonNull OkHttpClient okHttpClient,
                                          @NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_MUSICBRAINZ_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Discogs
    @Provides
    @Singleton
    public OkHttpClient provideDiscogsClient(Context app,
                                             @Discogs @NonNull List<Interceptor> interceptors) {
        final File cacheDir = new File(app.getCacheDir(), "discogs");
        final Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        interceptors.forEach(okHttpBuilder::addInterceptor);

        okHttpBuilder.cache(cache);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);

        return okHttpBuilder.build();
    }

    @Discogs
    @Provides
    @Singleton
    public Retrofit provideDiscogsApi(@Discogs @NonNull OkHttpClient okHttpClient,
                                      @NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_DISCOGS_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Twitter
    @Provides
    @Singleton
    public OkHttpClient provideTwitterClient(Context app,
                                             @Twitter @NonNull List<Interceptor> interceptors) {
        final File cacheDir = new File(app.getCacheDir(), "twitter");
        final Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        interceptors.forEach(okHttpBuilder::addInterceptor);

        okHttpBuilder.cache(cache);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);

        return okHttpBuilder.build();
    }

    @Twitter
    @Provides
    @Singleton
    public Retrofit provideTwitterApi(@Twitter @NonNull OkHttpClient okHttpClient,
                                      @NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_TWITTER_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
