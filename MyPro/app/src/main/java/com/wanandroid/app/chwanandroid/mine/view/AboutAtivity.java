package com.wanandroid.app.chwanandroid.mine.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseActivity;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.pass_detail.view.PassDetailActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutAtivity extends BaseActivity {

    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.tv_collect)
    TextView tvCollect;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_version_about)
    TextView tvVersionAbout;
    @Bind(R.id.tv_mine_csdn)
    TextView tvMineCsdn;

    private String MY_CSDN_URL = "https://blog.csdn.net/CHZKAL";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_ativity;


    }

    private String getVersionCode() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return "1.1.1";
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tvTitle.setText(getResources().getString(R.string.about_app));
        String version = getVersionCode();
        tvVersionAbout.setText(version);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void attachPresenterView() {

    }

    @Override
    protected IBasePresenter setProsenter() {
        return null;
    }


    @Override
    public void showMessage(String s) {
        showToast(s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_mine_csdn, R.id.tv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_csdn:
                PassDetailActivity.createPassDetailActivity(this, "我的学习博客", MY_CSDN_URL);
                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }


    public static void createAboutActivity(Context context) {
        Intent intent = new Intent(context, AboutAtivity.class);
        context.startActivity(intent);
    }


}
