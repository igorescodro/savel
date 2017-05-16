package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.facebook.FacebookResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service API containing the methods to communicate with Instagram endpoints.
 * <p/>
 * Created by Igor Escodro on 15/05/17.
 *
 * @see <a href="https://developers.facebook.com/docs/graph-api">Facebook Graph API
 * Documentation</a>
 */

public interface FacebookService {

    /**
     * Constant to represent the fields that will be retrieve from Facebook API.
     */
    String FIELDS = "full_picture," +
            "message," +
            "created_time," +
            "icon," +
            "permalink_url," +
            "source," +
            "from,first_name";

    /**
     * Connect to posts endpoint and retrieve a {@link FacebookResponse} containing the artist
     * timeline based on the username.
     *
     * @param artistId artist Facebook username
     *
     * @return observable of Facebook response
     *
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/v2.9/user/feed">User
     * feed | Facebook for Developers</a>
     */
    @GET("{artistId}/feed?fields=" + FIELDS)
    Observable<FacebookResponse> getTimeline(@Path("artistId") String artistId);
}
