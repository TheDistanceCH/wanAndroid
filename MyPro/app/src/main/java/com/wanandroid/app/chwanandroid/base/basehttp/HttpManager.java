package com.wanandroid.app.chwanandroid.base.basehttp;


import android.annotation.SuppressLint;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.ref.SoftReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * create time on  2019/7/16
 * function: 真正在处理网络请求事物的类
 */
public class HttpManager {

    private SoftReference<RxAppCompatActivity> appCompatActivitySoftReference;
    private OkHttpClientSingleton okHttpClientSingleton;

    public HttpManager(RxAppCompatActivity appCompatActivity) {
        appCompatActivitySoftReference = new SoftReference<>(appCompatActivity);
        okHttpClientSingleton = new OkHttpClientSingleton(
                appCompatActivitySoftReference.get());
    }

    /**
     * 创建retrofit
     *
     * @param baseUrl
     * @return
     */
    public Retrofit getRetrofit(String baseUrl,boolean addInterceptor,boolean saveInerceptor) {

        //创建一个retrofit对象

        OkHttpClient okHttpClient = okHttpClientSingleton.getOkHttpClient(addInterceptor, saveInerceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

        return retrofit;

    }

    /**
     * 处理网络请求结果
     * 初版，后期预计加入缓存和重连
     *
     * @param observable
     */
    @SuppressLint("CheckResult")
    public void doHttpDeal(Observable<String> observable, final OnHttpResultListener listener) {

        observable
                .compose(appCompatActivitySoftReference.get().
                        <String>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        listener.onNext(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listener.onError(throwable);
                    }
                });
    }


}
