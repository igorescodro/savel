package com.escodro.savel.requests;

import com.escodro.savel.data.Data;

import java.util.concurrent.Semaphore;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Class responsible to handle the Request and its lifecycle.
 * <p/>
 * Created by IgorEscodro on 28/06/15.
 */
public abstract class Request<T> implements CustomCallback.OnFinishListener {

    /**
     * {@link Semaphore} reference to handle the given permit.
     */
    private Semaphore mSemaphore;

    /**
     * {@link Data} reference to be updated when the request finish.
     */
    private Data mData;

    /**
     * {@link RequestState} reference to hold the state.
     */
    private RequestState mState;

    /**
     * {@link CustomCallback} reference to be used in the {@link Request}s.
     */
    private CustomCallback<T> mCallback = new CustomCallback<T>(this) {

        @Override
        public void onSuccess(T t, Response response) {
            onRequestSuccess(t, response);
        }

        @Override
        public void onFailure(RetrofitError error) {
            onRequestFailure(error);
        }
    };

    /**
     * Create a new instance of {@link Request}.
     */
    public Request() {
        mState = RequestState.IDLE;
    }

    /**
     * Starts the request.
     *
     * @param semaphore {@link Semaphore} reference to handle the permit
     * @param data      {@link Data} to be updated after the request data
     */
    public void startRequest(Semaphore semaphore, Data data) {
        mSemaphore = semaphore;
        mData = data;
        onCreateRequest(mCallback);
        mState = RequestState.STARTED;
    }

    /**
     * When the {@link Request} finishes, it releases the {@link Semaphore} permit and set the
     * result in {@link Data} instance.
     */
    @Override
    public void onFinish() {
        mState = RequestState.FINISHED;
        setResult(mData);
        mSemaphore.release();
    }

    /**
     * Get the {@link Request} state.
     *
     * @return {@link Request} state
     */
    public RequestState getStatus() {
        return mState;
    }

    /**
     * Method responsible to create the request and send to the server. All the Retrofit
     * implementation should be done in this method.
     *
     * @param callback {@link CustomCallback} to be used in the {@link Request}
     */
    protected abstract void onCreateRequest(CustomCallback<T> callback);

    /**
     * Get an unique id for the {@link Request}.
     *
     * @return {@link Request} unique id
     */
    protected abstract String getRequestId();

    /**
     * Method responsible to set the result in the {@link Data} instance. Each API request is
     * responsible to do it in this method.
     *
     * @param data {@link Data} instance to set the result
     */
    protected abstract void setResult(Data data);

    /**
     * Method responsible to handle the RetroFit successfully response.
     *
     * @param t        request response
     * @param response callback response
     */
    protected abstract void onRequestSuccess(T t, Response response);

    /**
     * Method responsible to handle the RetroFit successfully response.
     *
     * @param error {@link RetrofitError} instance
     */
    protected abstract void onRequestFailure(RetrofitError error);
}
