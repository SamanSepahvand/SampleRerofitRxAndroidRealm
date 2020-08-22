package com.sepahvand.saman.samplererofitrxandroidrealm.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sepahvand.saman.samplererofitrxandroidrealm.model.Response;
import com.sepahvand.saman.samplererofitrxandroidrealm.net.service.Request;

import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saman on 8/22/20.
 */

public class APIClient {

    private static final String HOST_URL = "https://api.openaq.org/";

    public static Observable<Response> fetchData() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        Retrofit tmpRetrofit = new Retrofit.Builder()
                .baseUrl(HOST_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        Request service = tmpRetrofit.create(Request.class);
        return service.fetchData();
    }
}
