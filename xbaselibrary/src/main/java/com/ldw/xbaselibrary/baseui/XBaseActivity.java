package com.ldw.xbaselibrary.baseui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ldw.xbaselibrary.kit.KnifeKit;

import butterknife.Unbinder;

/**
 * Created by ldw on 2017/8/23.
 */

public abstract class XBaseActivity extends AppCompatActivity implements UiInit{
    protected Activity context;
    protected Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this;

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeKit.bind(this);
        }
        initView();
        setListener();
        initData(savedInstanceState);
    }
}
