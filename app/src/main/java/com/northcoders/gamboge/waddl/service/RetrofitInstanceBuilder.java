package com.northcoders.gamboge.waddl.service;

import android.util.Log;

import java.util.HashMap;

import kotlin.TypeCastException;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceBuilder {
    private static HashMap<Class<?>, ApiService> services = new HashMap();

    public static <T extends ApiService> T getService(String baseUrl, Class<T> clazz) {

        if (services.containsKey(clazz)) {
            try {
                Log.i(RetrofitInstanceBuilder.class.getName(), "Found requested service in cache. Returning cached service.");

                return (T) services.get(clazz);
            } catch (TypeCastException e) {
                Log.e(RetrofitInstanceBuilder.class.getName(), "Caught exception casting to requested ");
            }
        }

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Log.i(RetrofitInstanceBuilder.class.getName(), "Requested service not found in cache. Returning new instance.");

        T service = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(clazz);

        services.put(clazz, service);
        return service;
    }
}
