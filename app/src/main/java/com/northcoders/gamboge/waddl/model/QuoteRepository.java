package com.northcoders.gamboge.waddl.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.gamboge.waddl.service.QuoteApiService;
import com.northcoders.gamboge.waddl.service.QuoteRetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepository {

    private static MutableLiveData<List<Quote>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public QuoteRepository(Application application) {
        this.application = application;
    }

    public static MutableLiveData<List<Quote>> getQuote() {
        QuoteApiService quoteApiService = QuoteRetrofitInstance.getService();
        Call<List<Quote>> call = quoteApiService.getQuote();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                List<Quote> quote = response.body();
                mutableLiveData.setValue(quote);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        return mutableLiveData;
    }
    public void fetchQuote(Callback<Quote> callback) {
        QuoteApiService quoteApiService = QuoteRetrofitInstance.getService();
        Call<List<Quote>> call = quoteApiService.getQuote();
    }

}
