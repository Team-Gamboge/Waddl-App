package com.northcoders.gamboge.waddl.service;

import com.northcoders.gamboge.waddl.model.Quote;
import com.northcoders.gamboge.waddl.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteApiService {

    @GET("random")
    Call<List<Quote>> getQuote();

}

