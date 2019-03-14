package com.example.wwwqq.douyu.model;
import com.example.wwwqq.douyu.api.ShouYe_Api;
import com.example.wwwqq.douyu.bean.ShouYe;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShouYe_ModelImpl implements ShouYe_Model{


    @Override
    public Subscription SUBSCRIPTION(Subscriber<ShouYe> subscriber, int qq, int ww) {

        Observable<ShouYe> home=ShouYe_Api.getHO(qq,ww);

        home.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

        return subscriber;
    }
}
