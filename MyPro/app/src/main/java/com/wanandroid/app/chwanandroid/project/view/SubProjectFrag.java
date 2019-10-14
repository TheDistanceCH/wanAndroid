package com.wanandroid.app.chwanandroid.project.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.pass_detail.view.PassDetailActivity;
import com.wanandroid.app.chwanandroid.project.SubProjectContract;
import com.wanandroid.app.chwanandroid.project.adapter.SubProjectAdapter;
import com.wanandroid.app.chwanandroid.project.bean.ProjectListBean;
import com.wanandroid.app.chwanandroid.project.listener.OnProjectListener;
import com.wanandroid.app.chwanandroid.project.presenter.SubProjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * create time on  2019/7/31
 * function: 子项目frag
 */
public class SubProjectFrag extends BaseFragment<SubProjectContract.ISubProjectPresenter>
        implements SubProjectContract.ISubProjectView {


    @Bind(R.id.recy_subproject)
    RecyclerView recySubproject;
    @Bind(R.id.smart_subproject)
    SmartRefreshLayout smartSubproject;
    private List<ProjectListBean.DataBean.DatasBean> datas = new ArrayList<>();
    private SubProjectAdapter adapter;

    private int cid = -1;

    @Override
    protected SubProjectContract.ISubProjectPresenter setPresenter() {
        return new SubProjectPresenter();
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getIntentValue();

        adapter = new SubProjectAdapter(mContext, datas, new OnProjectListener() {
            @Override
            public void onItemClick(int pos) {
                goDetailActivity(datas.get(pos).getTitle(), datas.get(pos).getLink());
            }
        });
        recySubproject.setAdapter(adapter);
        recySubproject.setLayoutManager(new LinearLayoutManager(mContext));

        smartSubproject.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.fresh(cid);
            }
        });


        mPresenter.fresh(cid);
    }

    private void getIntentValue() {
        if (cid == -1 && getArguments() != null) {
            cid = getArguments().getInt("cid");
        }
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_subproject;
    }

    @Override
    protected void presenterAttachView() {
        mPresenter.attach(this);
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }

    /**
     * 创建
     *
     * @param cid
     * @return
     */
    public static SubProjectFrag getInstance(int cid) {
        SubProjectFrag subProjectFrag = new SubProjectFrag();
        Bundle bundle = new Bundle();
        bundle.putInt("cid", cid);
        subProjectFrag.setArguments(bundle);

        return subProjectFrag;
    }


    @Override
    public void updateDatas(List<ProjectListBean.DataBean.DatasBean> lists) {
        if (lists == null || lists.size() == 0) return;

        datas.clear();
        datas.addAll(lists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess() {
        if (smartSubproject == null) return;

        smartSubproject.finishLoadMore();
        smartSubproject.finishRefresh();
    }

    @Override
    public void onFailure() {
        if (smartSubproject == null) return;

        smartSubproject.finishLoadMore();
        smartSubproject.finishRefresh();
    }

    @Override
    public void goDetailActivity(String title, String url) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(url)) return;

        PassDetailActivity.createPassDetailActivity(mContext, title, url);
    }
}
