package com.wanandroid.app.chwanandroid.mine.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

public class CollectMoudle {

    /**
     * 请求站内收藏
     *
     * @param httpProjectApi
     * @param id
     * @param listener
     */
    public void requestCollectSiteOn(HttpProjectApi httpProjectApi, String id,
                                     OnHttpResultListener listener) {
        httpProjectApi.allCollectSiteOn(id, listener);

    }


    /**
     * 请求站外收藏
     * @param httpProjectApi
     * @param title
     * @param author
     * @param link
     * @param listener
     */
    public void requestCollectSiteOut(HttpProjectApi httpProjectApi, String title, String author,
                                      String link, OnHttpResultListener listener) {
        httpProjectApi.allCollectSiteOut(title, author, link, listener);
    }
}
