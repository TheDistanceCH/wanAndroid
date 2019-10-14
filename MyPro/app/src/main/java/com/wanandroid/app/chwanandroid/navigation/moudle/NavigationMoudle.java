package com.wanandroid.app.chwanandroid.navigation.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.navigation.NavigationContract;
import com.wanandroid.app.chwanandroid.navigation.bean.NavigationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/31
 * function: 导航
 */
public class NavigationMoudle implements NavigationContract.INavigationMoudle {

    private List<NavigationBean.DataBean.ArticlesBean> datas;

    @Override
    public void requestDatas(HttpProjectApi httpProjectApi, OnHttpResultListener listener) {
        httpProjectApi.navigationList(listener);
    }

    @Override
    public List<NavigationBean.DataBean.ArticlesBean> parseNavigations(NavigationBean bean) {
        if (datas == null) {
            datas = new ArrayList<>();
        }

        if (bean.getData() == null || bean.getData().size() == 0) {
            return datas;
        }

        datas.clear();

        for (int i = 0; i < bean.getData().size(); i++) {
            for (int j = 0; j < bean.getData().get(i).getArticles().size(); j++) {
                datas.add(bean.getData().get(i).getArticles().get(j));
            }
        }

        return datas;
    }
}
