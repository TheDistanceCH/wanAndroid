package com.wanandroid.app.chwanandroid.mine;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

/**
 * create time on  2019/8/12
 * function:
 */
public interface LoginContract {

    interface IloginView extends IBaseView {


        void requestLogin();

        void onSuccrss();

        void onFailure();

        void goRegistActivity();

    }

    interface ILoginPresenter extends IBasePresenter {
        void startLogin(String tel, String pwd);

    }

    interface ILoginMoudle extends IBaseMoudle {
        void requestDatas(HttpProjectApi httpProjectApi, String tel, String pwd,
                          OnHttpResultListener listener);
    }
}
