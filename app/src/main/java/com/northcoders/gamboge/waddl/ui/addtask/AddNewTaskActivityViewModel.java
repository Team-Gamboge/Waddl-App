package com.northcoders.gamboge.waddl.ui.addtask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.model.TaskRepository;

public class AddNewTaskActivityViewModel extends AndroidViewModel {
    private TaskRepository taskRepository;

    public AddNewTaskActivityViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public void addNewTask(Task task) {
        this.taskRepository.addTask(task);
    }
}
