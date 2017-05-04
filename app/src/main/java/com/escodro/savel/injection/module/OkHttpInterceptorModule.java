package com.escodro.savel.injection.module;

import android.support.annotation.NonNull;

import com.escodro.savel.BuildConfig;
import com.escodro.savel.injection.qualifier.Discogs;
import com.escodro.savel.injection.qualifier.Instagram;
import com.escodro.savel.injection.qualifier.MusicBrainz;
import com.escodro.savel.injection.qualifier.Spotify;
import com.escodro.savel.injection.qualifier.Twitter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import timber.log.Timber;

/**
 * {@link Module} to provide the {@link Interceptor}s to the Service API requests.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
@Module
public class OkHttpInterceptorModule {

    @Provides
    @Singleton
    @NonNull
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                message -> Timber.tag("OkHttp").d(message));
        interceptor.setLevel(Level.BODY);
        return interceptor;
    }

    @MusicBrainz
    @Provides
    @Singleton
    @NonNull
    Interceptor provideMusicBrainzInterceptor() {
        return chain -> {
            Request request = chain.request();
            final HttpUrl url = request.url().newBuilder().addQueryParameter("fmt", "json").build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        };
    }

    @MusicBrainz
    @Provides
    @Singleton
    @NonNull
    List<Interceptor> provideMusicBrainzInterceptors(
            @NonNull HttpLoggingInterceptor logInterceptor,
            @MusicBrainz @NonNull Interceptor interceptor) {
        return Arrays.asList(logInterceptor, interceptor);
    }

    @Discogs
    @Provides
    @Singleton
    @NonNull
    Interceptor provideDiscogsInterceptor() {
        return chain -> {
            final Request request = chain.request().newBuilder().addHeader("Authorization",
                    "Discogs token=" + BuildConfig.KEY_DISCOGS_API).build();
            return chain.proceed(request);
        };
    }

    @Discogs
    @Provides
    @Singleton
    @NonNull
    List<Interceptor> provideDiscogsInterceptors(
            @NonNull HttpLoggingInterceptor logInterceptor,
            @Discogs @NonNull Interceptor interceptor) {
        return Arrays.asList(logInterceptor, interceptor);
    }

    @Twitter
    @Provides
    @Singleton
    @NonNull
    Interceptor provideTwitterInterceptor() {
        return chain -> {
            Request request = chain.request();
            final HttpUrl url = request.url().newBuilder()
                    .addQueryParameter("exclude_replies", "true")
                    .build();

            request = request.newBuilder()
                    .addHeader("Authorization",
                            "Bearer " + BuildConfig.KEY_TWITTER_API)
                    .url(url)
                    .build();
            return chain.proceed(request);
        };
    }

    @Twitter
    @Provides
    @Singleton
    @NonNull
    List<Interceptor> provideTwitterInterceptors(
            @NonNull HttpLoggingInterceptor logInterceptor,
            @Twitter @NonNull Interceptor interceptor) {
        return Arrays.asList(logInterceptor, interceptor);
    }

    @Spotify
    @Provides
    @Singleton
    @NonNull
    Interceptor provideSpotifyInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Spotify
    @Provides
    @Singleton
    @NonNull
    List<Interceptor> provideSpotifyInterceptors(
            @NonNull HttpLoggingInterceptor logInterceptor,
            @Spotify @NonNull Interceptor interceptor) {
        return Arrays.asList(logInterceptor, interceptor);
    }

    @Instagram
    @Provides
    @Singleton
    @NonNull
    Interceptor provideInstagramInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Instagram
    @Provides
    @Singleton
    @NonNull
    List<Interceptor> provideInstagramInterceptors(
            @NonNull HttpLoggingInterceptor logInterceptor,
            @Spotify @NonNull Interceptor interceptor) {
        return Arrays.asList(logInterceptor, interceptor);
    }
}
