package com.ldw.xbaselibrary.net;

import java.util.Map;

/**
 * Created by ldw on 2017/9/26.
 */

public interface Net<T> {
    void post(String url, Map<String ,String> params,T callback);
    void get(String url, Map<String ,String> params,T callback);
}
