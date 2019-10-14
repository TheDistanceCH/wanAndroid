package com.wanandroid.app.chwanandroid.mine.presenter;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;

import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.mine.RegistContract;
import com.wanandroid.app.chwanandroid.mine.bean.UserBean;
import com.wanandroid.app.chwanandroid.mine.moudle.RegistMoudle;
import com.wanandroid.app.chwanandroid.mine.view.RegistActivity;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * created by chenhua
 * create time on  2019/10/11
 * function:
 */
public class RegistPresenter extends BasePresenter<RegistContract.IRegistView>
        implements RegistContract.IRegistPresenter {


    private RegistMoudle registMoudle;
    private HttpProjectApi httpProjectApi;

    //负责处理短信验证的逻辑
    private EventHandler eh;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        httpProjectApi = new HttpProjectApi((RegistActivity) view);
        registMoudle = new RegistMoudle();
    }


    @Override
    public void initEventHandler() {
        eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;

                new Handler(Looper.getMainLooper(), new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        int event = msg.arg1;
                        int result = msg.arg2;
                        Object data = msg.obj;
                        if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            //获取验证码
                            getVertificationCode(result, data);

                        } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                            //提交验证码结果
                            submitVertificationCode(result, data);

                        }
                        // TODO 其他接口的返回结果也类似，根据event判断当前数据属于哪个接口
                        return false;
                    }
                }).sendMessage(msg);

            }
        };

        SMSSDK.registerEventHandler(eh); //注册短信回调
    }


    //对提交的验证码结果判断
    private void submitVertificationCode(int result, Object data) {
        if (result == SMSSDK.RESULT_COMPLETE) {
            // TODO 处理验证码验证通过的结果
            startRegist(getView().getTel(), getView().getPwd(), getView().getRePwd());

        } else {
            // TODO 处理错误的结果
            getView().showMessage(data.toString());
            ((Throwable) data).printStackTrace();

        }
    }

    //对获取验证码结果进行判断
    private void getVertificationCode(int result, Object data) {
        if (result == SMSSDK.RESULT_COMPLETE) {
            // TODO 处理成功得到验证码的结果
            // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
            // 开始倒计时
            getView().startCountDown();

        } else {
            // TODO 处理错误的结果
            getView().showMessage(data.toString());
            ((Throwable) data).printStackTrace();

        }
    }

    @Override
    public void unregistEventHandler() {
        //在activity的ondestroy中调用
        SMSSDK.unregisterEventHandler(eh);
    }

    @Override
    public void startRegist(String tel, String pwd, String rePwd) {
        registMoudle.requestDatas(httpProjectApi, tel, pwd, rePwd, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                UserBean userBean = JSONObject.parseObject(bean, new TypeReference<UserBean>() {
                });
                if (userBean == null) {
                    getView().showMessage(getView().getContextView()
                            .getResources().getString(R.string.error_internet_null));
                    getView().onFailure();
                    return;
                }

                //数据解析异常！
                if (userBean.getErrorCode() != 0) {
                    getView().showMessage((userBean.getErrorMsg()));
                    return;
                }


                //数据保存成功
                getView().onSuccrss();
            }

            @Override
            public void onError(Throwable e) {
                getView().showMessage(e.toString());
                Log.d("chenhua", e.toString());
                getView().onFailure();
            }
        });
    }


}
