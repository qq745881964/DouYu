package com.example.wwwqq.douyu.model;

import com.example.wwwqq.douyu.bean.ShouYe;
import rx.Subscriber;
import rx.Subscription;

public interface ShouYe_Model
{
    Subscription SUBSCRIPTION(Subscriber<ShouYe> subscriber, int qq, int ww);

}
