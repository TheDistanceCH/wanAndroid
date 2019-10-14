package com.wanandroid.app.chwanandroid.wx_public;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.http.HttpService;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicListBean;

import java.util.List;

/**
 * create time on  2019/7/28
 * function:
 */
public interface SubPublicContrract {
    interface ISubPublicView extends IBaseView {
        void requestDatas();
        void onSuccess();
        void onFalire();
        void updateDatas(List<PublicListBean.DataBean.DatasBean> datas);
        void goDetailActivity(String title,String url);
    }

    interface ISubPublicPresenter extends IBasePresenter {
        void requesrDatras();
        void fresh();
        void loadMore();
        void setWeixin(int weixn);


    }

    interface IsubPublicMoudle extends IBaseMoudle{
        void requestdatas(HttpProjectApi httpProjectApi, int weixin, int page,
                          OnHttpResultListener listener);

        List<PublicListBean.DataBean.DatasBean>  parseSubPublicListDatas(PublicListBean.DataBean bean,int page);
    }
}
