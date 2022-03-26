package com.example.lib.InterfaceRepository;

import com.example.lib.Model.CategoryModel;
import com.example.lib.Model.DeleteFWModel;
import com.example.lib.Model.DeleteFWModelResult;
import com.example.lib.Model.FavoriteModel;
import com.example.lib.Model.InsertFavoriteModel;
import com.example.lib.Model.InsertFavoriteModelResult;
import com.example.lib.Model.ListenModel;
import com.example.lib.Model.MutichoiceModel;
import com.example.lib.Model.QuestionModel;
import com.example.lib.Model.WordModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.DELETE;


public interface Methods {
    @GET("api/Test/get-question-list")
    Call<QuestionModel> getQuestion();
    @GET("api/Test/get-category-list")
    Call<CategoryModel> getCategory();
    @GET("api/Test/get-word-list")
    Call<WordModel> getWord();
    @GET("api/Test/get-fw-list")
    Call<FavoriteModel> getFW();
    @POST("api/Test/insert-fw-list")
    Call<InsertFavoriteModelResult> insertFavoriteWord(@Body InsertFavoriteModel insertFavoriteModel);
    @POST("api/Test/delete-fw-list")
    Call<DeleteFWModelResult> deleteFavoriteWord(@Body DeleteFWModel deleteFWModel);
    @GET("api/Test/get-tl-list")
    Call<ListenModel> getTL();
    @GET("api/Test/get-mutichoice-list")
    Call<MutichoiceModel> getMutichoice();
}
