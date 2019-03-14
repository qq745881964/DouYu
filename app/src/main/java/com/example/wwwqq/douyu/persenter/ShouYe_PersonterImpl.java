package com.example.wwwqq.douyu.persenter;

import com.example.wwwqq.douyu.bean.ShouYe;
import com.example.wwwqq.douyu.model.ShouYe_Model;
import com.example.wwwqq.douyu.model.ShouYe_ModelImpl;
import com.example.wwwqq.douyu.view.ShouYe_View;

import rx.Subscriber;

public class ShouYe_PersonterImpl extends ShouYe_Personter{

    private ShouYe_View shouYe_view;
    private ShouYe_Model shouYe_model;

    public ShouYe_PersonterImpl(ShouYe_View shouYe_view) {
        this.shouYe_view = shouYe_view;
        shouYe_model=new ShouYe_ModelImpl();
    }

    Subscriber<ShouYe> subscriber=new Subscriber<ShouYe>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(ShouYe shouYe) {
            shouYe_view.loadHomeData(shouYe);
        }
    };

    @Override
    public void getHomeData(int qq, int ww) {
        addsub(shouYe_model.SUBSCRIPTION(subscriber,qq,ww));
    }
}
