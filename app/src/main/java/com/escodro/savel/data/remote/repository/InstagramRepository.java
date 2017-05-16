package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.instagram.InstagramTimeline;
import com.escodro.savel.data.remote.service.InstagramService;
import com.escodro.savel.injection.qualifier.Instagram;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link InstagramService}
 * <p/>
 * Created by Igor Escodro on 04/05/17.
 */
public class InstagramRepository {

    private final InstagramService mService;

    @Inject
    public InstagramRepository(@Instagram Retrofit retrofit) {
        mService = retrofit.create(InstagramService.class);
    }

    /**
     * Get a {@link InstagramTimeline} from {@link InstagramService}. If an
     * error occur during the request, an empty {@link InstagramTimeline} will be returned.
     *
     * @param username artist Instagram username
     *
     * @return observable of Instagram timeline
     */
    public Observable<InstagramTimeline> getArtistTimeline(String username) {
        return mService.getArtistTimeline(username)
                .onErrorReturnItem(new InstagramTimeline())
                .subscribeOn(Schedulers.newThread());
    }
}
