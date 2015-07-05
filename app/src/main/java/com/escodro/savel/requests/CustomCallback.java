package com.escodro.savel.requests;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Custom {@link retrofit.Callback} which notifies when the request finished, whether it is success
 * or failure.
 * <p/>
 * Created by IgorEscodro on 28/06/15.
 */
public abstract class CustomCallback<T> implements retrofit.Callback<T> {

    /**
     * {@link OnFinishListener} reference.
     */
    private final OnFinishListener mListener;

    /**
     * Create a new instance of {@link CustomCallback}.
     *
     * @param listener listener to be notified
     */
    public CustomCallback(OnFinishListener listener) {
        mListener = listener;
    }

    /**
     * Action to be taken when the request responds successfully and after that notifies the {@link
     * OnFinishListener} that the {@link CustomCallback} is finished.
     *
     * @param t        request response
     * @param response callback response
     */
    @Override
    public void success(T t, Response response) {
        onSuccess(t, response);
        mListener.onFinish();
    }

    /**
     * Action to be taken when the request responds failed and after that notifies the {@link
     * OnFinishListener} that the {@link CustomCallback} is finished.
     *
     * @param error RetroFit error instance
     */
    @Override
    public void failure(RetrofitError error) {
        onFailure(error);
        mListener.onFinish();
    }

    /**
     * Method responsible to handle the RetroFit successfully response.
     *
     * @param t        request response
     * @param response callback response
     */
    public abstract void onSuccess(T t, Response response);

    /**
     * Method responsible to handle the RetroFit failure response.
     *
     * @param error RetroFit error instance
     */
    public abstract void onFailure(RetrofitError error);

    /**
     * Interface to notify when a {@link CustomCallback} finishes.
     */
    public interface OnFinishListener {

        /**
         * Method notified when a {@link CustomCallback} finishes.
         */
        void onFinish();
    }
}
