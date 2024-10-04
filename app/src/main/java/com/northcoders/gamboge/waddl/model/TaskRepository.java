package com.northcoders.gamboge.waddl.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.gamboge.waddl.service.RetrofitInstance;
import com.northcoders.gamboge.waddl.service.TaskApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository {

    private ArrayList<Task> tasks = new ArrayList<>();

    private static MutableLiveData<List<Task>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public TaskRepository(Application application) {
        this.application = application;
    }

    public static MutableLiveData<List<Task>> getTasks() {

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

    public void addTask(Task task) {

        TaskApiService taskApiService = RetrofitInstance.getService();

        Call<Task> call = taskApiService.addTask(task);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(@NonNull Call<Task> call, @NonNull Response<Task> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Task added to database",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<Task> call, @NonNull Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to add Task to database",
                        Toast.LENGTH_SHORT).show();
                Log.e("POST REQ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void updateTask(long id, Task task) {
        TaskApiService taskApiService = RetrofitInstance.getService();
        Call<Task> call = taskApiService.updateTaskById(id, task);

        call.enqueue(new Callback<Task>() {

            @Override
            public void onResponse(@NonNull Call<Task> call, @NonNull Response<Task> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Task updated",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<Task> call, @NonNull Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to update task",
                        Toast.LENGTH_SHORT).show();

                Log.e("PUT REQUEST", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
// If there are any errors, revise usage of type 'void'. change string
    public void deleteTaskById(long id) {
        TaskApiService taskApiService = RetrofitInstance.getService();

        Call<Void> call = taskApiService.deleteTaskById(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Task deleted",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                Log.e("DELETE REQ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }




}




