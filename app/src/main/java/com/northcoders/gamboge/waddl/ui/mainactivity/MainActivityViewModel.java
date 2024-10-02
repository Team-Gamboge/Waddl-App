package com.northcoders.gamboge.waddl.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.gamboge.waddl.model.Quote;
import com.northcoders.gamboge.waddl.model.QuoteRepository;
import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.model.TaskRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;
    private QuoteRepository quoteRepository;
    private MutableLiveData<List<Task>> taskLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public LiveData<List<Task>> getAllTasks() {
        return taskRepository.getTasks();
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public void updateTaskById(Long id, Task task) {
        taskRepository.updateTask(id, task);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteTaskById(id);
    }

    public LiveData<List<Quote>> getQuote() { return quoteRepository.getQuote(); }

}
