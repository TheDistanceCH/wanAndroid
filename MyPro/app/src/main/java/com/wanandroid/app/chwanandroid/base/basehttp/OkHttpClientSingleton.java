package com.wanandroid.app.chwanandroid.base.basehttp;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * create time on  2019/7/16
 * function: 单例获取okhttpclient
 */
public class OkHttpClientSingleton {

    //超时时间-默认60秒，连接和响应
    private static final int connectionTime = 60;


    //日志拦截器开关
    private static boolean openInterceptor = false;


    private Context context;

    public OkHttpClientSingleton(Context context) {
        this.context = context.getApplicationContext();
    }

    public OkHttpClient getOkHttpClient(boolean addInterceptor, boolean saveInerceptor) {
        return getSingleOkHttpClient(addInterceptor, saveInerceptor);

//        if (okHttpClient == null) {
//            synchronized (OkHttpClientSingleton.class) {
//                if (okHttpClient == null) {
//                    okHttpClient = getSingleOkHttpClient(addInterceptor, saveInerceptor);
//                }
//            }
//        }
//        return okHttpClient;


    }


    /**
     * 返回一个日志拦截器
     *
     * @return
     */
    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (openInterceptor) {
                    Log.d("httpLoggingInterceptor", "Retrofit====Message:" + message);
                }
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    /**
     * 获取单例okhttpclient
     *
     * @return
     */
    private OkHttpClient getSingleOkHttpClient(boolean addInterceptor, boolean saveInerceptor) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(connectionTime, TimeUnit.SECONDS)  //设置链接超时时间
                .readTimeout(connectionTime, TimeUnit.SECONDS)     //设置读超时时间
                .writeTimeout(connectionTime, TimeUnit.SECONDS)     //设置写超时时间
                 .addInterceptor(getLoggingInterceptor())   //添加log拦截器
                .addInterceptor(new SaveCookiesInterceptor(context, saveInerceptor))
                .addInterceptor(new AddCookieInterceptor(context, addInterceptor))
                .build();

        return okHttpClient;
    }

}
