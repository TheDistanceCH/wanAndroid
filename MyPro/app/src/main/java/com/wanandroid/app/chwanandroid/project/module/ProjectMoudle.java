package com.wanandroid.app.chwanandroid.project.module;

import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.project.ProjectContract;
import com.wanandroid.app.chwanandroid.project.bean.ProjectTitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create time on  2019/7/31
 * function: 项目标题列表
 */
public class ProjectMoudle implements ProjectContract.IProjectMoudle {

    private List<ProjectTitleBean.DataBean> datas;

    @Override
    public void requestDatas(HttpProjectApi httpProjectApi, OnHttpResultListener listener) {
        httpProjectApi.projectTitle(listener);
    }

    @Override
    public List<ProjectTitleBean.DataBean> parsrDatas(ProjectTitleBean bean) {
        if(datas==null){
            datas = new ArrayList<>();
        }
        if(bean.getData()==null || bean.getData().size()==0){
            return  datas;
        }
        datas.clear();
        datas.addAll(bean.getData());

        return datas;
    }
}
