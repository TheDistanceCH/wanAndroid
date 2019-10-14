package com.wanandroid.app.chwanandroid.mine.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.LoginContract;
import com.wanandroid.app.chwanandroid.mine.bean.UserBean;
import com.wanandroid.app.chwanandroid.mine.moudle.LoginMoudle;
import com.wanandroid.app.chwanandroid.mine.view.LoginActivity;
import com.wanandroid.app.chwanandroid.utils.UserSp;

/**
 * create time on  2019/8/12
 * function: 登录presenter
 */
public class LoginPresenter extends BasePresenter<LoginContract.IloginView>
        implements LoginContract.ILoginPresenter {

    private LoginMoudle loginMoudle;
    private HttpProjectApi httpProjectApi;



    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        loginMoudle = new LoginMoudle();

        httpProjectApi = new HttpProjectApi((LoginActivity) view);
    }

    @Override
    public void startLogin(String tel, String pwd) {
        loginMoudle.requestDatas(httpProjectApi, tel, pwd, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                UserBean userBean = JSONObject.parseObject(bean, new TypeReference<UserBean>() {
                });
                if (userBean == null) {
                    getView().onFailure();
                    return;
                }

                if (0 != userBean.getErrorCode()) {
                    getView().showMessage(userBean.getErrorMsg());
                    return;
                }

                //缓存到本地
                UserSp.saveUser(getView().getContextView(),userBean);

                //登录成功
                getView().onSuccrss();
            }

            @Override
            public void onError(Throwable e) {
//                if(checkMissError(e)) return;
                Log.d("chenhua", e.toString());
                getView().showMessage(e.toString());
                getView().onFailure();
            }
        });


    }
}
