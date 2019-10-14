package com.wanandroid.app.chwanandroid.http;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.wanandroid.app.chwanandroid.base.basehttp.HttpManagerApi;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.constant.ConstantClass;

import okhttp3.OkHttpClient;

/**
 * create time on  2019/7/16
 * function: 网络请请求的具体模块
 * <p>
 * 备注：规范调整，本类中所有请求方法以模块名开头
 */
public class HttpProjectApi extends HttpManagerApi {

    public HttpProjectApi(RxAppCompatActivity rxAppCompatActivity) {
        super(rxAppCompatActivity);
        setBaseUrl(ConstantClass.BASE_URL);
        setCache(false);
    }


    /**
     * 首页banner数据
     *
     * @param listener
     */
    public void homeBanner(OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findHomeBanner(), listener);
    }


    /**
     * 首页置顶文章
     *
     * @param listener
     */
    public void homeTopArticle(OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findTopArticle(), listener);
    }

    /**
     * 首页文章列表
     *
     * @param page
     * @param listener
     */
    public void homeArticleList(int page, OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findArticle(page), listener);
    }


    /**
     * 查询微信列表
     *
     * @param listener
     */
    public void publicWXTitle(OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findWXTitleList(), listener);
    }

    /**
     * 查询某个公众号的文章列表
     *
     * @param weixin
     * @param page
     * @param listener
     */
    public void piblicEXList(int weixin, int page, OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findWXList(weixin, page), listener);
    }

    /**
     * 查询某个公众号的历史文章
     */

    public void publicSearchWXList(int weixin, int page, String s,
                                   OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findWXSearchList(weixin, page, s), listener);

    }


    /**
     * 导航模块
     *
     * @param listener
     */
    public void navigationList(OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findNavigation(), listener);
    }


    /**
     * 项目标题列表
     *
     * @param listener
     */
    public void projectTitle(OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(false, false).create(HttpService.class);
        httpDeal(httpService.findProjectTitle(), listener);
    }

    /**
     * 项目分类列表
     *
     * @param page
     * @param cid
     * @param listener
     */
    public void projectList(int page, int cid, OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findProjectList(page, cid), listener);
    }


    /**
     * 登陸
     *
     * @param userName
     * @param password
     * @param listener
     */
    public void mineLogin(String userName, String password, OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(false, true).create(HttpService.class);
        httpDeal(httpService.findLogin(userName, password), listener);
    }


    /**
     * 注冊
     *
     * @param userName
     * @param password
     * @param repassword
     * @param listener
     */
    public void mineRegist(String userName, String password, String repassword,
                           OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(false, false).create(HttpService.class);
        httpDeal(httpService.findRegist(userName, password, repassword), listener);
    }

    /**
     * 退出
     *
     * @param listener
     */
    public void mineExit(OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, true).create(HttpService.class);
        httpDeal(httpService.findExit(), listener);
    }


    /**
     * 收藏站内文章
     */

    public void allCollectSiteOn(String id, OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findCollectSiteOn(id), listener);
    }


    /**
     * 收藏站外文章
     */
    public void allCollectSiteOut(String title, String author, String link, OnHttpResultListener listener) {
        HttpService httpService = getRetrofit(true, false).create(HttpService.class);
        httpDeal(httpService.findCollectSiteOut(title, author, link), listener);

    }

}
