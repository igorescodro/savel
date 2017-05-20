package com.escodro.savel.injection.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.escodro.savel.BuildConfig;
import com.escodro.savel.injection.qualifier.Discogs;
import com.escodro.savel.injection.qualifier.Facebook;
import com.escodro.savel.injection.qualifier.Instagram;
import com.escodro.savel.injection.qualifier.MusicBrainz;
import com.escodro.savel.injection.qualifier.Spotify;
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
    OkHttpClient provideMusicBrainzClient(Context app,
                                          @MusicBrainz @NonNull List<Interceptor>
                                                  interceptors) {
        return getOkHttpClient(app, interceptors, "musicbrainz");
    }

    @MusicBrainz
    @Provides
    @Singleton
    Retrofit provideMusicBrainzApi(@MusicBrainz @NonNull OkHttpClient okHttpClient,
                                   @NonNull Gson gson) {
        return getRetrofit(okHttpClient, gson, BuildConfig.API_MUSICBRAINZ_ENDPOINT);
    }

    @Discogs
    @Provides
    @Singleton
    OkHttpClient provideDiscogsClient(Context app,
                                      @Discogs @NonNull List<Interceptor> interceptors) {
        return getOkHttpClient(app, interceptors, "discogs");
    }

    @Discogs
    @Provides
    @Singleton
    Retrofit provideDiscogsApi(@Discogs @NonNull OkHttpClient okHttpClient,
                               @NonNull Gson gson) {
        return getRetrofit(okHttpClient, gson, BuildConfig.API_DISCOGS_ENDPOINT);
    }

    @Twitter
    @Provides
    @Singleton
    OkHttpClient provideTwitterClient(Context app,
                                      @Twitter @NonNull List<Interceptor> interceptors) {
        return getOkHttpClient(app, interceptors, "twitter");
    }

    @Twitter
    @Provides
    @Singleton
    Retrofit provideTwitterApi(@Twitter @NonNull OkHttpClient okHttpClient,
                               @NonNull Gson gson) {
        return getRetrofit(okHttpClient, gson, BuildConfig.API_TWITTER_ENDPOINT);
    }

    @Spotify
    @Provides
    @Singleton
    OkHttpClient provideSpotifyClient(Context app,
                                      @Spotify @NonNull List<Interceptor> interceptors) {
        return getOkHttpClient(app, interceptors, "spotify");
    }

    @Spotify
    @Provides
    @Singleton
    Retrofit provideSpotifyApi(@Spotify @NonNull OkHttpClient okHttpClient,
                               @NonNull Gson gson) {
        return getRetrofit(okHttpClient, gson, BuildConfig.API_SPOTIFY_ENDPOINT);
    }

    @Instagram
    @Provides
    @Singleton
    OkHttpClient provideInstagramClient(Context app,
                                        @Instagram @NonNull List<Interceptor> interceptors) {
        return getOkHttpClient(app, interceptors, "instagram");
    }

    @Instagram
    @Provides
    @Singleton
    Retrofit provideInstagramApi(@Instagram @NonNull OkHttpClient okHttpClient,
                                 @NonNull Gson gson) {
        return getRetrofit(okHttpClient, gson, BuildConfig.API_INSTAGRAM_ENDPOINT);
    }

    @Facebook
    @Provides
    @Singleton
    OkHttpClient provideFacebookClient(Context app,
                                       @Facebook @NonNull List<Interceptor> interceptors) {
        return getOkHttpClient(app, interceptors, "facebook");
    }

    @Facebook
    @Provides
    @Singleton
    Retrofit provideFacebookApi(@Facebook @NonNull OkHttpClient okHttpClient,
                                @NonNull Gson gson) {
        return getRetrofit(okHttpClient, gson, BuildConfig.API_FACEBOOK_ENDPOINT);
    }

    @NonNull
    private OkHttpClient getOkHttpClient(Context app,
                                         @NonNull List<Interceptor> interceptors,
                                         @NonNull String cacheName) {
        final File cacheDir = new File(app.getCacheDir(), cacheName);
        final Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        for (Interceptor interceptor : interceptors) {
            okHttpBuilder.addInterceptor(interceptor);
        }

        okHttpBuilder.cache(cache);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);

        return okHttpBuilder.build();
    }

    @NonNull
    private Retrofit getRetrofit(@NonNull OkHttpClient okHttpClient,
                                 @NonNull Gson gson, @NonNull String endpoint) {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
