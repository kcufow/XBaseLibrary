package com.ldw.xbaselibrary.baseui;

import android.os.Bundle;

/**
 * Created by ldw on 2017/8/23.
 */

public interface UiInit {
    /**
     * view的初始化，没有使用ButterKnife时可以在此方法中findViewById
     */
    void initView();

    void initData(Bundle savedInstanceState);

    void setListener();

    int getLayoutId();
}
