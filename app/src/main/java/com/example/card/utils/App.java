package com.example.card.utils;

import android.app.Application;

import com.example.card.network.PixabayApi;
import com.example.card.network.RetrofitClient;

public class App extends Application {
    public static PixabayApi api;
    public RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideApi();
    }
}
