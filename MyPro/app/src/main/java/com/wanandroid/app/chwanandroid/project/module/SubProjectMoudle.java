package com.wanandroid.app.chwanandroid.project.module;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.project.SubProjectContract;
import com.wanandroid.app.chwanandroid.project.bean.ProjectListBean;
import com.wanandroid.app.chwanandroid.project.bean.ProjectTitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/31
 * function:
 */
public class SubProjectMoudle implements SubProjectContract.ISubProjectModule {
    private List<ProjectListBean.DataBean.DatasBean> datas;

    @Override
    public void requestDatas(HttpProjectApi httpProjectApi, int cid, int page,
                             OnHttpResultListener listener) {

        httpProjectApi.projectList(page, cid, listener);
    }

    @Override
    public List<ProjectListBean.DataBean.DatasBean> parseDatas(ProjectListBean.DataBean bean,
                                                               int page) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        if (bean.getDatas() == null || bean.getDatas().size() == 0) {
            return datas;
        }
        if (page == 1) {
            datas.clear();
        }

        datas.addAll(bean.getDatas());
        return datas;
    }
}
