package com.northcoders.gamboge.waddl.ui.updatetaskactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.model.TaskRepository;

public class UpdateTaskActivityViewModel extends AndroidViewModel {
    private TaskRepository taskRepository;

    public UpdateTaskActivityViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public void updateTask(Long id, Task task) {
        this.taskRepository.updateTask(id, task);
    }
}
