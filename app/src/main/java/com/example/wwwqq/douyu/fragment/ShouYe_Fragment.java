package com.example.wwwqq.douyu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wwwqq.douyu.R;
import com.example.wwwqq.douyu.activity.ChaXun_Activity;
import com.example.wwwqq.douyu.adapter.Indicator_Adapter;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShouYe_Fragment extends Fragment {

    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.img_scanner)
    ImageView imgScanner;
    @BindView(R.id.img_history)
    ImageView imgHistory;
    @BindView(R.id.img_message)
    ImageView imgMessage;
    @BindView(R.id.id_indicator)
    TabPageIndicator idIndicator;
    @BindView(R.id.id_pager)
    ViewPager idPager;
    Unbinder unbinder;

    ArrayList<Fragment> arrayList=new ArrayList<>();
    ArrayList<String> arrayList1=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shouye_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        arrayList1.clear();
        arrayList.clear();

        arrayList.add(new TuiJian_Fragment());
        arrayList.add(new ShouYou_Fragment());
        arrayList.add(new YuLe_Fragment());
        arrayList.add(new YouXi_Fragment());
        arrayList.add(new QuWan_Fragment());

        arrayList1.add("推荐");
        arrayList1.add("手游");
        arrayList1.add("娱乐");
        arrayList1.add("游戏");
        arrayList1.add("趣玩");

        Indicator_Adapter adapter=new Indicator_Adapter(getActivity().getSupportFragmentManager(),arrayList,arrayList1);
        idPager.setAdapter(adapter);
        idIndicator.setViewPager(idPager);

        imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "查询", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),ChaXun_Activity.class));
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
