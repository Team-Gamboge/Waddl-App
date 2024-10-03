package com.northcoders.gamboge.waddl.ui.addtask;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivity;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivityViewModel;

public class AddNewActivityClickHandler {
    private Context appContext;
    private MainActivityViewModel viewModel;
    private Task task;

    public AddNewActivityClickHandler(Context appContext, MainActivityViewModel viewModel) {
        this.appContext = appContext;
        this.viewModel = viewModel;
        this.task = new Task();
    }

    public void addTaskButtonClicked(View view) {
        Log.i("Intent", "Moving to main activity.");
        Intent intent = new Intent(this.appContext, MainActivity.class);

        // Add task logic here.

        this.appContext.startActivity(intent);
    }

    public void backToMainActivityButtonClicked(View view) {
        Log.i("Intent", "Moving to main activity.");
        Intent intent = new Intent(this.appContext, MainActivity.class);

        this.appContext.startActivity(intent);
    }
}
