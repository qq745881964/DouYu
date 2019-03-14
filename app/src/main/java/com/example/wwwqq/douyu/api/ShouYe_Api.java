package com.example.wwwqq.douyu.api;

import com.example.wwwqq.douyu.bean.ShouYe;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ShouYe_Api {

    public static final String URL="http://qf.56.com/home/v4/";

    public static final Retrofit RETROFIT=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

    public static final ShouYe_ApiService HOME_API_SERVICE=RETROFIT.create(ShouYe_ApiService.class);

    public static Observable<ShouYe> getHO(int qq, int ww)
    {
        return HOME_API_SERVICE.getHome(qq,ww);
    }
}
