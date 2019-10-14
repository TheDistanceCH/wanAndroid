package com.wanandroid.app.chwanandroid.project;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseMoudle;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.project.bean.ProjectListBean;
import com.wanandroid.app.chwanandroid.project.bean.ProjectTitleBean;

import java.util.List;

/**
 * create time on  2019/7/31
 * function:
 */
public interface SubProjectContract {

    interface ISubProjectView extends IBaseView {
        void updateDatas(List<ProjectListBean.DataBean.DatasBean> lists);

        void onSuccess();

        void onFailure();

        void goDetailActivity(String title,String url);
    }

    interface ISubProjectPresenter extends IBasePresenter {
        void fresh(int cid);

        void loadMore();

    }

    interface ISubProjectModule extends IBaseMoudle {
        void requestDatas(HttpProjectApi httpProjectApi, int cid, int page,
                          OnHttpResultListener listener);

        List<ProjectListBean.DataBean.DatasBean> parseDatas(ProjectListBean.DataBean bean,
                                                            int page);
    }
}
