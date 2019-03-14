package com.example.wwwqq.douyu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwwqq.douyu.R;
import com.example.wwwqq.douyu.utils.TopMiddlePopup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.vov.vitamio.utils.Log;

public class ZhiBo_Fragment extends Fragment implements View.OnClickListener {


    public static int screenW, screenH;
    @BindView(R.id.urm_back_btn)
    ImageButton urmBackBtn;
    @BindView(R.id.urm_top_tv)
    TextView urmTopTv;
    @BindView(R.id.urm_top_iv)
    ImageView urmTopIv;
    @BindView(R.id.urm_top_ll)
    LinearLayout urmTopLl;
    @BindView(R.id.urm_create_btn)
    ImageButton urmCreateBtn;
    @BindView(R.id.urm_confirm_btn)
    Button urmConfirmBtn;
    @BindView(R.id.urm_top_right_rl)
    RelativeLayout urmTopRightRl;
    @BindView(R.id.urm_search_btn)
    ImageButton urmSearchBtn;
    @BindView(R.id.rule_line_tv)
    TextView ruleLineTv;
    @BindView(R.id.main_tv)
    TextView mainTv;
    Unbinder unbinder;
    private TopMiddlePopup middlePopup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.zhibo_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        getScreenPixels();
        initWidget();

        return view;
    }

    private void initWidget() {
        urmTopTv.setText("企业客户");
        urmBackBtn.setOnClickListener(this);
        urmCreateBtn.setOnClickListener(this);
        urmConfirmBtn.setOnClickListener(this);
        urmTopLl.setOnClickListener(this);
    }

    private void setPopup(int type) {
        middlePopup = new TopMiddlePopup(getContext(), screenW, screenH,
                onItemClickListener, getItemsName(), type);
    }

    /**
     * 设置弹窗内容
     *
     * @return
     */
    private ArrayList<String> getItemsName() {
        ArrayList<String> items = new ArrayList<String>();
        items.add("企业客户");
        items.add("集团客户");
        items.add("公海客户");
        return items;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.urm_back_btn:
                setPopup(1);
                middlePopup.show(ruleLineTv);
                break;
            case R.id.urm_create_btn:
                setPopup(2);
                middlePopup.show(ruleLineTv);
                break;
            case R.id.urm_confirm_btn:

                break;
            case R.id.urm_top_ll:
                setPopup(0);
                middlePopup.show(ruleLineTv);
                Toast.makeText(getContext(), "企业客户", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 弹窗点击事件
     */
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            switch (position)
            {
                case 0:
                    Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
                    break;
            }

//            System.out.println("--onItemClickListener--:");
//            middlePopup.dismiss();
        }
    };

    /**
     * 获取屏幕的宽和高
     */
    public void getScreenPixels() {
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenW = metrics.widthPixels;
        screenH = metrics.heightPixels;
    }

}
