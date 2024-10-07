package com.northcoders.gamboge.waddl.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteRetrofitInstance {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://api.quotable.io/quotes/";


    public static QuoteApiService getService() {
        if (retrofit == null) {
            // this allows us to log the JSON body of the HTTP request
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit.create(QuoteApiService.class);
    }

}
