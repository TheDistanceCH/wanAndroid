package com.wanandroid.app.chwanandroid.wx_public;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicSearchBean;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;

import java.util.List;

/**
 * create time on  2019/7/30
 * function: 公众号搜索
 */
public interface PublicSearchContract {

    interface IPublicSearchView extends IBaseView{

        void onSuccess();
        void onFailure();
        void onUpdateDatas(List<PublicSearchBean.DataBean.DatasBean> datas);
        void updateTitles(List<PublicTitleListBean.DataBean> datas);
        void goDetailActivity(String title,String url);
    }


    interface IPublicSearchPresenter extends IBasePresenter{
        void requestDatas(int weixin,String s);
        void fresh(int weixn,String s);
        void loadrMore();
        void requestPublicTitle();
    }

    interface IPublicMoudle extends IBaseMoudle{
        void requesrDatas(HttpProjectApi httpProjectApi, int page, int weixin, String search,
                          OnHttpResultListener listener);
        List<PublicSearchBean.DataBean.DatasBean> parsePublicSearch(PublicSearchBean bean,int page);
    }
}
