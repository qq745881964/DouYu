package com.example.wwwqq.douyu.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wwwqq.douyu.R;

import java.util.ArrayList;

public class PopupAdaptr extends BaseAdapter {

    private Context myContext;
    private LayoutInflater inflater;
    private ArrayList<String> myItems;
    private int myType;

    public PopupAdaptr(Context myContext, ArrayList<String> myItems, int myType) {
        this.myContext = myContext;
        this.myItems = myItems;
        this.myType = myType;

        inflater=LayoutInflater.from(myContext);

    }

    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int i) {
        return myItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PopupHolder holder = null;
        if (view == null) {
            holder = new PopupHolder();
            view = inflater.inflate(R.layout.top_popup_item, null);
            holder.itemNameTv = (TextView) view
                    .findViewById(R.id.popup_tv);
            if (myType == 0) {
                holder.itemNameTv.setGravity(Gravity.CENTER);
            } else if (myType == 1) {
                holder.itemNameTv.setGravity(Gravity.LEFT);
            } else if (myType == 2) {
                holder.itemNameTv.setGravity(Gravity.RIGHT);
            }
            view.setTag(holder);
        } else {
            holder = (PopupHolder) view.getTag();
        }
        holder.itemNameTv.setText(getItem(i)+"");
        return view;
    }

    private class PopupHolder {
        TextView itemNameTv;
    }

}
