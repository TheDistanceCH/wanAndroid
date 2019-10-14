package com.wanandroid.app.chwanandroid.home.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.constant.ConstantClass;
import com.wanandroid.app.chwanandroid.home.HomeContract;
import com.wanandroid.app.chwanandroid.home.bean.HomeArticleListBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeBannerBean;
import com.wanandroid.app.chwanandroid.home.bean.HomeTopBean;
import com.wanandroid.app.chwanandroid.home.moudle.HomeMoudle;
import com.wanandroid.app.chwanandroid.home.view.HomeFrag;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.bean.CollectBean;
import com.wanandroid.app.chwanandroid.mine.moudle.CollectMoudle;


/**
 * create time on  2019/7/15
 * function:
 */
public class HomePresenter extends BasePresenter<HomeContract.IHomeView>
        implements HomeContract.IHomePresenter {


    private HttpProjectApi httpProjectApi;


    private HomeMoudle homeMoudle;

    //收藏的moudle
    private CollectMoudle collectMoudle;


    //从0开始
    private int page = 0;


    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        homeMoudle = new HomeMoudle();
        collectMoudle = new CollectMoudle();
        httpProjectApi = new HttpProjectApi(((HomeFrag) view).getRxAppActivity());

    }

    /**
     * 请求banner数据
     */
    @Override
    public void requestBanner() {
        homeMoudle.requestBanner(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                HomeBannerBean bannerBean = JSONObject.parseObject(bean, new TypeReference<HomeBannerBean>() {
                });
                if (bannerBean == null) {
                    getView().onError();
                    return;
                }
                if (0 != bannerBean.getErrorCode()) {
                    getView().showMessage(bannerBean.getErrorMsg());
                    return;
                }

                //刷新数据
                getView().updateBanner(homeMoudle.parseBannerBean(bannerBean));
                getView().onSuccess();

            }

            @Override
            public void onError(Throwable e) {

                //捕获空指针异常和代理类异常，这是快速切换voager导致的问题，但是不影响运行
                if (checkMissError(e)) return;

                getView().onError();
                getView().showMessage(e.toString());
            }
        });
    }

    /**
     * 请求置顶文章数据
     */
    @Override
    public void requestTopArticle() {
        homeMoudle.requestTopArticle(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                HomeTopBean homeTopBean = JSONObject.parseObject(bean, new TypeReference<HomeTopBean>() {
                });
                if (homeTopBean == null) {
                    getView().onError();
                    return;
                }

                if (0 != homeTopBean.getErrorCode()) {
                    getView().showMessage(homeTopBean.getErrorMsg());
                    getView().onError();
                    return;
                }

                //刷新数据
                getView().updateTopArticle(homeMoudle.parseTopBean(homeTopBean));
                getView().onSuccess();

            }


            @Override
            public void onError(Throwable e) {
                if (checkMissError(e)) return;
                getView().onError();
                getView().showMessage(e.toString());
            }
        });
    }

    /**
     * 请求文章列表
     */
    @Override
    public void requestArticleList() {
        homeMoudle.requestArticle(httpProjectApi, page, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                HomeArticleListBean articleListBean = JSONObject.parseObject(bean, new TypeReference<HomeArticleListBean>() {
                });
                if (articleListBean == null) {
                    getView().onError();
                    return;
                }
                if (0 != articleListBean.getErrorCode()) {
                    getView().showMessage(articleListBean.getErrorMsg());
                    getView().onError();
                    return;
                }

                getView().updateArticleList(homeMoudle.parseArticleListBean(articleListBean.getData(), page));
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                if (page != 0) {
                    page -= 1;
                }
                if (checkMissError(e)) return;
                getView().onError();
                getView().showMessage(e.toString());
            }
        });
    }

    @Override
    public void requestCollectOn(String id) {
        collectMoudle.requestCollectSiteOn(httpProjectApi, id, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                CollectBean collectBean = JSONObject.parseObject(bean, new TypeReference<CollectBean>() {
                });

                if (collectBean == null) {
                    getView().showMessage(getView().getContextView().getResources().getString(R.string.error_internet_null));
                    return;
                }

                if (0 != collectBean.getErrorCode()) {
                    getView().showMessage(collectBean.getErrorMsg());
                    return;
                }


                getView().showMessage(getView().getContextView().getResources().getString(R.string.collect_success));

            }

            @Override
            public void onError(Throwable e) {
                getView().showMessage(e.toString());
            }
        });
    }

    @Override
    public void requestCollectOut(String title, String author, String link) {
        collectMoudle.requestCollectSiteOut(httpProjectApi, title, author, link, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                CollectBean collectBean = JSONObject.parseObject(bean, new TypeReference<CollectBean>() {
                });

                if (collectBean == null) {
                    getView().showMessage(getView().getContextView().getResources().getString(R.string.error_internet_null));
                    return;
                }

                if (0 != collectBean.getErrorCode()) {
                    getView().showMessage(collectBean.getErrorMsg());
                    return;
                }


                getView().showMessage(getView().getContextView().getResources().getString(R.string.collect_success));
            }

            @Override
            public void onError(Throwable e) {
                getView().showMessage(e.toString());
            }
        });
    }


    @Override
    public void requestMore() {
        page += 1;
        requestArticleList();
    }

    @Override
    public void requestFresh() {
        page = 1;
        requestArticleList();
    }
}
