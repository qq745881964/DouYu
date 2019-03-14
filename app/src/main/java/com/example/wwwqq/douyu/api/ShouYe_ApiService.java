package com.example.wwwqq.douyu.api;

import com.example.wwwqq.douyu.bean.ShouYe;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface   ShouYe_ApiService {

    @GET("moreAnchor.android")
    Observable<ShouYe> getHome(@Query("type") int type, @Query("index") int index);

}
