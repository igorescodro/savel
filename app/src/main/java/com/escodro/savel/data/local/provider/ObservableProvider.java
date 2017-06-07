package com.escodro.savel.data.local.provider;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Data provider which can be subscribed and notifies the {@link io.reactivex.Observer}s when a
 * change occurs. The concept of the this provider is very similar with an
 * {@link android.databinding.ObservableField} in Data Binding.<br>
 * The child class must provide a way of storing and retrieving the data (even if only in memory).
 * <p/>
 * Created by Igor Escodro on 05/05/17.
 */
public abstract class ObservableProvider<T> {

    private final PublishSubject<T> mPublishSubject;

    public ObservableProvider() {
        mPublishSubject = PublishSubject.create();
    }

    /**
     * Get the {@link Observable} which will notify every time a change is made in the provider.
     *
     * @return observable to be subscribed
     */
    public Observable<T> getObservable() {
        return mPublishSubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Store the data in the provider.
     *
     * @param data data value
     */
    public void storeData(T data) {
        onStoreData(data);
        notifyChange();
    }

    /**
     * Abstract method to child class provide the storing data mechanism.
     *
     * @param data data value
     */
    protected abstract void onStoreData(T data);

    /**
     * Get the data from the provider.
     *
     * @return data value
     */
    protected abstract T retrieveData();

    /**
     * Notifies the subscribers when a change ws made in the provider.
     */
    private void notifyChange() {
        mPublishSubject.onNext(retrieveData());
    }
}
