package com.sepahvand.saman.samplererofitrxandroidrealm.realm;

import android.app.Application;

import com.sepahvand.saman.samplererofitrxandroidrealm.model.Result;

import java.util.List;


import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Saman on 8/22/20.
 */

public class RealmDb {

    public static void init(Application app) {
        Realm.init(app);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static Realm getRealm() {
        return Realm.getDefaultInstance();
    }

    public static void saveResult(List<Result> results) {
        Realm realm = getRealm();
        realm.beginTransaction();
        realm.delete(Result.class);
        for (Result result: results) {
            realm.copyToRealmOrUpdate(result);
        }
        realm.commitTransaction();
        realm.close();
    }


    public static Observable<String> getCountryCodeAndNameAsObservable() {

        Realm realm = getRealm();
        RealmResults<Result> results = realm.where(Result.class).findAll();

        // build a line in the format of CountryName[CountryCode]
        StringBuilder sb = new StringBuilder();
        for (Result result: results) {
            sb.append(result.getName()+"["+result.getCode()+"]"+"\n");
        }
        return Observable.just(sb.toString());
    }


    public static Observable<String> getCountryCodeAsObservable() {
        Realm realm = getRealm();
        RealmResults<Result> results = realm.where(Result.class).findAll();
        List<Result> unmanagedResults = realm.copyFromRealm(results);

        StringBuilder sb = new StringBuilder();
        for (Result result: unmanagedResults) {
            sb.append(result.getCode()+'\n');
        }
        realm.close();

        return Observable.just(sb.toString());
    }
}
