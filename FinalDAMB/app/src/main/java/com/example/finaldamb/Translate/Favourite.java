package com.example.finaldamb.Translate;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finaldamb.Adapter.FavoriteAdapter;
import com.example.finaldamb.R;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.FavoriteModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favourite extends AppCompatActivity {
    ListView lvAdvance;
    FavoriteAdapter favoriteAdapter;
    String Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorityword);
        lvAdvance = findViewById(R.id.lvAdvance);
        favoriteAdapter = new FavoriteAdapter(Favourite.this,R.layout.fwlayout);
    }

    public void getList(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<FavoriteModel> call = methods.getFW();
        call.enqueue(new Callback<FavoriteModel>() {
            @Override
            public void onResponse(Call<FavoriteModel> call, Response<FavoriteModel> response) {
                List<FavoriteModel.Data> data = response.body().getData();
                for(FavoriteModel.Data dt : data){
                    favoriteAdapter.add(dt);
                }
                favoriteAdapter.notifyDataSetChanged();
                lvAdvance.setAdapter(favoriteAdapter);
                lvAdvance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        FavoriteModel.Data item = (FavoriteModel.Data) parent.getItemAtPosition(position);
                        Intent i = new Intent(Favourite.this, DetailsFW.class);
                        i.putExtra("Id",item.getId().toString());
                        i.putExtra("Word",item.getWord().toString());
                        i.putExtra("Word2",item.getWord2().toString());
                        startActivity(i);

                    }
                });
            }

            @Override
            public void onFailure(Call<FavoriteModel> call, Throwable t) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        favoriteAdapter.clear();
        getList();
    }

}