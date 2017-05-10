package com.escodro.savel.data.remote.repository;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.SavelTweet;
import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.data.remote.service.TwitterService;
import com.escodro.savel.injection.qualifier.Twitter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link TwitterService}.
 * <p/>
 * Created by Igor Escodro on 26/04/17.
 */
public class TwitterRepository {

    private final TwitterService mService;

    @Inject
    Provider<SavelTweet> mTweetProvider;

    @Inject
    public TwitterRepository(@Twitter Retrofit retrofit) {
        mService = retrofit.create(TwitterService.class);
    }

    /**
     * Get a {@link List} of {@link SavelTweet}(Timeline) from {@link TwitterService}. If an
     * error occur during the request, a empty {@link ArrayList} will be returned.<br>
     * If the <code>username</code> is empty, it only returns an {@link Observable} of
     * {@link List} of {@link SavelTweet}, saving one call to {@link TwitterService} because
     * <code>username</code> is an optional parameter in this endpoint.
     *
     * @param username artist Twitter username
     *
     * @return observable of Tweets List entity
     */
    public Observable<List<SavelTweet>> getArtistTimeline(String username) {
        Observable<List<SavelTweet>> observable = Observable.just(new ArrayList<>());
        if (username != null) {
            observable = mService.getArtistTimeline(username)
                    .map(convertToTwitterList())
                    .onErrorReturnItem(new ArrayList<>())
                    .subscribeOn(Schedulers.newThread());
        }
        return observable;
    }

    @NonNull
    private Function<List<TwitterTweet>, List<SavelTweet>> convertToTwitterList() {
        return tweetList -> {
            final List<SavelTweet> tweets = new ArrayList<>();
            for (TwitterTweet tweetEntity : tweetList) {
                final SavelTweet tweet = mTweetProvider.get();
                tweet.setTweetEntity(tweetEntity);
                tweets.add(tweet);
            }
            return tweets;
        };
    }
}
