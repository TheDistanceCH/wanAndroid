package com.wanandroid.app.chwanandroid.wx_public.moudle;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.http.HttpService;
import com.wanandroid.app.chwanandroid.wx_public.SubPublicContrract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/29
 * function:
 */
public class SubPublicMoudle implements SubPublicContrract.IsubPublicMoudle {
    private List<PublicListBean.DataBean.DatasBean> datas;

    @Override
    public void requestdatas(HttpProjectApi httpProjectApi, int weixin,
                             int page, OnHttpResultListener listener) {
        httpProjectApi.piblicEXList(weixin,page,listener);
    }

    @Override
    public List<PublicListBean.DataBean.DatasBean> parseSubPublicListDatas(
            PublicListBean.DataBean bean,int page) {
       if(datas==null){
           datas = new ArrayList<>();
       }

       if(bean.getDatas()==null|| bean.getDatas().size()==0){
           return  datas;
       }

       if(page==1){
           datas.clear();
       }
       datas.addAll(bean.getDatas());

       return datas;
    }
}
