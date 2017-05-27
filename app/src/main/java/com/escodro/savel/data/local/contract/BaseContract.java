package com.escodro.savel.data.local.contract;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Base class containing the common method to all contracts.
 * <p>
 * Created by Igor Escodro on 18/04/17.
 */

public abstract class BaseContract {

    /**
     * Apply the default schedulers to the {@link io.reactivex.Observable}.
     *
     * @param <T> type of the observable
     *
     * @return observable with the schedules set
     */
    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
