package com.sepahvand.saman.samplererofitrxandroidrealm;

import android.app.Application;

import com.sepahvand.saman.samplererofitrxandroidrealm.realm.RealmDb;


/**
 * Created by Saman on 8/22/20.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmDb.init(this);
    }
}
