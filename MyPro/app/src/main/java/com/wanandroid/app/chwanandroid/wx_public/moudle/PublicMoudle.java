package com.wanandroid.app.chwanandroid.wx_public.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.wx_public.PublicContract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/28
 * function:
 */
public class PublicMoudle implements PublicContract.IPubclicMoudle {

    private List<PublicTitleListBean.DataBean> titles;

    /**
     * 请求获取公众号标题栏列表
     * @param httpProjectApi
     * @param listener
     */
    public void findPublicTitleList(HttpProjectApi httpProjectApi,
                                    OnHttpResultListener listener){
        httpProjectApi.publicWXTitle(listener);
    }

    /**
     * 解析返回公众号列表
     * @param bean
     * @return
     */
    public List<PublicTitleListBean.DataBean> parsePublicTitles(PublicTitleListBean bean){
        if(titles==null){
            titles = new ArrayList<>();
        }

        if(bean.getData().size()==0){
            return titles;
        }

        titles.clear();
        titles.addAll(bean.getData());

        return titles;
    }

}
