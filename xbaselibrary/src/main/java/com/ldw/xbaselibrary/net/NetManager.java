package com.ldw.xbaselibrary.net;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * Created by ldw on 2017/9/12.
 */

public class NetManager {
    private static NetManager netManager = null;
        private NetManager(){

        }

    public static NetManager init(OkHttpClient okHttpClient){
        OkHttpUtils.initClient(okHttpClient);
        if (netManager==null){
            synchronized (NetManager.class){

                if (netManager==null){

                    netManager = new NetManager();
                }
            }
        }

        return netManager;

    }
    public static NetManager getInstance(){
        return init(null);
    }

    public static void post(String url, Map<String ,String> params, Callback callback){
        PostFormBuilder builder = OkHttpUtils.post().url(url);

        for (String s :params.keySet()){
            builder.addParams(s,params.get(s));
        }
        builder.build().execute(callback);
    }
    public static void get(String url, Map<String ,String> params,Callback callback){
        GetBuilder builder= OkHttpUtils.get().url(url);

        for (String s :params.keySet()){
            builder.addParams(s,params.get(s));
        }
        builder.build().execute(callback);
    }
}
