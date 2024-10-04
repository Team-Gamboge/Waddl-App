package com.northcoders.gamboge.waddl.ui.creditsactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.databinding.ActivityAddTaskBinding;
import com.northcoders.gamboge.waddl.databinding.ActivityCreditsBinding;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivity;

public class CreditsActivity extends AppCompatActivity {
    private ActivityCreditsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = DataBindingUtil.setContentView(this, R.layout.activity_credits);

        binding.backToMainButton.setOnClickListener(v -> {
            Log.i("Intent", "Moving to main activity.");
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        });
    }


}