package com.example.wwwqq.douyu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.example.wwwqq.douyu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.vov.vitamio.utils.Log;

public class ShiPin_Fragment extends Fragment {

    @BindView(R.id.player)
    IjkVideoView player;
    @BindView(R.id.auto)
    AutoCompleteTextView auto;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shipin_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        final List<String> arrayList=new ArrayList<>();

        arrayList.add("西游记");
        arrayList.add("西西西");
        arrayList.add("三国演义");
        arrayList.add("水浒传");
        arrayList.add("十万个为什么");
        arrayList.add("葫芦娃");
        arrayList.add("啦啦啦啦啦");
        arrayList.add("呵呵呵呵呵");
        arrayList.add("嘿嘿嘿嘿嘿");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, arrayList);
        auto.setAdapter(adapter);

        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv= (TextView) view;
                Toast.makeText(getContext(), tv.getText()+"", Toast.LENGTH_SHORT).show();
            }
        });

        player.setUrl("http://169.254.125.188:8080/web_home/static/api/news/Robbie_Williams-Love_My_Life.mp4");
        StandardVideoController controller = new StandardVideoController(getContext());
        player.setVideoController(controller);

        //高级设置（可选，须在start()之前调用方可生效）
        PlayerConfig playerConfig = new PlayerConfig.Builder()
                .autoRotate() //启用重力感应自动进入/退出全屏功能
                .enableMediaCodec()//启动硬解码，启用后可能导致视频黑屏，音画不同步
                .usingSurfaceView() //启用SurfaceView显示视频，不调用默认使用TextureView
                .savingProgress() //保存播放进度
                .disableAudioFocus() //关闭AudioFocusChange监听
                .setLooping() //循环播放当前正在播放的视频
                .build();
        player.setPlayerConfig(playerConfig);
        player.start();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
