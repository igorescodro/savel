package com.escodro.savel.util.adapter;

import android.content.Context;
import android.support.annotation.StringRes;

import com.escodro.savel.R;
import com.escodro.savel.data.model.NetworkError;

import java.net.UnknownHostException;

import javax.inject.Inject;

import retrofit2.HttpException;

/**
 * Handler to convert an {@link Throwable} in a {@link NetworkError} to be displayed in the
 * Network Error layout.
 * <p/>
 * Created by Igor Escodro on 28/04/17.
 */
public class NetworkErrorHandler {

    /**
     * Message to represent that the webservice is not available at the time.
     */
    private static final String SERVICE_UNAVAILABLE = "HTTP 503";

    @Inject
    public NetworkErrorHandler() {
    }

    @Inject
    NetworkError mNetworkErrorProvider;

    @Inject
    Context mContext;

    /**
     * Converts the {@link Throwable} in a {@link NetworkError} to be displayed in the Network
     * Error layout.
     *
     * @param throwable throwable returned in the request
     *
     * @return NetworkError object
     */
    public NetworkError handleError(Throwable throwable) {
        if (throwable instanceof UnknownHostException) {
            getUnknownHostError();
        } else if (isServerUnavailable(throwable)) {
            getServiceUnavailableError();
        }
        return mNetworkErrorProvider;
    }

    private void getUnknownHostError() {
        mNetworkErrorProvider.setError(
                getStringFromResource(R.string.network_error_no_connection_title),
                getStringFromResource(R.string.network_error_no_connection_description),
                android.R.drawable.ic_delete);
    }

    private void getServiceUnavailableError() {
        mNetworkErrorProvider.setError(
                getStringFromResource(R.string.network_error_service_unavailable_title),
                getStringFromResource(R.string.network_error_service_unavailable_description),
                android.R.drawable.presence_busy);
    }

    private String getStringFromResource(@StringRes int resId) {
        return mContext.getString(resId);
    }

    /**
     * Verify if the server threw an HTTP 503, meaning the server is unavailable at the request
     * time.
     *
     * @param throwable error
     *
     * @return <code>true</code> if the server is unavailable, <code>false</code> otherwise
     */
    public boolean isServerUnavailable(Throwable throwable) {
        boolean result = false;
        if (throwable instanceof HttpException) {
            final String message = throwable.getMessage();
            if (message != null && message.contains(SERVICE_UNAVAILABLE)) {
                result = true;
            }
        }
        return result;
    }
}
