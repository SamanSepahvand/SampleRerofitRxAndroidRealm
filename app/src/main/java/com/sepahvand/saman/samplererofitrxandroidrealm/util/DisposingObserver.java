package com.sepahvand.saman.samplererofitrxandroidrealm.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Saman on 8/22/20.
 * Custom object to overwrite default Observer. The main purpose is to add
 * DisposableManager.add(Disposable) automatically.
 */

public class DisposingObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
        DisposableManager.add(d);
    }

    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
