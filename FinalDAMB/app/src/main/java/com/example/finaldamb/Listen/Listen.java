package com.example.finaldamb.Listen;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finaldamb.Adapter.ListenAdapter;
import com.example.finaldamb.Adapter.WordAdapter;
import com.example.finaldamb.R;
import com.example.finaldamb.Word.DetailsWord;
import com.example.finaldamb.Word.Word;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ListenModel;
import com.example.lib.Model.WordModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Listen extends AppCompatActivity {
    ListenAdapter listenAdapter;
    ListView lvlisten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        lvlisten = findViewById(R.id.lvlisten);
        listenAdapter = new ListenAdapter(Listen.this,R.layout.listenlayout);
        getList();
    }

    public void getList(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<ListenModel> call = methods.getTL();
        call.enqueue(new Callback<ListenModel>() {
            @Override
            public void onResponse(Call<ListenModel> call, Response<ListenModel> response) {
                List<ListenModel.Data> data = response.body().getData();
                for(ListenModel.Data dt : data){
                    listenAdapter.add(dt);
                }
                listenAdapter.notifyDataSetChanged();
                lvlisten.setAdapter(listenAdapter);
                lvlisten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ListenModel.Data item = (ListenModel.Data) parent.getItemAtPosition(position);
                        Intent i = new Intent(Listen.this, DetailsListen.class);
                        i.putExtra("Text",item.getText().toString());
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<ListenModel> call, Throwable t) {
            }
        });
    }
}