package com.wanandroid.app.chwanandroid.base.basehttp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.IOException;
import java.security.Provider;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * create time on  2019/8/4
 * function:
 */
public class AddCookieInterceptor implements Interceptor {
    private static final String COOKIE_PRE = "cookie_retrofit";
    private static final String COOKIE_KEY = "cookie_key";
    private Context context;
    private boolean add;

    public AddCookieInterceptor(Context context,boolean add) {
        this.context = context;
        this.add = add;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(add==false){
            return chain.proceed(request);
        }
        Request.Builder builder = request.newBuilder();

        SharedPreferences sharedPreferences = context.getSharedPreferences(COOKIE_PRE,
                Context.MODE_PRIVATE);
        HashSet<String> cookies = (HashSet<String>) sharedPreferences.getStringSet(COOKIE_KEY, null);

        //如果没有缓存，直接返回
        if (cookies==null || cookies.size()==0) {
            return chain.proceed(chain.request());
        }

        for (String cookie :
                cookies) {
            builder.addHeader("Cookie",cookie);
        }

        return chain.proceed(builder.build());

    }
}
