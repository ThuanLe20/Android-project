package com.example.finaldamb.Translate;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finaldamb.R;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.InsertFavoriteModel;
import com.example.lib.Model.InsertFavoriteModelResult;
import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Translation extends AppCompatActivity {
    EditText inputtxt;
    Button btnTranslate, btnreTranslate;
    TextView translatetxt;
    TextToSpeech mTTS, mTTS2;
    SeekBar seekbarpitch, seekbarspeed, seekbarpitch2, seekbarspeed2;
    ImageView loudspeaker , loudspeaker2, micro;

    private static final int RECOGNIZER_RESULT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        loudspeaker = findViewById(R.id.speak);
        loudspeaker2 = findViewById(R.id.speak2);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(Locale.US);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not supported");
                    }else{
                        loudspeaker.setEnabled(true);
                    }
                }else{
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
        mTTS2 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS2.setLanguage(Locale.US);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not suppored");
                    }else{
                        loudspeaker2.setEnabled(true);
                    }
                }else{
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        seekbarpitch = findViewById(R.id.seek_bar_pitch);
        seekbarspeed = findViewById(R.id.seek_bar_speed);
        seekbarpitch2 = findViewById(R.id.seek_bar_pitch2);
        seekbarspeed2 = findViewById(R.id.seek_bar_speed2);
        inputtxt = findViewById(R.id.inputtxt);
        btnTranslate = findViewById(R.id.btnTranslate);
        btnreTranslate = findViewById(R.id.btnreTranslate);
        translatetxt = findViewById(R.id.translatetxt);
        micro = findViewById(R.id.micro);

        inputtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translatetxt.setText("");
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(inputtxt.getText().toString())){
                    Toast.makeText(Translation.this, "Thiếu thông tin từ cần dịch", Toast.LENGTH_SHORT).show();
                    translatetxt.setText("");
                }else {
                    TranslateAPI translateAPI = new TranslateAPI(
                            Language.ENGLISH,
                            Language.VIETNAMESE,
                            inputtxt.getText().toString()
                    );

                    translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                        @Override
                        public void onSuccess(String translatedText) {
                            translatetxt.setText(translatedText);
                        }

                        @Override
                        public void onFailure(String ErrorText) {
                            Log.d("Error", ErrorText);
                        }
                    });
                }
            }
        });

        btnreTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(inputtxt.getText().toString())){
                    Toast.makeText(Translation.this, "Thiếu thông tin từ cần dịch", Toast.LENGTH_SHORT).show();
                }else {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.VIETNAMESE,
                        Language.ENGLISH,
                        inputtxt.getText().toString()
                );

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        translatetxt.setText(translatedText);
                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error", ErrorText);
                    }
                });

            }}
        });

        loudspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loud();
            }
        });
        loudspeaker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loud2();
            }
        });
        micro();
    }
    private void loud(){
        String text = inputtxt.getText().toString();
        float pitch = (float) seekbarpitch.getProgress() / 50;
        if(pitch < 0.1) pitch = 0.1f;
        float speed = (float) seekbarspeed.getProgress() / 50;
        if(speed < 0.1) speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    private void loud2(){
        String text2 = translatetxt.getText().toString();
        float pitch = (float) seekbarpitch2.getProgress() / 50;
        if(pitch < 0.1) pitch = 0.1f;
        float speed = (float) seekbarspeed2.getProgress() / 50;
        if(speed < 0.1) speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text2, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    protected void onDestroy() {
        if(mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }
    public void micro(){
        micro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak to text");
                startActivityForResult(intent,RECOGNIZER_RESULT);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == RECOGNIZER_RESULT && resultCode == RESULT_OK){
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            inputtxt.setText(matches.get(0).toString());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void Add(View view) {
        InsertFavoriteModel insertFavoriteModel = new InsertFavoriteModel();
        insertFavoriteModel.setWord(inputtxt.getText().toString());
        insertFavoriteModel.setWord2(translatetxt.getText().toString());
        insertFavoriteModel.setId("00000000-0000-0000-0000-000000000000");

        if (TextUtils.isEmpty(inputtxt.getText().toString())) {
            Toast.makeText(Translation.this, "Chưa có từ", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(translatetxt.getText().toString())) {
            Toast.makeText(Translation.this, "Chưa có từ đã dịch", Toast.LENGTH_SHORT).show();}
        else
            {
            Methods methods = getRetrofit().create(Methods.class);
            Call<InsertFavoriteModelResult> call = methods.insertFavoriteWord(insertFavoriteModel);
            call.enqueue(new Callback<InsertFavoriteModelResult>() {
                @Override
                public void onResponse(Call<InsertFavoriteModelResult> call, Response<InsertFavoriteModelResult> response) {
                    String status = response.body().getStatus();
                    if (status == "true") {
                        Toast.makeText(Translation.this, "Đã lưu", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Translation.this, "Không thể lưu ", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<InsertFavoriteModelResult> call, Throwable t) {
                }
            });
        }
    }
}