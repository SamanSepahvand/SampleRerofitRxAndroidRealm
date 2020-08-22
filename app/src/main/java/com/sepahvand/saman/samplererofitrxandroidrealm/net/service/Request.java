package com.sepahvand.saman.samplererofitrxandroidrealm.net.service;



import com.sepahvand.saman.samplererofitrxandroidrealm.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Request {

    @GET("v1/countries")
    Observable<Response> fetchData();
}
