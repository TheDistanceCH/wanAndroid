package com.wanandroid.app.chwanandroid.home.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.home.bean.HomeArticleListBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeBannerBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeTopBean;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/16
 * function:
 */
public class HomeMoudle implements IBaseMoudle {

    //置顶
    private List<HomeTopBean.DataBean> datasTop;

    //banner
    private List<HomeBannerBean.DataBean> datasBanner;

    //文章列表
    private List<HomeArticleListBean.DataBean.DatasBean> datsArticleListBean;

    public List<HomeTopBean.DataBean> getDatasTop() {
        return datasTop;
    }

    public void setDatasTop(List<HomeTopBean.DataBean> datasTop) {
        this.datasTop = datasTop;
    }

    public List<HomeBannerBean.DataBean> getDatasBanner() {
        return datasBanner;
    }

    public void setDatasBanner(List<HomeBannerBean.DataBean> datasBanner) {
        this.datasBanner = datasBanner;
    }

    public List<HomeArticleListBean.DataBean.DatasBean> getDatsArticleListBean() {
        return datsArticleListBean;
    }

    public void setDatsArticleListBean(List<HomeArticleListBean.DataBean.DatasBean> datsArticleListBean) {
        this.datsArticleListBean = datsArticleListBean;
    }

    //请求banner数据
    public void requestBanner(HttpProjectApi httpProjectApi, OnHttpResultListener listener) {
        httpProjectApi.homeBanner(listener);
    }

    //请求置顶数据
    public void requestTopArticle(HttpProjectApi httpProjectApi, OnHttpResultListener listener) {
        httpProjectApi.homeTopArticle(listener);
    }


    //请求文章列表
    public void requestArticle(HttpProjectApi httpProjectApi, int page, OnHttpResultListener listener) {
        httpProjectApi.homeArticleList(page, listener);
    }

    //解析文章列表数据
    public List<HomeArticleListBean.DataBean.DatasBean> parseArticleListBean(HomeArticleListBean.DataBean bean, int page) {

        if (datsArticleListBean == null) {
            datsArticleListBean = new ArrayList<>();
        }

        if (bean.getDatas() == null) {
            return datsArticleListBean;
        }
        if (page == 1) {
            datsArticleListBean.clear();
        }

        datsArticleListBean.addAll(bean.getDatas());
        return datsArticleListBean;
    }

    //解析banenr数据
    public List<HomeBannerBean.DataBean> parseBannerBean(HomeBannerBean bean) {
        if (datasBanner == null) {
            datasBanner = new ArrayList<>();
        }

        if (bean.getData() == null) {
            return datasBanner;
        }

        datasBanner.clear();

        datasBanner.addAll(bean.getData());
        return datasBanner;

    }

    //解析置顶文章
    public List<HomeTopBean.DataBean> parseTopBean(HomeTopBean bean) {
        if (datasTop == null) {
            datasTop = new ArrayList<>();
        }

        if (bean.getData() == null) {
            return datasTop;
        }

        datasTop.clear();
        datasTop.addAll(bean.getData());

        return datasTop;

    }




}
