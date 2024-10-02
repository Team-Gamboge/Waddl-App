package com.northcoders.gamboge.waddl.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.gamboge.waddl.service.QuoteApiService;
import com.northcoders.gamboge.waddl.service.QuoteRetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepository {

    private static MutableLiveData<Quote> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public QuoteRepository(Application application) {
        this.application = application;
    }

    public static MutableLiveData<Quote> getQuote() {

        QuoteApiService quoteApiService = QuoteRetrofitInstance.getService();
        Call<Quote> call = quoteApiService.getQuote();

        call.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                Quote quote = response.body();
                mutableLiveData.setValue(quote);
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        return mutableLiveData;
    }

}
