package com.example.finaldamb.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finaldamb.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class Settings extends AppCompatActivity {
    SwitchMaterial sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sw = findViewById(R.id.sw);
        sw.setChecked(false);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    public void Gmail(View view) {
        Intent intent = new Intent(Settings.this,Gmail.class);
        startActivity(intent);
    }

    public void Share(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String body = "Download this app";
        String sub = "https://play.google.com";
        intent.putExtra(Intent.EXTRA_TEXT,body);
        intent.putExtra(Intent.EXTRA_TEXT,sub);
        startActivity(Intent.createChooser(intent,"Share using"));
    }

}