package com.wanandroid.app.chwanandroid.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseActivity;
import com.wanandroid.app.chwanandroid.mine.LoginContract;
import com.wanandroid.app.chwanandroid.mine.eventMessage.MineEventMessage;
import com.wanandroid.app.chwanandroid.mine.presenter.LoginPresenter;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity<LoginContract.ILoginPresenter>
        implements LoginContract.IloginView {

    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.layout_title_login)
    RelativeLayout layoutTitleLogin;
    @Bind(R.id.layout_tel_login)
    RelativeLayout layoutTelLogin;
    @Bind(R.id.layout_pwd_login)
    RelativeLayout layoutPwdLogin;
    @Bind(R.id.btn_login)
    ImageButton btnLogin;
    @Bind(R.id.edit_tel_login)
    EditText editTelLogin;
    @Bind(R.id.edit_pwd_login)
    EditText editPwdLogin;
    @Bind(R.id.tv_regist_login)
    TextView tvRegistLogin;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        judgeBtnUse();
    }

    private void judgeBtnUse() {
        //初始设置brn不可以
        btnLogin.setEnabled(false);
        //账号输入框监听
        editTelLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setBtnUse();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //密码输入框监听
        editPwdLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setBtnUse();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    /**
     * 设置btn是否可用
     */
    private void setBtnUse() {
        String tel = editTelLogin.getText().toString().trim();
        String pwd = editPwdLogin.getText().toString().trim();

        //如果账号、密码有一个为空！
        if (judgeTelAndPwd(tel, pwd)) {
            btnLogin.setEnabled(true);
        } else {
            btnLogin.setEnabled(false);
        }
    }


    /**
     * 对账号密码做判断
     *
     * @param tel
     * @param pwd
     * @return
     */
    private boolean judgeTelAndPwd(String tel, String pwd) {
        if (TextUtils.isEmpty(tel) || TextUtils.isEmpty(pwd)) {
            return false;
        }

        if (tel.length() < 11) {
            return false;
        }

        if (pwd.length() < 6) {
            return false;
        }

        return true;
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void attachPresenterView() {
        mPresenter.attach(this);
    }

    @Override
    protected LoginContract.ILoginPresenter setProsenter() {
        return new LoginPresenter();
    }


    @Override
    public void showMessage(String s) {
        showToast(s);
    }


    @OnClick({R.id.btn_login,R.id.tv_regist_login})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                requestLogin();
                break;
            case R.id.tv_regist_login:
                goRegistActivity();
                break;
        }

    }


    @Override
    public void requestLogin() {
        String tel = editTelLogin.getText().toString().trim();
        String pwd = editPwdLogin.getText().toString().trim();
        if(TextUtils.isEmpty(tel) || TextUtils.isEmpty(pwd)){
            showMessage(getResources().getString(R.string.input_cannot_null));
            return;
        }
        if(tel.length()<11){
            showMessage(getResources().getString(R.string.tel_not_correct));
            return;
        }
        if(pwd.length()<6){
            showMessage(getResources().getString(R.string.pwd_must_more6));
            return;
        }
         mPresenter.startLogin(tel,pwd);
    }

    @Override
    public void onSuccrss() {
        //发送消息通知minefrag页面更新
        EventBus.getDefault().post(new MineEventMessage());
        showMessage(getResources().getString(R.string.login_success));
        this.finish();
    }

    @Override
    public void onFailure() {
        //登录失败？
    }

    @Override
    public void goRegistActivity() {
        //跳转注册页面
        RegistActivity.createRegistActivity(this);
    }

}
