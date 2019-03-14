package com.example.wwwqq.douyu.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollView_TranslucentListener extends ScrollView {

    Trans trans;

    public void setListener(Trans trans)
    {
        this.trans=trans;
    }

    public ScrollView_TranslucentListener(Context context) {
        super(context);

    }

    public ScrollView_TranslucentListener(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public interface Trans
    {
        public void onTranslucent(float alpha);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(trans!=null)
        {
            // alpha = 滑出去的高度/(screenHeight/3);
            float heightPixels = getContext().getResources().getDisplayMetrics().heightPixels;
            float scrollY = getScrollY();//该值 大于0
            float alpha = scrollY/(heightPixels/3);// 0~1 透明度是1~0
            //这里选择的screenHeight的1/3 是alpha改变的速率 （根据你的需要你可以自己定义）
            trans.onTranslucent(alpha);
        }
    }

}


