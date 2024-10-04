package com.northcoders.gamboge.waddl.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.ui.mainactivity.MainActivity;

import pl.droidsonroids.gif.GifImageView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        TextView myTextView = findViewById(R.id.Waddl);
        GifImageView penguin = findViewById(R.id.penguinGif);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        myTextView.startAnimation(fadeIn);
        penguin.startAnimation(fadeIn);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }


}

