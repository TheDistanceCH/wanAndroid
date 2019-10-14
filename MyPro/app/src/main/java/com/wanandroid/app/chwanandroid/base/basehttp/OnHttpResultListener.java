package com.wanandroid.app.chwanandroid.base.basehttp;

/**
 * create time on  2019/7/16
 * function:  对http返回的结果进行监听
 */
public interface OnHttpResultListener {

    void onNext(String bean);

    void onError(Throwable e);
}
