package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.twitter.TwitterTweet;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Service API containing the methods to communicate with Twitter endpoints.
 * <p/>
 * Created by Igor Escodro on 26/04/17.
 *
 * @see <a href="https://dev.twitter.com/rest/public">Twitter REST API Documentation</a>
 */

public interface TwitterService {

    /**
     * Connect to Twitter timeline endpoint and retrieve a {@link List} of {@link TwitterTweet}
     * based on the artist username
     *
     * @param username artist Twitter username
     *
     * @return observable of Tweets List entity
     *
     * @see <a href="https://dev.twitter.com/rest/reference/get/statuses/user_timeline">Twitter
     * Developer Documentation | GET statuses/user_timeline</a>
     */
    @GET("statuses/user_timeline.json")
    Observable<List<TwitterTweet>> getArtistTimeline(@Query("screen_name") String username);
}
