package com.jokerwan.uselitepal;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by ${JokerWan} on 2017/4/12.
 * WeChat：wjc398556712
 * Function：
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化LitePl
        LitePal.initialize(this);
    }
}
