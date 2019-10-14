package com.wanandroid.app.chwanandroid.home.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.constant.ConstantClass;
import com.wanandroid.app.chwanandroid.home.HomeContract;
import com.wanandroid.app.chwanandroid.home.adapter.HomeArticleAdapter;
import com.wanandroid.app.chwanandroid.home.adapter.HomeTopAdapter;
import com.wanandroid.app.chwanandroid.home.bean.HomeArticleListBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeBannerBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeTopBean;
import com.wanandroid.app.chwanandroid.home.listener.OnHomeItemListener;

import com.wanandroid.app.chwanandroid.home.presenter.HomePresenter;
import com.wanandroid.app.chwanandroid.pass_detail.view.PassDetailActivity;
import com.wanandroid.app.chwanandroid.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;



import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * create time on  2019/7/15
 * function: 首页
 */
public class HomeFrag extends BaseFragment<HomeContract.IHomePresenter>
        implements HomeContract.IHomeView {


    @Bind(R.id.banner_home)
    Banner bannerHome;
    @Bind(R.id.recy_hot_home)
    RecyclerView recyHotHome;
    @Bind(R.id.recy_list_home)
    RecyclerView recyListHome;
    @Bind(R.id.smart_home)
    SmartRefreshLayout smartHome;


    private HomeTopAdapter homeTopAdapter;
    private HomeArticleAdapter homeArticleAdapter;
    private List<HomeBannerBean.DataBean> datasBanner = new ArrayList<>();
    private List<HomeTopBean.DataBean> datasTop = new ArrayList<>();

    private List<HomeArticleListBean.DataBean.DatasBean> datasArticle = new ArrayList<>();


    @Override
    protected HomeContract.IHomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        initBanner();
        initTopRecycler();
        initArcitleRecycler();

        smartHome.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.requestMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.requestFresh();
            }
        });

        requestDatas();

    }

    private void requestDatas() {
        mPresenter.requestBanner();
        ;
        mPresenter.requestTopArticle();
        mPresenter.requestArticleList();
    }


    private void initArcitleRecycler() {
        homeArticleAdapter = new HomeArticleAdapter(mContext, datasArticle, new OnHomeItemListener() {
            @Override
            public void onItemClick(int pos) {
                goPassDetailPage(datasArticle.get(pos).getTitle(), datasArticle.get(pos).getLink());
            }

            @Override
            public void onItemCollectImgClick(int pos) {

            }
        });

        recyListHome.setAdapter(homeArticleAdapter);
        recyListHome.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initTopRecycler() {
        homeTopAdapter = new HomeTopAdapter(mContext, datasTop, new OnHomeItemListener() {
            @Override
            public void onItemClick(int pos) {
                goPassDetailPage(datasTop.get(pos).getTitle(), datasTop.get(pos).getLink());
            }

            @Override
            public void onItemCollectImgClick(int pos) {
                //点击了收藏按钮
                clickCollectImg(pos);
            }
        });
        recyHotHome.setAdapter(homeTopAdapter);
        recyHotHome.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initBanner() {
        //设置banner图片加载器
        bannerHome.setImageLoader(new GlideImageLoader());
        //设置banner样式
        bannerHome.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置动画效果
        bannerHome.setBannerAnimation(Transformer.Accordion);
        //播放时间
        bannerHome.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        bannerHome.setIndicatorGravity(BannerConfig.CENTER);
        bannerHome.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                goPassDetailPage(datasBanner.get(position).getTitle(),
                        datasBanner.get(position).getUrl());
            }
        });
    }

    @Override
    protected void initDatas() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    protected void presenterAttachView() {
        mPresenter.attach(this);
    }


    /**
     * 创建
     *
     * @return
     */
    public static HomeFrag getInstance() {
        HomeFrag homeFrag = new HomeFrag();
        return homeFrag;
    }


    @Override
    public void updateBanner(List<HomeBannerBean.DataBean> datas) {

        if (datas == null || datas.size() == 0) return;

        this.datasBanner.clear();
        this.datasBanner.addAll(datas);

        List<String> titles = new ArrayList<>();
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < datasBanner.size(); i++) {
            titles.add(datasBanner.get(i).getTitle());
            imgs.add(datasBanner.get(i).getImagePath());
        }

        bannerHome.setImages(imgs);
        bannerHome.setBannerTitles(titles);
        bannerHome.start();
        bannerHome.startAutoPlay();

    }

    @Override
    public void updateTopArticle(List<HomeTopBean.DataBean> datas) {
        if (datas == null || datas.size() == 0) return;

        this.datasTop.clear();

        this.datasTop.addAll(datas);
        homeTopAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateArticleList(List<HomeArticleListBean.DataBean.DatasBean> datas) {
        if (datas == null || datas.size() == 0) return;

        this.datasArticle.clear();
        this.datasArticle.addAll(datas);
        homeArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateCollectItem(int type, int pos, boolean b) {
        switch (type) {
            case 0:
                //轮播，不存在收藏按钮
                break;
            case 1:
                datasTop.get(pos).setCollect(b);
                homeTopAdapter.notifyItemChanged(pos);

                break;
            case 2:

                datasArticle.get(pos).setCollect(b);
                homeArticleAdapter.notifyItemChanged(pos);
                break;
        }
    }

    @Override
    public void clickCollectImg(int pos) {

        //判断是站内还是站外
        boolean b = checkWebOnOrOut(datasTop.get(pos).getLink());
        if (b) {
            mPresenter.requestCollectOn(datasTop.get(pos).getId() + "");
        } else {
            mPresenter.requestCollectOut(datasTop.get(pos).getTitle(), datasTop.get(pos).getAuthor(),
                    datasTop.get(pos).getLink());
        }
    }

    private boolean checkWebOnOrOut(String link) {
        return link.contains(ConstantClass.BASE_URL);
    }

    @Override
    public void onSuccess() {
        if (smartHome == null) return;
        smartHome.finishRefresh();
        smartHome.finishLoadMore();
        smartHome.setEnableLoadMore(true);

    }

    @Override
    public void onError() {
        if (smartHome == null) return;
        smartHome.finishRefresh();
        smartHome.finishLoadMore();
        smartHome.setEnableLoadMore(false);
    }

    @Override
    public void goPassDetailPage(String title, String url) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(url)) return;

        PassDetailActivity.createPassDetailActivity(mContext, title, url);
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
        bannerHome.stopAutoPlay();
    }


}
