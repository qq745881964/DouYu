package com.example.wwwqq.douyu.fragment;

import  android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dueeeke.videoplayer.util.L;
import com.example.wwwqq.douyu.R;
import com.example.wwwqq.douyu.bean.QuBaobei;
import com.example.wwwqq.douyu.view.RetrofitServer;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static io.vov.vitamio.utils.Log.TAG;

public class YouXi_Fragment extends Fragment {

    @BindView(R.id.button_Volley)
    Button buttonVolley;
    @BindView(R.id.button_OkHttp)
    Button buttonOkHttp;
    @BindView(R.id.button_Retrofit)
    Button buttonRetrofit;
    @BindView(R.id.text_huoqu)
    TextView textHuoqu;
    Unbinder unbinder;

    String URL="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";

    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if(message.what==1)
            {
                Object string=message.obj;
                textHuoqu.setText("OkHttp:"+string+"");
            }
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.youxi_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        buttonVolley.setOnClickListener(new View.OnClickListener() {
//            get请求
//            1. 创建一个RequestQueue对象。
//            2. 创建一个StringRequest对象。
//            3. 将StringRequest对象添加到RequestQueue里面。
            @Override
            public void onClick(View view) {
                //首先获取一个RequestQueue对象
                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                //获取数据，我们还需要创建一个StringRequest对象
                StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
                    @Override
                    //获取成功
                    public void onResponse(String response) {
                        QuBaobei quBaobei=new Gson().fromJson(response,QuBaobei.class);
                        textHuoqu.setText("Volley:"+quBaobei.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    //获取失败
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                //将这个StringRequest对象添加到RequestQueue中
                requestQueue.add(stringRequest);
            }
        });

        buttonOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient okHttpClient=new OkHttpClient();
                        Request request=new Request.Builder().url(URL).get().build();
                        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
                            @Override
                            public void onFailure(okhttp3.Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                                if(response!=null&&response.isSuccessful())
                                {
                                    String string = response.body().string();
                                    QuBaobei quBaobei=new Gson().fromJson(string,QuBaobei.class);

                                    Message message=new Message();
                                    message.what=1;
                                    message.obj=quBaobei;
                                    handler.sendMessage(message);
                                }
                            }
                        });
                    }
                }).start();
            }
        });

        buttonRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://www.qubaobei.com/ios/cf/").addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();
                RetrofitServer retrofitServer = retrofit.create(RetrofitServer.class);
                Call<QuBaobei> result = retrofitServer.getResult(1, 20, 1);
                result.enqueue(new Callback<QuBaobei>() {
                    @Override
                    public void onResponse(Call<QuBaobei> call, retrofit2.Response<QuBaobei> response) {
                        List<QuBaobei.DataBean> data = response.body().getData();
                        textHuoqu.setText("Retrofit:"+data.toString());
                    }
                    @Override
                    public void onFailure(Call<QuBaobei> call, Throwable t) {

                    }
                });
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
