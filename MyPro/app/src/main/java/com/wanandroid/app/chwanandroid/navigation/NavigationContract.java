package com.wanandroid.app.chwanandroid.navigation;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.navigation.bean.NavigationBean;

import java.util.List;

/**
 * create time on  2019/7/23
 * function:
 */
public interface NavigationContract {

    interface INavigationView extends IBaseView{
        void requestDatas();
        void onSuccess();
        void onFailure();
        void updateDatas(List<NavigationBean.DataBean.ArticlesBean> datas);
    }

    interface INavigationPresenter extends IBasePresenter{
        void requestDatas();

    }

    interface INavigationMoudle extends IBaseMoudle{
        void requestDatas(HttpProjectApi httpProjectApi, OnHttpResultListener listener);
        List<NavigationBean.DataBean.ArticlesBean> parseNavigations(NavigationBean bean);
    }
}
