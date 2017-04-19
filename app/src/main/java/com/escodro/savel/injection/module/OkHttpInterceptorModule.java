package com.escodro.savel.injection.module;

import android.support.annotation.NonNull;

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
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                message -> Timber.tag("OkHttp").d(message));
        interceptor.setLevel(Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    @NonNull
    public Interceptor provideMusicBrainzInteceptor() {
        return chain -> {
            Request request = chain.request();
            final HttpUrl url = request.url().newBuilder().addQueryParameter("fmt", "json").build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    @NonNull
    public List<Interceptor> provideMusicBrainzInterceptors(
            @NonNull HttpLoggingInterceptor logInterceptor, @NonNull Interceptor interceptor) {
        return Arrays.asList(logInterceptor, interceptor);
    }
}
