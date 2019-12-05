package com.example.navigator.views;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigator.R;

public class SplashActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    Animation atg;
    Animation atg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv=findViewById(R.id.tvsplash);
        iv=findViewById(R.id.ivsplash);

        atg= AnimationUtils.loadAnimation(this,R.anim.transitionstart2);
        atg2 = AnimationUtils.loadAnimation(this,R.anim.transitionstart);

        tv.startAnimation(atg);
        iv.startAnimation(atg2);

        final Intent i = new Intent(this,MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
                finish();
            }
        },5000);
    }
}
