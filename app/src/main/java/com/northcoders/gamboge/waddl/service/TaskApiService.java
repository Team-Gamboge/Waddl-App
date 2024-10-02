package com.northcoders.gamboge.waddl.service;

import com.northcoders.gamboge.waddl.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TaskApiService {

    @GET("tasks")
    Call<List<Task>> getAllTasks();

    @GET("tasks/{id}")
    //    Call<List<Task>> getTaskById();
    //    // functionality has not been added

    @POST("tasks")
    Call<Task> addTask (@Body Task task);

    @PUT("tasks/{id}")
    Call<Task> updateTaskById(@Path("id") long id, @Body Task task);

    @DELETE("tasks/{id}")
    Call<Void> deleteTaskById(@Path("id") long id);


}
