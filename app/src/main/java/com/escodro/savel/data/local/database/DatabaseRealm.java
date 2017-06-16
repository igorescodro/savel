package com.escodro.savel.data.local.database;

import android.content.Context;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Class responsible to setup the {@link RealmConfiguration} and retrieve its instance for using.
 * <p/>
 * Created by IgorEscodro on 07/06/17.
 */
public class DatabaseRealm {

    private final Context mContext;

    private RealmConfiguration mRealmConfiguration;

    @Inject
    public DatabaseRealm(Context context) {
        mContext = context;
    }

    public void setup() {
        Realm.init(mContext);
        if (mRealmConfiguration == null) {
            mRealmConfiguration = new RealmConfiguration.Builder().build();
            Realm.setDefaultConfiguration(mRealmConfiguration);
        } else {
            throw new IllegalStateException("Database already configured");
        }
    }

    public Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public void close() {
        getRealmInstance().close();
    }
}
