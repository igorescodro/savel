package com.escodro.music.request;

import android.os.AsyncTask;

import com.echonest.api.v4.EchoNestAPI;
import com.escodro.music.MusicApp;

/**
 * Request using {@link EchoNestAPI}. It handles the connection and callback to update the UI.
 * <p/>
 * Created by IgorEscodro on 24/05/15.
 */
public abstract class MusicRequest<Params, Progress, Result> extends AsyncTask<Params, Progress,
        Result> {

    /**
     * {@link MusicRequestListener} reference.
     */
    private MusicRequestListener mListener;

    /**
     * {@link EchoNestAPI} reference.
     */
    private EchoNestAPI mEchoNestAPI;

    /**
     * Default constructor.
     *
     * @param listener {@link MusicRequestListener} callback
     */
    public MusicRequest(MusicRequestListener listener) {
        mListener = listener;
    }

    /**
     * Get instance from {@link EchoNestAPI} to create the request.
     */
    @Override
    protected void onPreExecute() {
        mEchoNestAPI = MusicApp.getInstance().getEchoNestAPI();
    }

    /**
     * Notify the callback to update the UI after the request is executed.
     *
     * @param result result from the request
     */
    @Override
    protected void onPostExecute(Result result) {
        mListener.onRequestFinished(result);
    }

    /**
     * Get {@link EchoNestAPI}.
     *
     * @return {@link EchoNestAPI} reference
     */
    protected EchoNestAPI getAPI() {
        return mEchoNestAPI;
    }
}
