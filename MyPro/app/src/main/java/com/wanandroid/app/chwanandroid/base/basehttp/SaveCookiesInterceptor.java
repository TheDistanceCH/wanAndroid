package com.wanandroid.app.chwanandroid.base.basehttp;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.Cookie;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * create time on  2019/8/4
 * function:
 */
public class SaveCookiesInterceptor implements Interceptor {
    private static final String COOKIE_PRE = "cookie_retrofit";
    private static final String COOKIE_KEY = "cookie_key";
    private Context context;
    private boolean save;


    /**
     * 切记传进来的必须是application
     *
     * @param context
     */
    public SaveCookiesInterceptor(Context context,boolean save) {
        this.context = context;
        this.save = save;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if(save== false){
            return response;
        }
        if (!response.headers("set-cookie").isEmpty()) {

            HashSet<String> hashSet = new HashSet<>();

            for (String cookie:response.headers("set-cookie")) {
                hashSet.add(cookie);
            }

            saveCookies(hashSet);
        }
        return response;
    }

    /**
     * 保存数据
     * @param cookiesToStr
     */
    private void saveCookies(HashSet<String> cookiesToStr) {
        SharedPreferences sp = context.getSharedPreferences(COOKIE_PRE,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet(COOKIE_KEY, cookiesToStr);
        editor.commit();
    }


}
