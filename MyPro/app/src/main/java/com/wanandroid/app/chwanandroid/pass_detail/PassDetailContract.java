package com.wanandroid.app.chwanandroid.pass_detail;

import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;

/**
 * create time on  2019/10/9
 * function: passdetail activity's contract
 */
public interface PassDetailContract {


    interface IPassDetailView extends IBaseView{
        void showProgress(boolean b);
        void loadWeb(String webUrl);
        void onLoadError();
    }

    interface IPassDetailPresenter extends IBasePresenter{

    }

    interface IPassDetailMoudle extends IBaseMoudle{

    }
}
