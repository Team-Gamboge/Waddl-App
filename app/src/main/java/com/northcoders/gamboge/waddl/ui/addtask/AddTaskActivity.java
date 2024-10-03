package com.northcoders.gamboge.waddl.ui.addtask;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.databinding.ActivityAddTaskBinding;
import com.northcoders.gamboge.waddl.model.Task;

public class AddTaskActivity extends AppCompatActivity {
    private AddNewActivityClickHandler clickHandler;
    private AddNewTaskActivityViewModel viewModel;
    private ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.viewModel = new ViewModelProvider(this).get(AddNewTaskActivityViewModel.class);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_add_task);
        this.binding.setTask(new Task());
        this.clickHandler = new AddNewActivityClickHandler(this.binding.getTask(), this, this.viewModel);
        this.binding.setClickHandler(this.clickHandler);
    }
}