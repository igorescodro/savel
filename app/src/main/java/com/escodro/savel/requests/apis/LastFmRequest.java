package com.escodro.savel.requests.apis;

import com.escodro.savel.SavelApp;
import com.escodro.savel.model.Artist;
import com.escodro.savel.network.lastfm.LastFmAPI;
import com.escodro.savel.network.lastfm.model.LastFmResponse;
import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.escodro.savel.requests.CustomCallback;
import com.escodro.savel.requests.Request;
import com.escodro.savel.requests.RequestManager;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Create an {@link LastFmAPI} {@link Request} to be used in the {@link RequestManager}.
 * <p/>
 * Created by IgorEscodro on 06/07/15.
 */
public class LastFmRequest extends Request<LastFmResponse> {

    /**
     * {@link MusicBrainzAPI} id reference
     */
    private final String mMbid;

    /**
     * {@link LastFmResponse} result reference.
     */
    private LastFmResponse mResult;

    /**
     * Create a new instance of {@link LastFmRequest}.
     *
     * @param mbid {@link MusicBrainzAPI} id
     */
    public LastFmRequest(String mbid) {
        mMbid = mbid;
    }

    @Override
    protected void onCreateRequest(CustomCallback<LastFmResponse> callback) {
        SavelApp.getLastFmAPI().getArtistInfoByMBID(mMbid, callback);
    }

    @Override
    protected String getRequestId() {
        return LastFmRequest.class.getName();
    }

    @Override
    protected void onRequestSuccess(LastFmResponse lastFmResponse, Response response) {
        mResult = lastFmResponse;
    }

    @Override
    protected void onRequestFailure(RetrofitError error) {
        //Do nothing
    }

    @Override
    protected void setResult(Artist artist) {
    }
}
