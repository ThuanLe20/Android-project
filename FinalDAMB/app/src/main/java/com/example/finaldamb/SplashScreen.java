package com.example.finaldamb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView txt1, txt2;
    private static int Splash_timeout = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        txt1= findViewById(R.id.txt1);
        txt2= findViewById(R.id.txt2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashintent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(splashintent);
                finish();
            }
        },Splash_timeout);
        Animation myanimation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.animation2);
        txt1.startAnimation(myanimation);
        Animation myanimation2 = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.animation2);
        txt2.startAnimation(myanimation2);
    }
}