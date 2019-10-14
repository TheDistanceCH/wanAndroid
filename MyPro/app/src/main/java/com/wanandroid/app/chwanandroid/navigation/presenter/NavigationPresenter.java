package com.wanandroid.app.chwanandroid.navigation.presenter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.navigation.NavigationContract;
import com.wanandroid.app.chwanandroid.navigation.bean.NavigationBean;
import com.wanandroid.app.chwanandroid.navigation.moudle.NavigationMoudle;
import com.wanandroid.app.chwanandroid.navigation.view.NavigationFrag;

/**
 * create time on  2019/7/23
 * function:
 */
public class NavigationPresenter extends BasePresenter<NavigationContract.INavigationView>
        implements NavigationContract.INavigationPresenter {

    private HttpProjectApi httpProjectApi;
    private NavigationMoudle moudle;


    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new NavigationMoudle();
        httpProjectApi = new HttpProjectApi(((NavigationFrag) view).getRxAppActivity());
    }

    @Override
    public void requestDatas() {
        moudle.requestDatas(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                NavigationBean navigationBean = JSONObject.parseObject(bean,
                        new TypeReference<NavigationBean>() {
                        });

                if (navigationBean == null) {
                    getView().showMessage(getView().getContextView().getResources().
                            getString(R.string.error_internet_null));
                    getView().onFailure();
                    return;
                }

                if (0 != navigationBean.getErrorCode()) {
                    getView().showMessage(navigationBean.getErrorMsg());
                    getView().onFailure();
                    return;
                }

                //刷新数据
                getView().updateDatas(moudle.parseNavigations(navigationBean));
                getView().onSuccess();


            }

            @Override
            public void onError(Throwable e) {
                if(checkMissError(e)) return;
                getView().showMessage(e.toString());
                getView().onFailure();
            }
        });
    }
}
