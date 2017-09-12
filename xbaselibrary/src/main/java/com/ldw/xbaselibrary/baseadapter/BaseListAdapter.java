package com.ldw.xbaselibrary.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by ldw on 2017/8/28.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected Context mContext;



    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mContext ==null){

            mContext = parent.getContext();
        }

        T holder;
        View view;

        if (convertView == null){
            view = LayoutInflater.from(mContext).inflate(getLayoutId(),parent,false);
            holder = bindViewHolder(view);
            view.setTag(holder);

        }else {
            view = convertView;
            holder = (T) view.getTag();

        }

        dataSettingHolder(holder);

        return view;
    }

    protected abstract void dataSettingHolder(T holder);

    public abstract T bindViewHolder(View view);

    public abstract int getLayoutId();
    public <V extends View>V findView(View view ,int viewId){
        V newView =(V) view.findViewById(viewId);

        return newView;
    }


}
