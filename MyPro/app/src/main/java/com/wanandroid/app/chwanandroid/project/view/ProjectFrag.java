package com.wanandroid.app.chwanandroid.project.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.project.ProjectContract;
import com.wanandroid.app.chwanandroid.project.adapter.SubProjectAdapter;
import com.wanandroid.app.chwanandroid.project.bean.ProjectTitleBean;
import com.wanandroid.app.chwanandroid.project.presenter.ProjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * create time on  2019/7/23
 * function:项目页面
 */
public class ProjectFrag extends BaseFragment<ProjectContract.IProjectPresenter>
        implements ProjectContract.IProjectView {


    @Bind(R.id.tablayout_project)
    TabLayout tablayoutProject;
    @Bind(R.id.vpager_project)
    ViewPager vpagerProject;

    private List<ProjectTitleBean.DataBean> datas = new ArrayList<>();
    private List<BaseFragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter adapter;



    @Override
    protected ProjectContract.IProjectPresenter setPresenter() {
        return new ProjectPresenter();
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        requestDatas();

        adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return datas.get(position).getName();
            }
        };
        vpagerProject.setAdapter(adapter);
        tablayoutProject.setupWithViewPager(vpagerProject);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_project;
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
    public static ProjectFrag getInstance() {
        ProjectFrag frag = new ProjectFrag();
        return frag;
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }


    @Override
    public void requestDatas() {
        if (datas==null || datas.size() == 0) {
            mPresenter.requestDatas();
        }

    }

    @Override
    public void updateDatas(List<ProjectTitleBean.DataBean> datas) {
        if (datas == null || datas.size() == 0) return;

        this.datas.clear();
        this.fragments.clear();
        for (int i = 0; i < datas.size(); i++) {
            this.datas.add(datas.get(i));
            fragments.add(SubProjectFrag.getInstance(datas.get(i).getId()));
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }
}
