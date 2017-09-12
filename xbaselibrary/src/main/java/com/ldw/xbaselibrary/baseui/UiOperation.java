package com.ldw.xbaselibrary.baseui;

import android.view.View;

/**
 * Created by ldw on 2017/8/28.
 */

public interface UiOperation {

    void startActivityFinish(Class clazz);
    void startActivityNormal(Class clazz);
    void viewGone(View view);
    void viewInvisible(View view);
    void viewVisible(View view);

}
