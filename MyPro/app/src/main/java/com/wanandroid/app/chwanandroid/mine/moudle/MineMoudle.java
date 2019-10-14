package com.wanandroid.app.chwanandroid.mine.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.MineContract;

/**
 * create time on  2019/8/12
 * function:
 */
public class MineMoudle implements MineContract.IMineMoudle {
    @Override
    public void loginOut(HttpProjectApi httpProjectApi, OnHttpResultListener listener) {
        httpProjectApi.mineExit(listener);
    }
}
