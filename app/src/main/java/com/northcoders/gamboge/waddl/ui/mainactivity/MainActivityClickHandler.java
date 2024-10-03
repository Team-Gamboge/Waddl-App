package com.northcoders.gamboge.waddl.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.northcoders.gamboge.waddl.ui.addtask.AddTaskActivity;

public class MainActivityClickHandler {
    private Context appContext;
    private MainActivityViewModel viewModel;

    public MainActivityClickHandler(Context appContext, MainActivityViewModel viewModel) {
        this.appContext = appContext;
        this.viewModel = viewModel;
    }

    public void addTaskViewButtonClicked(View view) {
        Log.i("Intent", "Moving to add task activity.");
        Intent intent = new Intent(appContext, AddTaskActivity.class);

        this.appContext.startActivity(intent);
    }

    public void penguinBooped(View view) {
        
    }
}
