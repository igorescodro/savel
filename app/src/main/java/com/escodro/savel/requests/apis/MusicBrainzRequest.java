package com.escodro.savel.requests.apis;

import com.escodro.savel.SavelApp;
import com.escodro.savel.data.Data;
import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.escodro.savel.network.musicbrainz.model.MusicBrainzResponse;
import com.escodro.savel.requests.CustomCallback;
import com.escodro.savel.requests.Request;
import com.escodro.savel.requests.RequestManager;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Create an {@link MusicBrainzAPI} {@link Request} to be used in the {@link RequestManager}.
 * <p/>
 * Created by IgorEscodro on 09/07/15.
 */
public class MusicBrainzRequest extends Request<MusicBrainzResponse> {

    /**
     * {@link MusicBrainzAPI} id reference
     */
    private final String mMbid;

    /**
     * {@link MusicBrainzResponse} result reference.
     */
    private MusicBrainzResponse mResult;

    /**
     * Create a new instance of {@link MusicBrainzAPI}.
     *
     * @param mbid {@link MusicBrainzAPI} id
     */
    public MusicBrainzRequest(String mbid) {
        mMbid = mbid;
    }

    @Override
    protected void onCreateRequest(CustomCallback<MusicBrainzResponse> callback) {
        SavelApp.getMusicBrainzAPI().getArtistRecordings(mMbid, callback);
    }

    @Override
    protected String getRequestId() {
        return MusicBrainzRequest.class.getName();
    }

    @Override
    protected void onRequestSuccess(MusicBrainzResponse musicBrainzResponse, Response response) {
        mResult = musicBrainzResponse;
    }

    @Override
    protected void onRequestFailure(RetrofitError error) {
        //Do nothing
    }

    @Override
    protected void setResult(Data data) {
        data.setMusicBrainzResponse(mResult);
    }
}
