package com.northcoders.gamboge.waddl.ui.updatetaskactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.databinding.ActivityUpdateTaskBinding;
import com.northcoders.gamboge.waddl.model.Task;

public class UpdateTaskActivity extends AppCompatActivity {
    private ActivityUpdateTaskBinding binding;
    private UpdateTaskActivityClickHandler clickHandler;
    private UpdateTaskActivityViewModel viewModel;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_update_task);
        this.viewModel = new ViewModelProvider(this).get(UpdateTaskActivityViewModel.class);
        this.task = getIntent().getParcelableExtra(Task.PARCEL_KEY, Task.class);
        this.binding.setTask(this.task);
        this.clickHandler = new UpdateTaskActivityClickHandler(this.binding.getTask(), this, this.viewModel);
        this.binding.setClickHandler(this.clickHandler);
    }
}