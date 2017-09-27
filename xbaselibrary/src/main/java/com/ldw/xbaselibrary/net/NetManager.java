package com.ldw.xbaselibrary.net;

import android.text.TextUtils;


import java.util.Map;


/**
 * Created by ldw on 2017/9/12.
 */

public class NetManager implements Net<Object> {
    private static NetManager netManager = null;
    Net net = new OkHttpNet();
        private NetManager(){

        }

    public void setRequestType(Net net){
        this.net = net;
    }

    public static NetManager getInstance(){
        if (netManager==null){
            synchronized (NetManager.class){

                if (netManager==null){

                    netManager = new NetManager();
                }
            }
        }

        return netManager;

    }

    /**
     * post请求
     * @param url
     * @param params
     * @param callback 相应的callback
     */

    public  void post(String url, Map<String ,String> params,Object callback){

        net.post(url,params, callback);


    }
    public  void get(String url, Map<String ,String> params,Object callback) {
        net.get(url,params,callback);
    }
}
