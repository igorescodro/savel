package com.escodro.music.request;

/**
 * Interface to notify when the Request is finished and the UI can be updated with the data.
 * <p/>
 * Created by IgorEscodro on 24/05/15.
 */
public interface MusicRequestListener<T> {

    /**
     * Notify on request finished.
     *
     * @param result result fro the equest
     */
    void onRequestFinished(T result);
}
