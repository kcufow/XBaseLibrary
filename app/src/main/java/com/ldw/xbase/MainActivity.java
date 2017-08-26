package com.ldw.xbase;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.ldw.xbaselibrary.baseui.XBaseActivity;

import butterknife.BindView;

public class MainActivity extends XBaseActivity {


    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    public void initView() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


}
