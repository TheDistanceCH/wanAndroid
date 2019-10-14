package com.wanandroid.app.chwanandroid.wx_public;

import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;

import java.util.List;

/**
 * create time on  2019/7/23
 * function:公众号
 */
public interface PublicContract {

    interface IPubclicView extends IBaseView{

        void requestTitles();

        void onSuccess();

        void onError();

        void updateTitles(List<PublicTitleListBean.DataBean> titles);
    }

    interface IPubclicPresenter extends IBasePresenter{
        void requestPublicTitles();
    }

    interface IPubclicMoudle extends IBaseMoudle{

    }
}
