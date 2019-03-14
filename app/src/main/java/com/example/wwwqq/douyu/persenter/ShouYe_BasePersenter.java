package com.example.wwwqq.douyu.persenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class ShouYe_BasePersenter {

    protected CompositeSubscription mCon;

    public void addsub(Subscription subscription)
    {
        if(mCon==null)
        {
            mCon=new CompositeSubscription();
        }
        mCon.add(subscription);
    }

}
