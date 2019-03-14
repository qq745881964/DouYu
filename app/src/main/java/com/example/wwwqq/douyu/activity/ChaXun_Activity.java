package com.example.wwwqq.douyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wwwqq.douyu.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChaXun_Activity extends AppCompatActivity {

    @BindView(R.id.searchEdit)
    SearchView searchEdit;
    @BindView(R.id.listView)
    ListView listView;

    private ArrayList<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaxun);
        ButterKnife.bind(this);

        arrayList.clear();
        arrayList.add("qqq");
        arrayList.add("www");
        arrayList.add("eee");

        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList));
        //ListView启动过滤
        listView.setTextFilterEnabled(true);
        //一开始不显示
        listView.setVisibility(View.GONE);
        //搜索框不自动缩小为一个搜索图标，而是Match_parent
        searchEdit.setIconifiedByDefault(false);
        //显示搜索按钮
        searchEdit.setSubmitButtonEnabled(true);
        //默认提示文本
        searchEdit.setQueryHint("查找");

        searchEdit.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单击搜索按钮的监听
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(ChaXun_Activity.this, "123", Toast.LENGTH_SHORT).show();
                return false;
            }

            //输入字符的监听
            @Override
            public boolean onQueryTextChange(String s) {

                if(TextUtils.isEmpty(s))
                {
                    listView.setVisibility(View.GONE);
                    listView.clearTextFilter();
                }
                else
                    {
                        listView.setVisibility(View.VISIBLE);
                        listView.setFilterText(s);
                    }

                return true;
            }
        });
    }
}
