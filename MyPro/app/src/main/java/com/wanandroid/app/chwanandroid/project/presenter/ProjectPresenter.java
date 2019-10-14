package com.wanandroid.app.chwanandroid.project.presenter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.project.ProjectContract;
import com.wanandroid.app.chwanandroid.project.bean.ProjectTitleBean;
import com.wanandroid.app.chwanandroid.project.module.ProjectMoudle;
import com.wanandroid.app.chwanandroid.project.view.ProjectFrag;

/**
 * create time on  2019/7/23
 * function:
 */
public class ProjectPresenter extends BasePresenter<ProjectContract.IProjectView>
        implements ProjectContract.IProjectPresenter {

    private HttpProjectApi httpProjectApi;
    private ProjectMoudle moudle;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new ProjectMoudle();
        httpProjectApi = new HttpProjectApi(((ProjectFrag) view).getRxAppActivity());
    }

    @Override
    public void requestDatas() {
        moudle.requestDatas(httpProjectApi, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                ProjectTitleBean projectTitleBean = JSONObject.parseObject(bean,
                        new TypeReference<ProjectTitleBean>() {
                        });
                if (projectTitleBean == null) {
                    getView().onFailure();
                    getView().showMessage(getView().getContextView().getResources().
                            getString(R.string.error_internet_null));
                    return;
                }

                if(0!=projectTitleBean.getErrorCode()){
                    getView().showMessage(projectTitleBean.getErrorMsg());
                    getView().onFailure();
                    return;
                }

                getView().updateDatas(moudle.parsrDatas(projectTitleBean));
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                if(checkMissError(e)) return;
                getView().showMessage(e.toString());
                getView().onFailure();
            }
        });
    }
}
