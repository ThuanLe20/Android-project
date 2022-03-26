package com.example.finaldamb.Word;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finaldamb.Adapter.WordAdapter;
import com.example.finaldamb.R;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.WordModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Word extends AppCompatActivity {

    ListView lvAdvance;
    WordAdapter wordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        lvAdvance = findViewById(R.id.lvAdvance);
        wordAdapter = new WordAdapter(Word.this,R.layout.wordlayout);
        getList();
    }

    public void getList(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<WordModel> call = methods.getWord();
        call.enqueue(new Callback<WordModel>() {
            @Override
            public void onResponse(Call<WordModel> call, Response<WordModel> response) {
                List<WordModel.Data> data = response.body().getData();
                for(WordModel.Data dt : data){
                    wordAdapter.add(dt);
                }
                wordAdapter.notifyDataSetChanged();
                lvAdvance.setAdapter(wordAdapter);
                lvAdvance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        WordModel.Data item = (WordModel.Data) parent.getItemAtPosition(position);
                        Intent i = new Intent(Word.this, DetailsWord.class);
                        i.putExtra("Id",item.getId().toString());
                        i.putExtra("Name",item.getNameword().toString());
                        i.putExtra("KN",item.getKn().toString());
                        i.putExtra("KD",item.getKd().toString());
                        i.putExtra("PD",item.getPd().toString());
                        i.putExtra("NV",item.getNv().toString());
                        i.putExtra("Signal",item.getSignal().toString());
                        i.putExtra("Description",item.getDescription().toString());
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<WordModel> call, Throwable t) {
            }
        });
    }

}