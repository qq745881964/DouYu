package com.example.wwwqq.douyu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wwwqq.douyu.R;
import com.example.wwwqq.douyu.utils.ScrollView_TranslucentListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuWan_Fragment extends Fragment implements ScrollView_TranslucentListener.Trans {

    @BindView(R.id.scrollview)
    ScrollView_TranslucentListener scrollview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.quwan_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        scrollview.setListener(this);
        toolbar.setAlpha(0);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onTranslucent(float alpha) {
        toolbar.setAlpha(alpha);
    }
}
