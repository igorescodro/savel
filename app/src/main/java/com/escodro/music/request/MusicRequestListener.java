package com.escodro.music.request;

/**
 * Created by IgorEscodro on 24/05/15.
 */
public interface MusicRequestListener<T> {

    public void onRequestFinished(T params);
}
