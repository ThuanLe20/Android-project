package com.example.finaldamb.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.finaldamb.MainActivity;
import com.example.finaldamb.R;

public class QuizResult extends AppCompatActivity {
    private TextView txtScore;
    private TextView txtWrong, txtCorrect;

    int score;
    int wrong;
    int correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        Intent intent = getIntent();
        score = intent.getIntExtra("Score",0);
        wrong = intent.getIntExtra("Wrong", 0);
        correct = intent.getIntExtra("Correct", 0);

        txtScore = (TextView)findViewById(R.id.textView3);
        txtWrong = (TextView)findViewById(R.id.textView4);
        txtCorrect = (TextView)findViewById(R.id.textView5);

        txtScore.setText("Tổng số điểm bạn đạt được: "+String.valueOf(score));
        txtCorrect.setText("Số câu đúng: "+String.valueOf(correct));
        txtWrong.setText("Số câu sai: "+String.valueOf(wrong));
    }

    public void Back(View view) {
        Intent intent = new Intent(QuizResult.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}