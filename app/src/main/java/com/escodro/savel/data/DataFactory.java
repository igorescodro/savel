package com.escodro.savel.data;

import com.escodro.savel.MusicApp;
import com.escodro.savel.requests.RequestManager;

/**
 * Class responsible to create a {@link Data} object. Because of the creation of the object is not
 * synchronous due dependence of the server response, it notifies the {@link
 * RequestManager.OnRequestFinishListener} with the object created when everything is finished.
 * <p/>
 * Created by IgorEscodro on 03/07/15.
 */
public class DataFactory {

    /**
     * Request the creation of a {@link Data} object. When it is created, the listener will be
     * notified.
     *
     * @param listener listener to be notified when the object is created
     */
    public void requestData(RequestManager.OnRequestFinishListener listener) {
        final RequestManager manager = MusicApp.getRequestManager();
        manager.execute(listener);
    }
}
