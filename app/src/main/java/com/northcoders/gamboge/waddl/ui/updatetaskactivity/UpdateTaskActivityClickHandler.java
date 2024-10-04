package com.northcoders.gamboge.waddl.ui.updatetaskactivity;

import static com.northcoders.gamboge.waddl.utility.Utility.switchToActivityWithMessage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivity;
import com.northcoders.gamboge.waddl.ui.taskdeletedactivity.TaskUpdatedActivity;
import com.northcoders.gamboge.waddl.utility.Utility;

public class UpdateTaskActivityClickHandler {
    private Context appContext;
    private UpdateTaskActivityViewModel viewModel;
    private Task task;

    public UpdateTaskActivityClickHandler(Task task, Context appContext, UpdateTaskActivityViewModel viewModel) {
        this.appContext = appContext;
        this.viewModel = viewModel;
        this.task = task;
    }

    public void updateTaskButtonClicked(View view) {
        if (Utility.containsNullNonPrimitiveFields(this.task) ||
                Utility.containsBlankStringFields(this.task) ||
                this.task == null) {
            Toast.makeText(this.appContext, "Task input fields cannot be blank.", Toast.LENGTH_SHORT).show();
            return;
        }

        this.viewModel.updateTask(task.getId(), task);
        switchToActivityWithMessage(
                String.format("Task \"%s\" updated!", task.getTitle()),
                2000L,
                this.appContext,
                TaskUpdatedActivity.class);
    }

    public void backToMainActivityButtonClicked(View view) {
        Log.i("Intent", "Moving to main activity.");
        Intent intent = new Intent(this.appContext, MainActivity.class);

        this.appContext.startActivity(intent);
    }

    public void deleteButtonClicked(View view) {
        Log.i("Intent", "Moving to main activity.");
        viewModel.deleteTask(task.getId());

        switchToActivityWithMessage(
                String.format("Task \"%s\" deleted.", task.getTitle()),
                2000L,
                this.appContext,
                TaskUpdatedActivity.class);
    }
}
