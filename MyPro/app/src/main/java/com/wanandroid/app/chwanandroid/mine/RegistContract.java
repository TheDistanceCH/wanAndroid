package com.wanandroid.app.chwanandroid.mine;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

/**
 * created by chenhua
 * create time on  2019/10/11
 * function:
 */
public interface RegistContract {

    interface IRegistView extends IBaseView {

        void requestRegist();

        void onSuccrss();

        void onFailure();

        void sendToVertification();

        void startCountDown();

        String getTel();
        String getPwd();
        String getRePwd();


    }

    interface IRegistPresenter extends IBasePresenter {
        void startRegist(String tel, String pwd,String rePwd);

        //设置监听
        void initEventHandler();

        //取消监听
        void unregistEventHandler();
    }

    interface IRegistMoudle extends IBaseMoudle {
        void requestDatas(HttpProjectApi httpProjectApi, String tel, String pwd,String repwd,
                          OnHttpResultListener listener);
    }
}
