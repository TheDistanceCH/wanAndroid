package com.wanandroid.app.chwanandroid.mine.presenter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.MineContract;
import com.wanandroid.app.chwanandroid.mine.bean.LoginOutBean;
import com.wanandroid.app.chwanandroid.mine.moudle.MineMoudle;
import com.wanandroid.app.chwanandroid.mine.view.MineFrag;

/**
 * create time on  2019/7/23
 * function:
 */
public class MinePrsenter extends BasePresenter<MineContract.IMineView>
        implements MineContract.IMinePresenter {

    private HttpProjectApi httpProjectApi;
    private MineMoudle mineMoudle;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        httpProjectApi = new HttpProjectApi(((MineFrag) view).getRxAppActivity());
        mineMoudle = new MineMoudle();
    }


    @Override
    public void loginOut() {
        mineMoudle.loginOut(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                LoginOutBean loginOutBean = JSONObject.parseObject(bean, new TypeReference<LoginOutBean>() {
                });
                if (loginOutBean == null) {
                    getView().showMessage(getView().getContextView().getResources()
                            .getString(R.string.error_internet_null));
                    getView().onError();
                    return;
                }
                if (0 != loginOutBean.getErrorCode()) {
                    getView().showMessage(loginOutBean.getErrorMsg());
                    return;
                }
                //成功退出
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                getView().showMessage(e.toString());
                getView().onError();
            }
        });
    }
}
