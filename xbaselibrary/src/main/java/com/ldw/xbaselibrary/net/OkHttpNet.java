package com.ldw.xbaselibrary.net;

import android.view.SurfaceHolder;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * Created by ldw on 2017/9/26.
 */

public class OkHttpNet implements Net<Callback>{

    public static void init(OkHttpClient OkHttpClient){
        OkHttpUtils.initClient(OkHttpClient);
    }


    public  void post(String url, Map<String ,String> params, Callback callback){



        PostFormBuilder builder = OkHttpUtils.post().url(url);
        if (params!=null){
            for (String s :params.keySet()){
                builder.addParams(s,params.get(s));
            }
        }


        builder.build().execute(callback);
    }
    public  void get(String url, Map<String ,String> params,Callback callback){


        GetBuilder builder= OkHttpUtils.get().url(url);
        if (params!=null){
            for (String s :params.keySet()){
                builder.addParams(s,params.get(s));
            }
        }

        builder.build().execute(callback);
    }
}
