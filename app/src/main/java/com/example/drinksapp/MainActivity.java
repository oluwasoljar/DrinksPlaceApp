package com.example.drinksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int DELAY = 7000;
    ImageView imageView;
    Animation animToLeft, animToRight;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        animToLeft = AnimationUtils.loadAnimation(this, R.anim.anim_to_left);
        animToRight = AnimationUtils.loadAnimation(this, R.anim.anim_to_right);

        imageView.setAnimation(animToLeft);
        textView.setAnimation(animToRight);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Loading.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}