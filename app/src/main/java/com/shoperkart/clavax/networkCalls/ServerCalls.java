package com.shoperkart.clavax.networkCalls;

import com.shoperkart.clavax.interfaces.Interfaces;
import com.shoperkart.clavax.models.Response;
import com.shoperkart.clavax.utils.KEYS;

import retrofit2.Call;
import retrofit2.Callback;

public class ServerCalls {

    private final Api api;

    public ServerCalls(Api api) {
        this.api = api;
    }

    public void getZipCodes(Interfaces.OnGetResponse onGetResponse) {
        api.getZipCodes(KEYS.TOKEN, "ANDROID").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful() && response.code() == 200)
                    onGetResponse.onSuccess(response.body());
                else onGetResponse.onFailure(response.message());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                onGetResponse.onFailure(t.getMessage());
            }
        });
    }
}
