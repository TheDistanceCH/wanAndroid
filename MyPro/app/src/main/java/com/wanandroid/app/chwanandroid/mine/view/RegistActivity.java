package com.wanandroid.app.chwanandroid.mine.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseActivity;
import com.wanandroid.app.chwanandroid.mine.RegistContract;
import com.wanandroid.app.chwanandroid.mine.presenter.RegistPresenter;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;

import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * 注册页面
 */
public class RegistActivity extends BaseActivity<RegistContract.IRegistPresenter>
        implements RegistContract.IRegistView {

    @Bind(R.id.tv_regist)
    TextView tvRegist;
    @Bind(R.id.edit_tel_regist)
    EditText editTelRegist;
    @Bind(R.id.edit_pwd_regist)
    EditText editPwdRegist;
    @Bind(R.id.edit_repwd_regist)
    EditText editRepwdRegist;
    @Bind(R.id.edit_vertification_regist)
    EditText editVertificationRegist;
    @Bind(R.id.tv_send_vertification)
    TextView tvSendVertification;
    @Bind(R.id.btn_regist)
    ImageButton btnRegist;


    //倒计时初始时间
    private int maxCount = 60;

    private Disposable disposable;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        editaddListener(editTelRegist);
        editaddListener(editPwdRegist);
        editaddListener(editRepwdRegist);
        editaddListener(editVertificationRegist);

        //设置监听回调
        mPresenter.initEventHandler();

    }


    /**
     * 对editText添加监听
     */
    private void editaddListener(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                canBtnUse();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    /**
     * 判断btn是否可用
     */
    private void canBtnUse() {
        String tel = editTelRegist.getText().toString().trim();
        String pwd = editPwdRegist.getText().toString().trim();
        String rePwd = editRepwdRegist.getText().toString().trim();
        String vertificationCode = editVertificationRegist.getText().toString().trim();

        if (TextUtils.isEmpty(vertificationCode) || TextUtils.isEmpty(tel) ||
                TextUtils.isEmpty(pwd) || TextUtils.isEmpty(rePwd)) {

            //在输入框没有输入完整的情况下，设置btn不可用
            if (btnRegist.isEnabled()) {
                btnRegist.setEnabled(false);
                return;
            } else {
                return;
            }

        }

        //否则设置btn可用
        btnRegist.setEnabled(true);

    }


    @Override
    protected void initDatas() {
    }

    @Override
    protected void attachPresenterView() {
        mPresenter.attach(this);
    }

    @Override
    protected RegistContract.IRegistPresenter setProsenter() {
        return new RegistPresenter();
    }


    @Override
    public void requestRegist() {

        String tel = editTelRegist.getText().toString().trim();
        String pwd = editPwdRegist.getText().toString().trim();
        String rePwd = editRepwdRegist.getText().toString().trim();
        String vertification = editVertificationRegist.getText().toString().trim();
        //点击请求前，先判断是否有空格兰
        checkNull(tel, pwd, rePwd, vertification);
    }


    private void checkNull(String tel, String pwd, String rePwd, String ver) {
        if (TextUtils.isEmpty(tel) || TextUtils.isEmpty(pwd) ||
                TextUtils.isEmpty(rePwd) || TextUtils.isEmpty(ver)) {
            showMessage(getResources().getString(R.string.input_cannot_null));
            return;
        }

        if (pwd.length() < 6) {
            showMessage(getResources().getString(R.string.pwd_must_more6));
            return;
        }

        if (!pwd.equals(rePwd)) {
            showMessage(getResources().getString(R.string.pwd_not_equal_repwd));
            return;
        }

        //发送验证码
        SMSSDK.submitVerificationCode("86", tel, ver);

    }

    @Override
    public void onSuccrss() {
        showToast(getResources().getString(R.string.regist_success));
        finish();
    }

    @Override
    public void onFailure() {

    }

    /**
     * 发送验证码
     */
    @Override
    public void sendToVertification() {
        String tel = editTelRegist.getText().toString().trim();
        if (TextUtils.isEmpty(tel)) {
            showMessage(getResources().getString(R.string.tel_cannot_null));
            return;
        }
        // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
        // SMSSDK.getVerificationCode("86", tel);
        SMSSDK.getVerificationCode("86", tel, null, new OnSendMessageHandler() {
            @Override
            public boolean onSendMessage(String s, String s1) {
                if (s1.equals("13055457667")) return true;

                return false;
            }
        });

    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }


    @OnClick({R.id.tv_send_vertification, R.id.btn_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_send_vertification:
                //发送验证码
                sendVertification();
                break;

            case R.id.btn_regist:
                //点击注册
                requestRegist();
                break;
        }
    }


    //发送验证码,先验证手机格式
    private void sendVertification() {
        //判断电话号码格式是否正确,为了避免比分奇葩手机号匹配不到，这里就不用正则表达式去弄，
        //只判断电话号码长度即可.
        String tel = editTelRegist.getText().toString().trim();
        if (tel.length() != 11) {
            showToast(getResources().getString(R.string.tel_not_correct));
            return;
        }

        //发送验证码
        sendToVertification();

    }

    @Override
    public void startCountDown() {
        //重置时间
        maxCount = 60;

        disposable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (aLong == maxCount) {
                            tvSendVertification.setText(getResources().getString(R.string.repeat_send));
                            disposable.isDisposed();
                            tvSendVertification.setClickable(true);
                            return;
                        }
                        maxCount -= 1;
                        tvSendVertification.setText(maxCount + "");
                        tvSendVertification.setClickable(false);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        disposable.dispose();
                    }
                });
    }

    @Override
    public String getTel() {
        return editTelRegist.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return editPwdRegist.getText().toString().trim();
    }

    @Override
    public String getRePwd() {
        return editRepwdRegist.getText().toString().trim();
    }


    @Override
    protected void onDestroy() {
        // 使用完EventHandler需注销，否则可能出现内存泄漏
        mPresenter.unregistEventHandler();
        super.onDestroy();

        if (disposable!=null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }

    }

    public static void createRegistActivity(Context context) {
        context.startActivity(new Intent(context, RegistActivity.class));
    }
}
