package com.escodro.music.request;

import android.os.AsyncTask;

import com.echonest.api.v4.EchoNestAPI;
import com.escodro.music.MusicApp;

/**
 * Created by IgorEscodro on 24/05/15.
 */
public abstract class MusicRequest<Params, Progress, Result> extends AsyncTask<Params, Progress,
        Result> {

    private MusicRequestListener mListener;

    private EchoNestAPI echoNestAPI;

    public MusicRequest(MusicRequestListener listener) {
        mListener = listener;
    }

    @Override
    protected void onPreExecute() {
        echoNestAPI = MusicApp.getInstance().getEchoNestAPI();
    }

    @Override
    protected void onPostExecute(Result result) {
        mListener.onRequestFinished(result);
    }

    protected EchoNestAPI getAPI() {
        return echoNestAPI;
    }
}
