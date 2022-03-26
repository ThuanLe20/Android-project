package com.example.finaldamb.Listen;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finaldamb.R;
import com.example.finaldamb.Translate.DetailsFW;
import com.example.finaldamb.Translate.Favourite;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.InsertFavoriteModel;
import com.example.lib.Model.InsertFavoriteModelResult;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsListen extends AppCompatActivity {
    EditText textlisten;
    Button check;
    TextView txt1;
    ImageView loud;
    TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_listen);

        textlisten = findViewById(R.id.txtlisten);
        check = findViewById(R.id.check);
        txt1 = findViewById(R.id.textltvd);
        loud = findViewById(R.id.imgloud);
        txt1.setText(getIntent().getStringExtra("Text"));

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(Locale.US);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not supported");
                    }else{
                        loud.setEnabled(true);
                    }
                }else{
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
        loud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loudspeaker();
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textlisten.getText().toString().equals(txt1.getText().toString())){
                    Toast.makeText(DetailsListen.this, "OH !! Your listening is very good ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DetailsListen.this, "Oops !! !! Maybe you wrote something wrong. Please check all correct punctuation. ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void loudspeaker(){
        String text = txt1.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}