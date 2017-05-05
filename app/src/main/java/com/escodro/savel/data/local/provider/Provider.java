package com.escodro.savel.data.local.provider;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Igor Escodro on 05/05/17.
 */
public abstract class Provider<T> {

    private final PublishSubject<T> mPublishSubject;

    public Provider() {
        mPublishSubject = PublishSubject.create();
    }

    public Observable<T> getObservable() {
        return mPublishSubject;
    }

    public void storeData(T data) {
        onStoreData(data);
        notifyChange();
    }

    protected abstract void onStoreData(T data);

    protected abstract T retrieveData();

    protected void notifyChange() {
        mPublishSubject.onNext(retrieveData());
    }
}
