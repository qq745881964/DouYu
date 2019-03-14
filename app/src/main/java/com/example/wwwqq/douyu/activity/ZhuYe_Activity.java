package com.example.wwwqq.douyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.wwwqq.douyu.R;
import com.example.wwwqq.douyu.adapter.Pager_Adapter;
import com.example.wwwqq.douyu.fragment.WoDe_Fragment;
import com.example.wwwqq.douyu.fragment.ShiPin_Fragment;
import com.example.wwwqq.douyu.fragment.ShouYe_Fragment;
import com.example.wwwqq.douyu.fragment.GuanZhu_Fragment;
import com.example.wwwqq.douyu.fragment.ZhiBo_Fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuYe_Activity extends AppCompatActivity {


    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.r1)
    RadioButton r1;
    @BindView(R.id.r2)
    RadioButton r2;
    @BindView(R.id.r3)
    RadioButton r3;
    @BindView(R.id.r4)
    RadioButton r4;
    @BindView(R.id.r5)
    RadioButton r5;
    @BindView(R.id.group)
    RadioGroup group;
    private ArrayList<Fragment> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye);
        ButterKnife.bind(this);
        Pager_Adapter pagerAdapter=new Pager_Adapter(getSupportFragmentManager(),arrayList);

        arrayList.add(new ShouYe_Fragment());
        arrayList.add(new ZhiBo_Fragment());
        arrayList.add(new ShiPin_Fragment());
        arrayList.add(new GuanZhu_Fragment());
        arrayList.add(new WoDe_Fragment());

        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i==0)
                {
                    r1.setChecked(true);
                    r1.setTextColor(getResources().getColor(R.color.chengse));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }
                else if(i==1)
                {
                    r2.setChecked(true);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.chengse));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }else if(i==2)
                {
                    r3.setChecked(true);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.chengse));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }else if(i==3)
                {
                    r4.setChecked(true);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.chengse));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }else if(i==4)
                {
                    r5.setChecked(true);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.chengse));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.r1)
                {
                    pager.setCurrentItem(0);
                    r1.setTextColor(getResources().getColor(R.color.chengse));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }
                else if(i==R.id.r2)
                {
                    pager.setCurrentItem(1);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.chengse));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }
                else if(i==R.id.r3)
                {
                    pager.setCurrentItem(2);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.chengse));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }
                else if(i==R.id.r4)
                {
                    pager.setCurrentItem(3);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.chengse));
                    r5.setTextColor(getResources().getColor(R.color.huise));
                }
                else if(i==R.id.r5)
                {
                    pager.setCurrentItem(4);
                    r1.setTextColor(getResources().getColor(R.color.huise));
                    r2.setTextColor(getResources().getColor(R.color.huise));
                    r3.setTextColor(getResources().getColor(R.color.huise));
                    r4.setTextColor(getResources().getColor(R.color.huise));
                    r5.setTextColor(getResources().getColor(R.color.chengse));
                }
            }
        });

    }
}
