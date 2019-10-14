package com.wanandroid.app.chwanandroid.wx_public.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.constant.ConstantClass;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;

import com.wanandroid.app.chwanandroid.wx_public.SubPublicContrract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicListBean;
import com.wanandroid.app.chwanandroid.wx_public.moudle.SubPublicMoudle;
import com.wanandroid.app.chwanandroid.wx_public.view.SubPublicFrag;

/**
 * create time on  2019/7/28
 * function:
 */
public class SubPublicPresenter extends BasePresenter<SubPublicContrract.ISubPublicView>
        implements SubPublicContrract.ISubPublicPresenter {

    private SubPublicMoudle moudle;
    private HttpProjectApi httpProjectApi;
    private int page = 0;
    private int weixin = 0;


    @Override
    public void setWeixin(int weixin) {
        this.weixin = weixin;
    }

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new SubPublicMoudle();
        httpProjectApi = new HttpProjectApi(((SubPublicFrag) view).getRxAppActivity());

    }

    @Override
    public void requesrDatras() {
        moudle.requestdatas(httpProjectApi, weixin, page, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                PublicListBean publicListBean = JSONObject.parseObject(bean, new TypeReference<PublicListBean>() {
                });
                if (publicListBean == null) {
                    getView().onFalire();
                    //数据解析为空
                    getView().showMessage(getView().getContextView().
                            getString(R.string.error_internet_null));
                    return;
                }

                if (0 != publicListBean.getErrorCode()) {
                    getView().onFalire();
                    getView().showMessage(publicListBean.getErrorMsg());
                    return;
                }

                //刷新数据
                getView().updateDatas(moudle.parseSubPublicListDatas(publicListBean.getData(), page));

                getView().onSuccess();

            }

            @Override
            public void onError(Throwable e) {
                if (page != 0) {
                    page-=1;
                }
                if(checkMissError(e)) return;
                Log.d(ConstantClass.TAG,e.toString());
                getView().showMessage(e.toString());
                getView().onFalire();
            }
        });
    }

    @Override
    public void fresh() {
        page = 1;
        requesrDatras();
    }

    @Override
    public void loadMore() {
        page += 1;
        requesrDatras();
    }
}
