package com.wanandroid.app.chwanandroid.navigation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gavin.com.library.StickyDecoration;
import com.gavin.com.library.listener.GroupListener;
import com.gavin.com.library.listener.PowerGroupListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.navigation.NavigationContract;
import com.wanandroid.app.chwanandroid.navigation.adapter.NavigationAdapter;
import com.wanandroid.app.chwanandroid.navigation.bean.NavigationBean;
import com.wanandroid.app.chwanandroid.navigation.listener.OnNavigationListener;
import com.wanandroid.app.chwanandroid.navigation.presenter.NavigationPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * create time on  2019/7/23
 * function:导航页面
 */
public class NavigationFrag extends BaseFragment<NavigationContract.INavigationPresenter>
        implements NavigationContract.INavigationView {

    @Bind(R.id.layout_title_navigation)
    RelativeLayout layoutTitleNavigation;
    @Bind(R.id.recy_navigation)
    RecyclerView recyNavigation;
    @Bind(R.id.smart_navigation)
    SmartRefreshLayout smartNavigation;

    private NavigationAdapter adapter;

    private List<NavigationBean.DataBean.ArticlesBean> datas = new ArrayList<>();


    @Override
    protected NavigationContract.INavigationPresenter setPresenter() {
        return new NavigationPresenter();
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new NavigationAdapter(datas, mContext, new OnNavigationListener() {
            @Override
            public void onItemClick(int pos) {

            }
        });

        recyNavigation.setAdapter(adapter);
        recyNavigation.setLayoutManager(new LinearLayoutManager(mContext));


        GroupListener groupListener = new GroupListener() {
            @Override
            public String getGroupName(int position) {
                return datas.get(position).getChapterName();
            }
        };

        StickyDecoration stickyDecoration = StickyDecoration.Builder
                .init(groupListener)
                .setGroupBackground(getResources().getColor(R.color.colorWhite))
                .setGroupTextColor(getResources().getColor(R.color.colorBlack))
                .build();
        recyNavigation.addItemDecoration(stickyDecoration);

        smartNavigation.setEnableLoadMore(false);
        smartNavigation.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                requestDatas();
            }
        });


        requestDatas();
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_navigation;
    }

    @Override
    protected void presenterAttachView() {
        mPresenter.attach(this);
    }


    /**
     * 创建
     *
     * @return
     */
    public static NavigationFrag getInstance() {
        NavigationFrag navigationFrag = new NavigationFrag();
        return navigationFrag;
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }

    @Override
    public void requestDatas() {
        mPresenter.requestDatas();
    }

    @Override
    public void onSuccess() {
        if (smartNavigation == null) return;
        smartNavigation.finishRefresh();

    }

    @Override
    public void onFailure() {
        if (smartNavigation == null) return;
        smartNavigation.finishRefresh();

    }

    @Override
    public void updateDatas(List<NavigationBean.DataBean.ArticlesBean> datas) {
        if (datas == null || datas.size() == 0) return;

        this.datas.clear();
        this.datas.addAll(datas);

        adapter.notifyDataSetChanged();
    }

}
