package com.escodro.savel.data.local.contract;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Base class containing the common method to all contracts.
 *
 * Created by Igor Escodro on 18/04/17.
 */

public abstract class BaseContract {

    /**
     * Apply the default schedulers to the {@link io.reactivex.Observable} ({@link
     * io.reactivex.Observable#subscribeOn(Scheduler)} and
     * {@link io.reactivex.Observable#observeOn(Scheduler)}.
     *
     * @param <T> type of the observable
     * @return observable with the schedules set
     */
    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
