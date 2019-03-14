package com.example.wwwqq.douyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.wwwqq.douyu.R;

import io.vov.vitamio.utils.Log;

public class Activity_ZhouQi extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhouqi);
        Log.e("haha————————————OnCreate","————————————OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("haha————————————OnStart","————————————OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("haha————————————OnRestart","————————————OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("haha————————————OnResume","————————————OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("haha————————————OnPause","————————————OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("haha————————————OnStop","————————————OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("haha————————————onDestroy","————————————onDestroy");
    }
}
