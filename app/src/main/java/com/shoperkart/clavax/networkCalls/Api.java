package com.shoperkart.clavax.networkCalls;

import com.shoperkart.clavax.models.Response;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("zipcodes/")
    Call<Response> getZipCodes(@Header("token") String token, @Header("source") String source);

}
