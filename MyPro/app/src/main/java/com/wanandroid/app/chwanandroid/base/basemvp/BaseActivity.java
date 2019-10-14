package com.wanandroid.app.chwanandroid.base.basemvp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * create time on  2019/7/14
 * function:
 */
public abstract class BaseActivity<P extends IBasePresenter> extends
        RxAppCompatActivity implements IBaseView {


    /**
     * 泛型Presenter，根据在编写类的时候传入的泛型确定当前presenter的类型
     */
    protected P mPresenter;

    /**
     * @return 返回布局文件id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图，在initDatas之后执行
     * @param savedInstanceState
     */
    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    /**
     * 初始化必要数据，在initViews之前执行
     */
    protected abstract void initDatas();

    /**
     * 用来绑定presenter,子view在该方法调用mPresenter.attach(this);
     */
    protected abstract void attachPresenterView();

    /**
     * 通过该方法让子类实例化
     *
     * @return
     */
    protected abstract P setProsenter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.TRANSPARENT);

        }

        setContentView(getLayoutId());

        ButterKnife.bind(this);

        mPresenter = setProsenter();
        //绑定view
        attachPresenterView();

        //初始化必要数据,
        initDatas();

        //初始化view以及view的配置,saveInstanceState的缓存设置
        initViews(savedInstanceState);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detach();
            mPresenter = null;
        }

    }

    @Override
    public Context getContextView() {
        return this;
    }


    public void showToast(String s) {

        if (TextUtils.isEmpty(s)) return;

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
