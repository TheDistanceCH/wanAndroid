package com.wanandroid.app.chwanandroid.mine.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.LoginContract;

/**
 * create time on  2019/8/12
 * function:
 */
public class LoginMoudle implements LoginContract.ILoginMoudle {

    @Override
    public void requestDatas(HttpProjectApi httpProjectApi, String tel, String pwd, OnHttpResultListener listener) {
        httpProjectApi.mineLogin(tel,pwd,listener);
    }
}
