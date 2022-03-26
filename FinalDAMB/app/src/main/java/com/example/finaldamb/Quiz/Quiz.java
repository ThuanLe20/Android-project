package com.example.finaldamb.Quiz;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finaldamb.R;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.MutichoiceModel;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Quiz extends AppCompatActivity {
    private TextView txtquestionView;
    private TextView txtscore;
    private Button btnchoice1;
    private Button btnchoice2;
    private Button btnchoice3;
    private Button btnchoice4;
    private ProgressBar pgbprocessBar;



    private String answer;
    private int numberQuestion=0;
    private int scoreNumber = 0;
    final int MAX = 2000;
    private int Max_Question = 100;
    private int Wrong_Test = 0;
    private int Correct_Test = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        txtquestionView = (TextView)findViewById(R.id.text1);
        txtscore = (TextView) findViewById(R.id.textView);
        btnchoice1 = (Button)findViewById(R.id.button);
        btnchoice2 = (Button)findViewById(R.id.button2);
        btnchoice3 = (Button)findViewById(R.id.button3);
        btnchoice4 = (Button)findViewById(R.id.button4);
        pgbprocessBar = (ProgressBar) findViewById(R.id.progressBar);

        getdata();
    }

    public void getdata(){
        Methods methods =getRetrofit().create(Methods.class);
        Call<MutichoiceModel> call = methods.getMutichoice();

        call.enqueue(new Callback<MutichoiceModel>() {
            @Override
            public void onResponse(Call<MutichoiceModel> call, Response<MutichoiceModel> response) {

                List<MutichoiceModel.Data> data = response.body().getData();
                Max_Question = data.size();
                Log.v("Log:",data.size()+"");
                KiemTra(data);


            }

            @Override
            public void onFailure(Call<MutichoiceModel> call, Throwable t) {

            }

        });
    }

    //Cập nhật procressBar
    private void ProcessBar(){
        this.pgbprocessBar.setMax(MAX);
        pgbprocessBar.setProgress(scoreNumber);
    }

    //Cập nhật dữ liệu câu hỏi và trả lời
    private void UpdateQuestion(List<MutichoiceModel.Data> data){
        ProcessBar();
        if (scoreNumber>=MAX || numberQuestion==Max_Question){

            Intent intent = new Intent(Quiz.this,QuizResult.class);
            intent.putExtra("Score",scoreNumber);
            intent.putExtra("Wrong",Wrong_Test);
            intent.putExtra("Correct",Correct_Test);
            startActivity(intent);
            finish();
        }
        else{
            txtquestionView.setText(getQuestion(numberQuestion,data));
            btnchoice1.setText(getChoice1(numberQuestion,data));
            btnchoice2.setText(getChoice2(numberQuestion,data));
            btnchoice3.setText(getChoice3(numberQuestion,data));
            btnchoice4.setText(getChoice4(numberQuestion,data));
            answer = getCorect(numberQuestion,data);
            txtscore.setText("Your Score: " + String.valueOf(scoreNumber));
            numberQuestion++;
        }

    }
    //Phần chọn đáp án
    public void KiemTra(List<MutichoiceModel.Data> data){
        UpdateQuestion(data);
        final MediaPlayer correct = MediaPlayer.create(this,R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this,R.raw.incorrect);
        btnchoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnchoice1.getText().toString().equals(answer) ){
                    Random rand = new Random();
                    scoreNumber += rand.nextInt(100)+50;
                    Toast.makeText(Quiz.this,"Đúng",Toast.LENGTH_SHORT).show();
                    Correct_Test++;
                    correct.start();
                    UpdateQuestion(data);
                }
                else{
                    Toast.makeText(Quiz.this,"Sai rồi",Toast.LENGTH_SHORT).show();
                    Wrong_Test++;
                    incorrect.start();
                    UpdateQuestion(data);

                }
            }
        });

        btnchoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnchoice2.getText().toString().equals(answer)){
                    Random rand = new Random();
                    scoreNumber += rand.nextInt(100)+50;
                    Toast.makeText(Quiz.this,"Đúng",Toast.LENGTH_SHORT).show();
                    Correct_Test++;
                    correct.start();
                    UpdateQuestion(data);
                }
                else{
                    Toast.makeText(Quiz.this,"sai rồi",Toast.LENGTH_SHORT).show();
                    Wrong_Test++;
                    incorrect.start();
                    UpdateQuestion(data);
                }
            }
        });

        btnchoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnchoice3.getText().toString().equals(answer)){
                    Random rand = new Random();
                    scoreNumber += rand.nextInt(100)+50;
                    Toast.makeText(Quiz.this,"Đúng",Toast.LENGTH_SHORT).show();
                    Correct_Test++;
                    correct.start();
                    UpdateQuestion(data);
                }
                else{
                    Toast.makeText(Quiz.this,"sai rồi",Toast.LENGTH_SHORT).show();
                    Wrong_Test++;
                    incorrect.start();
                    UpdateQuestion(data);
                }
            }
        });

        btnchoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                scoreNumber += rand.nextInt(100)+50;
                if (btnchoice4.getText().toString().equals(answer)){
                    Toast.makeText(Quiz.this,"Đúng",Toast.LENGTH_SHORT).show();
                    Correct_Test++;
                    correct.start();
                    UpdateQuestion(data);

                }
                else{
                    Toast.makeText(Quiz.this,"sai rồi",Toast.LENGTH_SHORT).show();
                    Wrong_Test++;
                    incorrect.start();
                    UpdateQuestion(data);
                }
            }
        });
    }

    //----------------------------------------------------------------//


    //Cài đặt câu hỏi và câu trả lời
    public  String getQuestion(int a,List<MutichoiceModel.Data> data){
        Log.v("Log:",a+"");
        String test1 = data.get(a).getQuestion();

        return test1;
    }
    public  String getChoice1(int a, List<MutichoiceModel.Data> data){
        String test1 = data.get(a).getChoice1();
        return test1;
    }
    public  String getChoice2(int a, List<MutichoiceModel.Data> data){
        String test1 = data.get(a).getChoice2();
        return test1;
    }
    public  String getChoice3(int a, List<MutichoiceModel.Data> data){
        String test1 = data.get(a).getChoice3();
        return test1;
    }
    public  String getChoice4(int a, List<MutichoiceModel.Data> data){
        String test1 = data.get(a).getChoice4();
        return test1;
    }
    public  String getCorect(int a, List<MutichoiceModel.Data> data){
        String correct = data.get(a).getCorrect();
        return correct;
    }
}