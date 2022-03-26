package com.example.finaldamb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.finaldamb.Listen.Listen;
import com.example.finaldamb.Quiz.Quiz;
import com.example.finaldamb.Setting.Settings;
import com.example.finaldamb.Translate.Favourite;
import com.example.finaldamb.Translate.Translation;
import com.example.finaldamb.Word.Word;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Translation(View view) {
        Intent intent = new Intent(MainActivity.this, Translation.class);
        startActivity(intent);
    }
    public void Word(View view) {
        Intent intent = new Intent(MainActivity.this, Word.class);
        startActivity(intent);
    }
    public void ETC(View view) {
        Intent intent = new Intent(MainActivity.this,ETC.class);
        startActivity(intent);
    }
    public void Quiz(View view) {
        Intent intent = new Intent(MainActivity.this, Quiz.class);
        startActivity(intent);
    }
    public void FavoriteWord(View view){
        Intent intent = new Intent(MainActivity.this, Favourite.class);
        startActivity(intent);
    }
    public void Settings(View view){
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }

    public void Listen(View view) {
        Intent intent = new Intent(MainActivity.this, Listen.class);
        startActivity(intent);
    }
}