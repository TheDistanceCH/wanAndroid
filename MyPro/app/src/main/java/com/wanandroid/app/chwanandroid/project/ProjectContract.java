package com.wanandroid.app.chwanandroid.project;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.project.bean.ProjectTitleBean;

import java.util.List;

/**
 * create time on  2019/7/23
 * function:
 */
public interface ProjectContract {

    interface IProjectView extends IBaseView{
        void requestDatas();
        void updateDatas(List<ProjectTitleBean.DataBean> datas);
        void onSuccess();
        void onFailure();
    }

    interface IProjectPresenter extends IBasePresenter{
        void requestDatas();
    }

    interface IProjectMoudle extends IBaseMoudle{
        void requestDatas(HttpProjectApi httpProjectApi, OnHttpResultListener listener);
        List<ProjectTitleBean.DataBean> parsrDatas(ProjectTitleBean bean);


    }
}
