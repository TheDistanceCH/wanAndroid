package com.wanandroid.app.chwanandroid.wx_public.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.pass_detail.view.PassDetailActivity;
import com.wanandroid.app.chwanandroid.wx_public.SubPublicContrract;
import com.wanandroid.app.chwanandroid.wx_public.adapter.SubPublicAdapter;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicListBean;
import com.wanandroid.app.chwanandroid.wx_public.listener.OnSubPublicListener;
import com.wanandroid.app.chwanandroid.wx_public.presenter.SubPublicPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * create time on  2019/7/28
 * function: 子publikc frag
 */
public class SubPublicFrag extends BaseFragment<SubPublicContrract.ISubPublicPresenter>
        implements SubPublicContrract.ISubPublicView {
    @Bind(R.id.recy_subpublic)
    RecyclerView recySubpublic;
    @Bind(R.id.mart_subpublic)
    SmartRefreshLayout smartSubpublic;

    private SubPublicAdapter adapter;
    private List<PublicListBean.DataBean.DatasBean> datas = new ArrayList<>();


    @Override
    protected SubPublicContrract.ISubPublicPresenter setPresenter() {
        return new SubPublicPresenter();
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            mPresenter.setWeixin(getArguments().getInt("weixin"));

        }

        adapter = new SubPublicAdapter(mContext, datas, new OnSubPublicListener() {
            @Override
            public void onItemClick(int pos) {
                goDetailActivity(datas.get(pos).getTitle(),datas.get(pos).getLink());
            }
        });

        recySubpublic.setAdapter(adapter);
        recySubpublic.setLayoutManager(new LinearLayoutManager(mContext));


        smartSubpublic.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.fresh();
            }
        });


        mPresenter.requesrDatras();
    }


    @Override
    protected void initDatas() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fag_subpublic;
    }

    @Override
    protected void presenterAttachView() {
        mPresenter.attach(this);
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }

    //创建子frag
    public static SubPublicFrag getInstance(int weixin) {
        SubPublicFrag subPublicFrag = new SubPublicFrag();
        Bundle bundle = new Bundle();
        bundle.putInt("weixin", weixin);
        subPublicFrag.setArguments(bundle);
        return subPublicFrag;
    }

    @Override
    public void requestDatas() {
        mPresenter.requesrDatras();
    }

    @Override
    public void onSuccess() {
        if (smartSubpublic == null) return;

        smartSubpublic.finishLoadMore();
        smartSubpublic.finishRefresh();

    }

    @Override
    public void onFalire() {
        if (smartSubpublic == null) return;
        smartSubpublic.finishLoadMore();
        smartSubpublic.finishRefresh();

    }

    @Override
    public void updateDatas(List<PublicListBean.DataBean.DatasBean> datas) {
        if (datas == null || datas.size() == 0) return;

        this.datas.clear();
        this.datas.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void goDetailActivity(String title, String url) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(url)) return;

        PassDetailActivity.createPassDetailActivity(mContext, title, url);

    }
}
