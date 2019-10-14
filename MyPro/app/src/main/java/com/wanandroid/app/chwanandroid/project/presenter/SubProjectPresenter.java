package com.wanandroid.app.chwanandroid.project.presenter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basehttp.OnHttpResultListener;
import com.wanandroid.app.chwanandroid.base.basemvp.BasePresenter;
import com.wanandroid.app.chwanandroid.base.basemvp.IBaseView;
import com.wanandroid.app.chwanandroid.http.HttpProjectApi;
import com.wanandroid.app.chwanandroid.project.SubProjectContract;
import com.wanandroid.app.chwanandroid.project.bean.ProjectListBean;
import com.wanandroid.app.chwanandroid.project.module.SubProjectMoudle;
import com.wanandroid.app.chwanandroid.project.view.SubProjectFrag;

/**
 * create time on  2019/7/31
 * function:
 */
public class SubProjectPresenter extends BasePresenter<SubProjectContract.ISubProjectView>
        implements SubProjectContract.ISubProjectPresenter {

    private HttpProjectApi httpProjectApi;
    private SubProjectMoudle moudle;
    private int page = 1;
    private int cid;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        moudle = new SubProjectMoudle();
        httpProjectApi = new HttpProjectApi(((SubProjectFrag) view).getRxAppActivity());

    }

    public void requestDatas(int cid){
        this.cid = cid;
        moudle.requestDatas(httpProjectApi, cid, page, new OnHttpResultListener() {
            @Override
            public void onNext(String bean) {
                ProjectListBean projectListBean = JSONObject.parseObject(bean,
                        new TypeReference<ProjectListBean>() {
                        });
                if (projectListBean == null) {
                    getView().showMessage(getView().getContextView().getResources().
                            getString(R.string.error_internet_null));
                    getView().onFailure();
                    return;
                }

                if (0 != projectListBean.getErrorCode()) {
                    getView().showMessage(projectListBean.getErrorMsg());
                    getView().onFailure();
                    return;
                }

                getView().updateDatas(moudle.parseDatas(projectListBean.getData(),page));
                getView().onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                if(checkMissError(e)) return;
                getView().showMessage(e.toString());
                getView().onSuccess();
            }
        });
    }

    @Override
    public void fresh(int cid) {
        page = 1;
        requestDatas(cid);

    }

    @Override
    public void loadMore() {

        page+=1;
        requestDatas(cid);

    }
}
