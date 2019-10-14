package com.wanandroid.app.chwanandroid.wx_public.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

import com.wanandroid.app.chwanandroid.wx_public.PublicSearchContract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicSearchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/30
 * function: 查找微信公众号消息moudle
 */
public class PublicSearchMoudle implements PublicSearchContract.IPublicMoudle {

    private List<PublicSearchBean.DataBean.DatasBean> datas;

    @Override
    public void requesrDatas(HttpProjectApi httpProjectApi, int page, int weixin, String search,
                             OnHttpResultListener listener) {
        httpProjectApi.publicSearchWXList(weixin, page, search, listener);
    }

    @Override
    public List<PublicSearchBean.DataBean.DatasBean> parsePublicSearch(PublicSearchBean bean,
                                                                       int page) {
        if (datas == null) {
            datas = new ArrayList<>();
        }

        if (bean.getData().getDatas() == null || bean.getData().getDatas().size() == 0) {
            return datas;
        }

        if (page == 1) {
            datas.clear();
        }

        datas.addAll(bean.getData().getDatas());
        return datas;

    }
}
