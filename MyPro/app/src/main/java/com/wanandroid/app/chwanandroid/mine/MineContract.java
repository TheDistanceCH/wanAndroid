package com.wanandroid.app.chwanandroid.mine;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

/**
 * create time on  2019/7/23
 * function:
 */
public interface MineContract {

    interface IMineView extends IBaseView {
        void onError();
        void onSuccess();

    }

    interface IMinePresenter extends IBasePresenter {
        void loginOut();

    }

    interface IMineMoudle extends IBaseMoudle {
        void loginOut(HttpProjectApi httpProjectApi, OnHttpResultListener listener);
    }
}
