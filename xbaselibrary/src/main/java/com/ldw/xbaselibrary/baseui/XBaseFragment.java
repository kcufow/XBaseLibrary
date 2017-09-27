package com.ldw.xbaselibrary.baseui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ldw.xbaselibrary.kit.KnifeKit;

import butterknife.Unbinder;

/**
 * Created by ldw on 2017/8/24.
 */

public abstract class XBaseFragment extends Fragment implements UiInit,UiOperation {


    protected View rootView;
    protected LayoutInflater layoutInflater;
    protected Activity mContext;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        layoutInflater = inflater;
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), null);
            unbinder = KnifeKit.bind(this, rootView);
        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }

        initView();

        return rootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void delayLoadData() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListener();
        initData(savedInstanceState);
    }


    @Override
    public void startActivityFinish(Class clazz) {
        Intent intent = new Intent(mContext,clazz);
        mContext.startActivity(intent);
        mContext.finish();
    }

    @Override
    public void startActivityNormal(Class clazz) {
        Intent intent = new Intent(mContext,clazz);
        mContext.startActivity(intent);
    }

    @Override
    public void viewGone(View view) {
        view.setVisibility(View.GONE);

    }

    @Override
    public void viewInvisible(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    @Override
    public void viewVisible(View view) {
        view.setVisibility(View.VISIBLE);
    }
}
