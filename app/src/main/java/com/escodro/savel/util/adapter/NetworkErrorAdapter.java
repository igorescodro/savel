package com.escodro.savel.util.adapter;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.escodro.savel.R;
import com.escodro.savel.data.model.NetworkError;

import java.net.UnknownHostException;

import javax.inject.Inject;

import retrofit2.HttpException;

/**
 * Adapter to convert an {@link Throwable} in a {@link NetworkError} to be displayed in the
 * Network Error layout.
 * <p/>
 * Created by Igor Escodro on 28/04/17.
 */
public class NetworkErrorAdapter {

    /**
     * Message to represent that the webservice is not available at the time.
     */
    private static final String SERVICE_UNAVAILABLE = "Service Unavailable";

    @Inject
    public NetworkErrorAdapter() {
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
     * @return NetworkError object
     */
    public NetworkError handleError(Throwable throwable) {
        if (throwable instanceof UnknownHostException) {
            getUnknownHostError();
        } else if (throwable instanceof HttpException) {
            if (TextUtils.equals(throwable.getMessage(), SERVICE_UNAVAILABLE)) {
                getServiceUnavailableError();
            }
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
}
