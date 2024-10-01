package com.northcoders.gamboge.waddl.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.gamboge.waddl.service.RetrofitInstance;
import com.northcoders.gamboge.waddl.service.TaskApiService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository {
    private static MutableLiveData<List<Task>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    public TaskRepository(Application application) {
        this.application = application;
    }
    public static MutableLiveData<List<Task>> getMutableLiveData() {
        TaskApiService taskApiService = RetrofitInstance.getService();
        Call<List<Task>> call = taskApiService.getAllTasks();

        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> taskList = response.body();
                mutableLiveData.setValue(taskList);
            }
            @Override
            public void onFailure(Call<List<Task>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });
        return mutableLiveData;
    }
}
