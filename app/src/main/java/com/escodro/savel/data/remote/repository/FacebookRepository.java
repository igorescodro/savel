package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.facebook.FacebookResponse;
import com.escodro.savel.data.remote.service.FacebookService;
import com.escodro.savel.injection.qualifier.Facebook;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link FacebookService}
 * <p/>
 * Created by Igor Escodro on 15/05/17.
 */
public class FacebookRepository {

    private final FacebookService mService;

    @Inject
    public FacebookRepository(@Facebook Retrofit retrofit) {
        mService = retrofit.create(FacebookService.class);
    }

    /**
     * Get an {@link FacebookResponse} containing the artist timeline from {@link FacebookService}.
     * If an error occurs during the request, an empty {@link FacebookResponse} will be returned.
     *
     * @param username artist Facebook username
     *
     * @return observable of Facebook response
     */
    public Observable<FacebookResponse> getTimeline(String username) {
        return mService.getTimeline(username)
                .onErrorReturnItem(new FacebookResponse())
                .subscribeOn(Schedulers.newThread());
    }
}
