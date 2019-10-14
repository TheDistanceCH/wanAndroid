package com.wanandroid.app.chwanandroid.base.basemvp;

/**
 * create time on  2019/7/14
 * function:
 */
public interface IBasePresenter {

    void attach(IBaseView view);

    void detach();

}
