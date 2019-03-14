package com.example.wwwqq.douyu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wwwqq.douyu.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class YuLe_Fragment extends Fragment {

    @BindView(R.id.button_EventBus)
    Button buttonEventBus;
    @BindView(R.id.text_EventBus)
    TextView textEventBus;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.yule_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);//注册EventBus

        buttonEventBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post("发送一条消息");//发送
            }
        });

        return view;

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String string)
    {
        textEventBus.setText("传过来的内容是:"+string);//接受
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if(EventBus.getDefault().isRegistered( this))
        {
            EventBus.getDefault().unregister(this);//关闭EventBus
        }
    }
}
