package com.ldw.xbaselibrary.baseui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ldw.xbaselibrary.kit.KnifeKit;

import butterknife.Unbinder;

/**
 * Created by ldw on 2017/8/23.
 */

public abstract class XBaseActivity extends AppCompatActivity implements UiInit,UiOperation{
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




    public void startActivityFinish(Class clazz){
        Intent intent = new Intent(XBaseActivity.this,clazz);
        startActivity(intent);
        finish();
    }
    public void startActivityNormal(Class clazz){
        Intent intent = new Intent(XBaseActivity.this,clazz);
        startActivity(intent);
    }
    public void viewGone(View view){
        view.setVisibility(View.GONE);

    }
    public void viewInvisible(View view){
        view.setVisibility(View.INVISIBLE);

    }
    public void viewVisible(View view){
        view.setVisibility(View.VISIBLE);

    }
    public <V extends View> V findView(int viewId){
        V view = (V) findViewById(viewId);

        return view;
    }

}
