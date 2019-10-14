package com.wanandroid.app.chwanandroid.wx_public.view;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.wx_public.PublicContract;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;
import com.wanandroid.app.chwanandroid.wx_public.presenter.PubclicPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import butterknife.OnClick;

/**
 * create time on  2019/7/23
 * function: 微信公众号frag
 */
public class PublicFrag extends BaseFragment<PublicContract.IPubclicPresenter>
        implements PublicContract.IPubclicView {


    @Bind(R.id.tab_public)
    TabLayout tabPublic;
    @Bind(R.id.vpager_public)
    ViewPager vpagerPublic;
    @Bind(R.id.btn_search_public)
    FloatingActionButton btnSearchPublic;

    private List<BaseFragment> fragments = new ArrayList<>();
    private List<PublicTitleListBean.DataBean> datas = new ArrayList<>();
    private FragmentPagerAdapter adapter;

    @Override
    protected PublicContract.IPubclicPresenter setPresenter() {
        return new PubclicPresenter();
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (fragments.size() == 0 || datas.size() == 0) {
            requestTitles();
        }

        initVpager();
    }

    private void initVpager() {
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
        vpagerPublic.setAdapter(adapter);
        tabPublic.setupWithViewPager(vpagerPublic);
    }


    @Override
    protected void initDatas() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_public;
    }

    @Override
    protected void presenterAttachView() {
        mPresenter.attach(this);
    }

    @OnClick(R.id.btn_search_public)
    public void onViewClicked() {
        if(datas==null || datas.size()==0) return;
        PublicSearchActivity.getInstance(mContext,
                datas.get(vpagerPublic.getCurrentItem()).getId());
    }

    /**
     * 创建
     *
     * @return
     */
    public static PublicFrag getInstance() {
        PublicFrag publicFrag = new PublicFrag();
        return publicFrag;
    }

    @Override
    public void requestTitles() {
        mPresenter.requestPublicTitles();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void updateTitles(List<PublicTitleListBean.DataBean> titles) {

        if (titles == null || titles.size() == 0) {
            return;
        }

        datas.clear();
        fragments.clear();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(SubPublicFrag.getInstance(titles.get(i).getId()));
            datas.add(titles.get(i));

        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }
}
