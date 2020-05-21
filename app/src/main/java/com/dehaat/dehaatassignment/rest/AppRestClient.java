package com.dehaat.dehaatassignment.rest;

import android.text.TextUtils;
import android.util.Log;

import com.dehaat.dehaatassignment.model.Data;
import com.dehaat.dehaatassignment.model.UserAuthDetails;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRestClient {

    private static AppRestClient mInstance;
    int cacheSize = 10 * 1024 * 1024; // 10 MB
    private AppRestClientService appRestClientService;
    private static String BASE_URL = "https://4bc5bc23-3fb0-407e-9dda-d6a0ae90897d.mock.pstmn.io";

    private AppRestClient() {
        setRestClient();
    }

    public static AppRestClient getInstance() {
        if (mInstance == null) {
            synchronized (AppRestClient.class) {
                if (mInstance == null)
                    mInstance = new AppRestClient();
            }
        }
        return mInstance;
    }

    public static void setAppRestClientNull() {
        mInstance = null;
    }

    private void setRestClient() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //ToDo: enter base url
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        appRestClientService = retrofit.create(AppRestClientService.class);
    }

    public AppRestClientService getAppRestClientService() {
        return appRestClientService;
    }
}
