package com.shoperkart.clavax;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shoperkart.clavax.managers.CityManager;
import com.shoperkart.clavax.networkCalls.Api;
import com.shoperkart.clavax.networkCalls.ServerCalls;
import com.shoperkart.clavax.utils.URLS;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController extends Application {

    private static AppController instance;

    private CityManager cityManager;
    private ServerCalls serverCalls;
    private Retrofit retrofit;
    private Api api;

    public static synchronized AppController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private Api getApi() {
        if (api == null)
            api = getRetrofit().create(Api.class);
        return api;
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(600, TimeUnit.SECONDS)
                    .readTimeout(600, TimeUnit.SECONDS)
                    .writeTimeout(600, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(URLS.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public CityManager getCityManager() {
        if (cityManager == null)
            cityManager = new CityManager(getServerCalls());
        return cityManager;
    }

    private ServerCalls getServerCalls() {
        if (serverCalls == null)
            serverCalls = new ServerCalls(getApi());
        return serverCalls;
    }

}
