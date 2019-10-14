package com.wanandroid.app.chwanandroid.home;

import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.home.bean.HomeArticleListBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeBannerBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeTopBean;
import com.youth.banner.Banner;

import java.util.List;

/**
 * create time on  2019/7/15
 * function:
 */
public interface HomeContract {

    interface IHomeView extends IBaseView {

        void updateBanner(List<HomeBannerBean.DataBean> datas);

        void updateTopArticle(List<HomeTopBean.DataBean> datas);

        void updateArticleList(List<HomeArticleListBean.DataBean.DatasBean> datas);


        /**
         *
         * @param type 要更新哪个类型？banner、置顶、列表三类
         * @param pos 更新的item位置
         * @param b 是收藏成功还是取消收藏
         */
        void updateCollectItem(int type,int pos,boolean b);
        void clickCollectImg(int pos);
        void onSuccess();

        void onError();

        void goPassDetailPage(String title,String url);



    }

    interface IHomePresenter extends IBasePresenter {
        void requestBanner();

        void requestTopArticle();

        void requestArticleList();

        void requestCollectOn(String id);

        void requestCollectOut(String title,String author,String link);

        void requestMore();

        void requestFresh();



    }

    interface IHomeMoudle extends IBaseMoudle {

    }


}
