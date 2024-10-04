package com.northcoders.gamboge.waddl.ui.addtask;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.model.TaskRepository;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivity;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivityViewModel;
import com.northcoders.gamboge.waddl.ui.taskdeletedactivity.TaskUpdatedActivity;
import com.northcoders.gamboge.waddl.utility.Utility;

public class AddNewActivityClickHandler {
    private Context appContext;
    private AddNewTaskActivityViewModel viewModel;
    private Task task;

    public AddNewActivityClickHandler(Task task, Context appContext, AddNewTaskActivityViewModel viewModel) {
        this.appContext = appContext;
        this.viewModel = viewModel;
        this.task = task;
    }

    public void addTaskButtonClicked(View view) {
//        if (Utility.containsNullNonPrimitiveFields(this.task) ||
//                Utility.containsBlankStringFields(this.task) ||
//                this.task == null) {
//            Toast.makeText(this.appContext, "Task input fields or album cannot be blank.", Toast.LENGTH_SHORT).show();
//        }

        this.viewModel.addNewTask(task);
        Utility.switchToActivityWithMessage(
                String.format("Task \"%s\" added successfully!", task.getTitle()),
                2000L,
                this.appContext,
                TaskUpdatedActivity.class);
    }

    public void backToMainActivityButtonClicked(View view) {
        Log.i("Intent", "Moving to main activity.");
        Intent intent = new Intent(this.appContext, MainActivity.class);

        this.appContext.startActivity(intent);
    }
}
