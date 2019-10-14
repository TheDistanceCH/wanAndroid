package com.wanandroid.app.chwanandroid.base.basehttp;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import retrofit2.Retrofit;


/**
 * create time on  2019/7/16
 * function:
 */
public class HttpManagerApi extends BaseApi {
    private HttpManager httpManager;


    public HttpManagerApi(RxAppCompatActivity rxAppCompatActivity) {
        httpManager = new HttpManager(rxAppCompatActivity);
    }

    //获取retrofit
    public Retrofit getRetrofit(boolean addInterceptor,boolean saveInerceptor) {
        return httpManager.getRetrofit(getBaseUrl(), addInterceptor, saveInerceptor);
    }


    //处理请求回来的observable
    public void httpDeal(Observable<String> observable, OnHttpResultListener listener) {
        httpManager.doHttpDeal(observable, listener);
    }
}
