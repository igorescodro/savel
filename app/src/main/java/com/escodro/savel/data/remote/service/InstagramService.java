package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.instagram.InstagramTimeline;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service API containing the methods to communicate with Instagram endpoints.
 * <p/>
 * Created by Igor Escodro on 04/05/17.
 *
 * @see <a href="https://www.instagram.com/developer/">Instagram API Documentation</a>
 */
public interface InstagramService {

    /**
     * Connect to media endpoint and retrieve a {@link InstagramTimeline} based on the username.
     *
     * @param artistId artist Instagram username
     *
     * @return observable of Instagram timeline
     *
     * @see <a href="https://www.instagram.com/developer/endpoints/users/#get_users">User Endpoints
     * | Instagram Developers</a>
     * @see <a href="http://stackoverflow.com/a/33783840">How can I get a user's media from
     * Instagram without authenticating as a user? | Stack Overflow</a>
     */
    @GET("{artistId}/media")
    Observable<InstagramTimeline> getArtistTimeline(@Path("artistId") String artistId);
}
