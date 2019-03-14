package com.example.wwwqq.douyu.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ZhuYe_ViewPager extends ViewPager {

    private boolean scrollable = false;

    public ZhuYe_ViewPager(@NonNull Context context) {
        super(context);
    }

    public ZhuYe_ViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void ZhuYe_ViewPager( boolean scrollable) {
        this.scrollable = scrollable;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        return scrollable;
    }


}
