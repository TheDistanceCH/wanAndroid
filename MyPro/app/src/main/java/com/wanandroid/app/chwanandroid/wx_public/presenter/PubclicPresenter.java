package com.wanandroid.app.chwanandroid.wx_public.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.wx_public.PublicContract;
import com.wanandroid.app.chwanandroid.wx_public.SubPublicContrract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;
import com.wanandroid.app.chwanandroid.wx_public.moudle.PublicMoudle;
import com.wanandroid.app.chwanandroid.wx_public.view.PublicFrag;


/**
 * create time on  2019/7/23
 * function:
 */
public class PubclicPresenter extends BasePresenter<PublicContract.IPubclicView>
        implements PublicContract.IPubclicPresenter {

    private PublicMoudle moudle;
    private HttpProjectApi httpProjectApi;
    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new PublicMoudle();
        httpProjectApi = new HttpProjectApi(((PublicFrag)view).getRxAppActivity());
    }

    @Override
    public void requestPublicTitles() {
        moudle.findPublicTitleList(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                PublicTitleListBean publicTitleListBean = JSONObject.parseObject(bean,
                        new TypeReference<PublicTitleListBean>(){});
                if(publicTitleListBean==null){
                    getView().onError();
                    return;
                }
                if(0!=publicTitleListBean.getErrorCode()){
                    getView().showMessage(publicTitleListBean.getErrorMsg());
                    getView().onError();
                    return;
                }
                //刷新数据
                ((PublicContract.IPubclicView)mReferenceView.get()).updateTitles( moudle.parsePublicTitles(publicTitleListBean));
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                if(checkMissError(e)) return;
                Log.d("chenhua",e.toString());
                getView().showMessage(e.toString());
                getView().onError();
            }
        });
    }
}
