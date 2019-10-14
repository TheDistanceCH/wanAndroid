package com.wanandroid.app.chwanandroid.main.presenter;

import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.main.MainContract;
import com.wanandroid.app.chwanandroid.main.moudle.MainMoudle;

/**
 * create time on  2019/7/14
 * function:
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView>
        implements MainContract.IMainPresenter {

    private MainContract.IMainMoudle moudle;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new MainMoudle();

    }
}
