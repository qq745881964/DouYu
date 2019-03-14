package com.example.wwwqq.douyu.view;

import com.example.wwwqq.douyu.bean.QuBaobei;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServer {
    @GET("dish_list.php")
    Call<QuBaobei> getResult(@Query("stage_id") int stage_id,@Query("limit") int limit,@Query("page") int page);
}
