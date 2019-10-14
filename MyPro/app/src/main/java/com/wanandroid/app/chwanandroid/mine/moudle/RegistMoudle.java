package com.wanandroid.app.chwanandroid.mine.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.RegistContract;

/**
 * created by chenhua
 * create time on  2019/10/11
 * function:
 */
public class RegistMoudle implements RegistContract.IRegistMoudle {



    @Override
    public void requestDatas(HttpProjectApi httpProjectApi, String tel, String pwd, String repwd,
                             OnHttpResultListener listener) {
        httpProjectApi.mineRegist(tel, pwd, repwd, listener);
    }
}
