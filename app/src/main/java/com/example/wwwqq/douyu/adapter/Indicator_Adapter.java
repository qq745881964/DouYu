package com.example.wwwqq.douyu.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Indicator_Adapter extends FragmentPagerAdapter {

    ArrayList<Fragment> arrayList=new ArrayList<>();
    ArrayList<String> arrayList1=new ArrayList<>();

    public Indicator_Adapter(FragmentManager fm, ArrayList<Fragment> arrayList, ArrayList<String> arrayList1) {
        super(fm);
        this.arrayList = arrayList;
        this.arrayList1 = arrayList1;
    }

    public Indicator_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(arrayList1!=null && arrayList1.size()>0)
        {
            return arrayList1.get(position).trim();
        }
        return null;
    }
}
