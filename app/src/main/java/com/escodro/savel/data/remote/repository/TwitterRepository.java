package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.data.remote.service.TwitterService;
import com.escodro.savel.injection.qualifier.Twitter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link TwitterService}.
 * <p/>
 * Created by Igor Escodro on 26/04/17.
 */
public class TwitterRepository {

    private final TwitterService mService;

    @Inject
    public TwitterRepository(@Twitter Retrofit retrofit) {
        mService = retrofit.create(TwitterService.class);
    }

    /**
     * Get a {@link List} of {@link TwitterTweet}(Timeline) from {@link TwitterService}. If an
     * error occur during the request, a empty {@link ArrayList} will be returned.
     *
     * @param username artist Twitter username
     *
     * @return observable of Tweets List entity
     */
    public Observable<List<TwitterTweet>> getArtistTimeline(String username) {
        return mService.getArtistTimeline(username).onErrorReturnItem(new ArrayList<>());
    }
}
