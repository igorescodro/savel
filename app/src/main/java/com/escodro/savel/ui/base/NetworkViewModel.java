package com.escodro.savel.ui.base;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.escodro.savel.data.model.NetworkError;
import com.escodro.savel.util.adapter.NetworkErrorAdapter;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Generic ViewModel to handle the network flow. This view model is responsible to show and hide
 * the loading and network error screen and implement the "retry" button behavior.
 * <h1>The defined layouts of network error and loading must be included in the featured layout
 * with its respective fields set through Data Binding.</h1>
 * <p/>
 * Created by IgorEscodro on 29/04/17.
 */
public abstract class NetworkViewModel<T> extends BaseObservable {

    /**
     * {@link ObservableField} to represent if the network error screen should be show.
     * <h1>This attribute must only be used to Data Binding.</h1>
     */
    public final ObservableField<Integer> networkErrorVisibility;

    /**
     * {@link ObservableField} to represent if the loading screen should be show.
     * <h1>This attribute must only be used to Data Binding.</h1>
     */
    public final ObservableField<Integer> loadingVisibility;

    /**
     * {@link ObservableField} to represent the {@link NetworkError} message to be displayed at
     * Network Error screen.
     * <h1>This attribute must only be used to Data Binding.</h1>
     */
    public final ObservableField<NetworkError> networkError;

    @Inject
    NetworkErrorAdapter mNetworkErrorAdapter;

    public NetworkViewModel() {
        networkErrorVisibility = new ObservableField<>(View.GONE);
        loadingVisibility = new ObservableField<>(View.GONE);
        networkError = new ObservableField<>();
    }

    /**
     * Shows the loading screen and subscribe to the {@link Observable} which will receive the
     * response (success or failure).
     */
    protected void loadData() {
        showLoadingScreen();
        getObservable().subscribe(this::setResult, this::handleError);
    }

    /**
     * Success method to be used in the {@link Observable#subscribe()}. It hides the loading
     * screen and calls {@link this#onResult(Object)} from child to set the value and make its
     * own flow.
     *
     * @param result result from observable request
     */
    private void setResult(T result) {
        hideLoadingScreen();
        onResult(result);
    }

    /**
     * Failure method to be used in the {@link Observable#subscribe()}. It handles the error
     * thrown by the observable and shows in a more friendly format to the user.
     *
     * @param throwable error thrown by the observables
     */
    private void handleError(Throwable throwable) {
        showNetworkErrorScreen(throwable);
    }

    /**
     * Handles the {@link Throwable} and show the error screen with a more friendly message to
     * the user
     *
     * @param throwable error thrown by the observables
     */
    private void showNetworkErrorScreen(Throwable throwable) {
        networkError.set(mNetworkErrorAdapter.handleError(throwable));
        networkErrorVisibility.set(View.VISIBLE);
        loadingVisibility.set(View.GONE);
    }

    /**
     * Show the loading screen.
     */
    private void showLoadingScreen() {
        loadingVisibility.set(View.VISIBLE);
        networkErrorVisibility.set(View.GONE);
    }

    /**
     * Hide the loading screen.
     */
    private void hideLoadingScreen() {
        loadingVisibility.set(View.GONE);
    }

    /**
     * Provide the default implementation of network error screen retry button. When clicked, it
     * execute and subscribe to the given {@link Observable}.
     *
     * @return default OnClickListener implementation
     */
    public View.OnClickListener onClickRetryButton() {
        return view -> loadData();
    }

    /**
     * Get the {@link Observable} related to the ViewModel action flow.
     *
     * @return observable to be executed and subscribed
     */
    public abstract Observable<T> getObservable();

    /**
     * Method called when the {@link Observable} execution was successful.
     *
     * @param result result from observable
     */
    public abstract void onResult(T result);
}
