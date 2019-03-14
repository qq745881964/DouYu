package com.example.wwwqq.douyu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wwwqq.douyu.R;
import com.example.wwwqq.douyu.bean.ShouYe;
import com.example.wwwqq.douyu.persenter.ShouYe_Personter;
import com.example.wwwqq.douyu.persenter.ShouYe_PersonterImpl;
import com.example.wwwqq.douyu.view.ShouYe_View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ShouYe_View {

    @BindView(R.id.text)
    TextView text;
    private int qq=0,ww=0;
    private ShouYe_Personter shouYe_personter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        shouYe_personter=new ShouYe_PersonterImpl(this);
        shouYe_personter.getHomeData(qq,ww);

    }

    @Override
    public void loadHomeData(ShouYe shouYe) {
        text.setText(shouYe.toString());
    }
}
