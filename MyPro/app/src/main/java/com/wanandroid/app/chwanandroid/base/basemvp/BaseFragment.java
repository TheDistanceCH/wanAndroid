package com.wanandroid.app.chwanandroid.base.basemvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * create time on  2019/7/14
 * function:
 */
public abstract class BaseFragment<P extends IBasePresenter> extends Fragment
        implements IBaseView {

    protected Context mContext;
    protected RxAppCompatActivity mActivity;
    protected View layoutView;

    protected P mPresenter;

    protected abstract P setPresenter();

    protected abstract void initViews(View view, LayoutInflater inflater, ViewGroup container,
                                      Bundle savedInstanceState);

    protected abstract void initDatas();

    protected abstract int getLayoutId();

    protected abstract void presenterAttachView();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = (RxAppCompatActivity)getActivity();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        layoutView = inflater.inflate(getLayoutId(), container, false);
        //绑定view
        ButterKnife.bind(this, layoutView);

        //设置presenter
        mPresenter = setPresenter();
        presenterAttachView();

        initDatas();
        initViews(layoutView, inflater, container, savedInstanceState);

        return layoutView;
    }

    @Override
    public Context getContextView() {
        return mContext;
    }

    public RxAppCompatActivity getRxAppActivity(){
        return mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mPresenter.detach();
        mPresenter = null;

    }


    public void showToast(String s){

        if(TextUtils.isEmpty(s)) return;

        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }


}
