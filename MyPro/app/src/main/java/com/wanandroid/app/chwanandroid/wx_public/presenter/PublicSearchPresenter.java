package com.wanandroid.app.chwanandroid.wx_public.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.wx_public.PublicSearchContract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicSearchBean;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;
import com.wanandroid.app.chwanandroid.wx_public.moudle.PublicMoudle;
import com.wanandroid.app.chwanandroid.wx_public.moudle.PublicSearchMoudle;
import com.wanandroid.app.chwanandroid.wx_public.view.PublicSearchActivity;

/**
 * create time on  2019/7/30
 * function:
 */
public class PublicSearchPresenter extends BasePresenter<PublicSearchContract.IPublicSearchView>
        implements PublicSearchContract.IPublicSearchPresenter {

    private HttpProjectApi httpProjectApi;
    private PublicSearchMoudle moudle;
    private PublicMoudle publicMoudle;
    private String search;
    private int page = 0;
    private int weixin;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new PublicSearchMoudle();
        publicMoudle = new PublicMoudle();
        httpProjectApi = new HttpProjectApi((PublicSearchActivity) view);

    }


    @Override
    public void requestPublicTitle() {
        publicMoudle.findPublicTitleList(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                PublicTitleListBean publicTitleListBean = JSONObject.parseObject(bean,
                        new TypeReference<PublicTitleListBean>(){});
                if(publicTitleListBean==null){
                    getView().onFailure();
                    return;
                }
                if(0!=publicTitleListBean.getErrorCode()){
                    getView().showMessage(publicTitleListBean.getErrorMsg());
                    getView().onFailure();
                    return;
                }
                //刷新数据
                getView().updateTitles( publicMoudle.parsePublicTitles(publicTitleListBean));
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                if(checkMissError(e)) return;
                Log.d("chenhua",e.toString());
                getView().showMessage(e.toString());
                getView().onFailure();
            }
        });

    }

    @Override
    public void requestDatas(int weixin, String s) {
        this.weixin = weixin;
        this.search = s;
        moudle.requesrDatas(httpProjectApi, page, weixin, s, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                PublicSearchBean publicSearchBean = JSONObject.parseObject(bean,
                        new TypeReference<PublicSearchBean>() {
                        });

                if (publicSearchBean == null) {
                    getView().onFailure();
                    getView().showMessage(getView().getContextView().
                            getString(R.string.error_internet_null));
                    return;
                }
                if (0 != publicSearchBean.getErrorCode()) {
                    getView().onFailure();
                    getView().showMessage(publicSearchBean.getErrorMsg());
                    return;
                }

                getView().onUpdateDatas(moudle.parsePublicSearch(publicSearchBean, page));
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                if (page != 0) {
                    page -= 1;
                }
                if(checkMissError(e)) return;
                getView().showMessage(e.toString());
                getView().onFailure();

            }
        });
    }

    @Override
    public void fresh(int weixin,String s) {
        page = 1;
        this.weixin = weixin;
        this.search = s;
        requestDatas(weixin, s);
    }

    @Override
    public void loadrMore() {
        page += 1;
        requestDatas(weixin, search);
    }
}
