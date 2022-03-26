package com.example.finaldamb.Translate;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finaldamb.R;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.DeleteFWModel;
import com.example.lib.Model.DeleteFWModelResult;
import com.example.lib.Model.InsertFavoriteModel;
import com.example.lib.Model.InsertFavoriteModelResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsFW extends AppCompatActivity {
    EditText txtWord, txtWord2;
    String Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_fw);
        txtWord = findViewById(R.id.txtword);
        txtWord2 =findViewById(R.id.txtword2);

        txtWord.setText(getIntent().getStringExtra("Word"));
        txtWord2.setText(getIntent().getStringExtra("Word2"));

        Id = getIntent().getStringExtra("Id");
    }
    public void Save(View view){
        InsertFavoriteModel insertFavoriteModel = new InsertFavoriteModel();
        insertFavoriteModel.setWord(txtWord.getText().toString());
        insertFavoriteModel.setWord2(txtWord2.getText().toString());
        insertFavoriteModel.setId(Id);

        Methods methods = getRetrofit().create(Methods.class);
        Call<InsertFavoriteModelResult> call = methods.insertFavoriteWord(insertFavoriteModel);
        call.enqueue(new Callback<InsertFavoriteModelResult>() {
            @Override
            public void onResponse(Call<InsertFavoriteModelResult> call, Response<InsertFavoriteModelResult> response) {
                String status = response.body().getStatus();
                if(status == "true"){
                    Toast.makeText(DetailsFW.this, "Đã lưu thông tin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailsFW.this,Favourite.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DetailsFW.this, "Không lưu được thông tin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailsFW.this,Favourite.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<InsertFavoriteModelResult> call, Throwable t) {

            }
        });
    }

//    public void Cancel(View view) {
//        Intent intent = new Intent(DetailsFW.this, Favourite.class);
//        startActivity(intent);
//    }

    public void Delete(View view) {
        DeleteFWModel deleteFWModel = new DeleteFWModel();
        deleteFWModel.setWord(txtWord.getText().toString());
        deleteFWModel.setWord2(txtWord2.getText().toString());
        deleteFWModel.setId(Id);

        Methods methods = getRetrofit().create(Methods.class);
        Call<DeleteFWModelResult> call = methods.deleteFavoriteWord(deleteFWModel);
        call.enqueue(new Callback<DeleteFWModelResult>() {

            @Override
            public void onResponse(Call<DeleteFWModelResult> call, Response<DeleteFWModelResult> response) {
                String status = response.body().getStatus();
                if(status == "true"){
                    Toast.makeText(DetailsFW.this, "Đã xoá thông tin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailsFW.this,Favourite.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(DetailsFW.this, "Không xoá được thông tin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailsFW.this,Favourite.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DeleteFWModelResult> call, Throwable t) {

            }
        });
    }
}