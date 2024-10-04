package com.northcoders.gamboge.waddl.ui.taskdeletedactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.databinding.ActivityTaskUpdatedBinding;
import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivity;

public class TaskUpdatedActivity extends AppCompatActivity {
    private Handler handler;
    private ActivityTaskUpdatedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_updated);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task_updated);
        String displayText = getIntent().getParcelableExtra("DISPLAY_TEXT", String.class);
        Long delay = getIntent().getParcelableExtra("DELAY_TO_TRANSITION", Long.class);
        binding.setDisplayText(displayText);
        handler = new Handler(getMainLooper());
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }, delay
        );
    }
}