package com.wanandroid.app.chwanandroid.main.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseActivity;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.home.view.HomeFrag;
import com.wanandroid.app.chwanandroid.main.MainContract;

import com.wanandroid.app.chwanandroid.main.presenter.MainPresenter;
import com.wanandroid.app.chwanandroid.mine.view.MineFrag;

import com.wanandroid.app.chwanandroid.project.view.ProjectFrag;
import com.wanandroid.app.chwanandroid.utils.MyViewPager;
import com.wanandroid.app.chwanandroid.wx_public.view.PublicFrag;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class MainActivity extends BaseActivity<MainContract.IMainPresenter>
        implements MainContract.IMainView {

    @Bind(R.id.vpager_main)
    MyViewPager vpagerMain;
    @Bind(R.id.tab_main)
    TabLayout tabMain;

    private List<String> titles = new ArrayList<>();

    private List<Integer> imgSel = new ArrayList<>();

    private List<Integer> imgNor = new ArrayList<>();

    private List<BaseFragment> fragments = new ArrayList<>();

    //上一次点击的位置，即初始位置
    private TabLayout.Tab oldTab;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

        initVpagerAndTab();
    }

    /**
     * 初始化vpager和tablayout
     */
    private void initVpagerAndTab() {
        vpagerMain.setOffscreenPageLimit(0);
        vpagerMain.setCanScroll(false);
        vpagerMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        tabMain.setupWithViewPager(vpagerMain);
        oldTab = tabMain.getTabAt(0);
        for (int i = 0; i < tabMain.getTabCount(); i++) {
            TabLayout.Tab tab = tabMain.getTabAt(i);
            tab.setCustomView(R.layout.tab_main);
            ImageView imageView = tab.getCustomView().findViewById(R.id.img_tab_main);
            TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_main);

            Glide.with(MainActivity.this)
                    .load((i == oldTab.getPosition()) ? imgSel.get(i) : imgNor.get(i))
                    .into(imageView);

            textView.setText(titles.get(i));

            //设置颜色
            textView.setTextColor((i == oldTab.getPosition()) ?
                    getResources().getColor(R.color.colorBottomTabSel)
                    : getResources().getColor(R.color.colorBottomTabNor));
        }

        tabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (oldTab == tab) {
                    return;
                }
                //选中的tab
                ImageView imageView = tab.getCustomView().findViewById(R.id.img_tab_main);
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_main);

                Glide.with(MainActivity.this).load(imgSel.get(tab.getPosition())).into(imageView);
                textView.setTextColor(getResources().getColor(R.color.colorBottomTabSel));

                //未选中tab
                ImageView imgOld = oldTab.getCustomView().findViewById(R.id.img_tab_main);
                TextView tvOld = oldTab.getCustomView().findViewById(R.id.tv_tab_main);

                Glide.with(MainActivity.this).load(imgNor.get(oldTab.getPosition())).into(imgOld);
                tvOld.setTextColor(getResources().getColor(R.color.colorBottomTabNor));

                oldTab = tab;

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    @Override
    protected void initDatas() {


        //导航页面就先没弄出来了，后面可以在弄，主要页面布局太丑

        titles.add(getResources().getString(R.string.main_tab_home));
        titles.add(getResources().getString(R.string.main_tab_public));
        //titles.add(getResources().getString(R.string.main_tab_navigation));
        titles.add(getResources().getString(R.string.main_tab_project));
        titles.add(getResources().getString(R.string.main_tab_mine));

        imgSel.add(R.mipmap.img_home_sel);
        imgSel.add(R.mipmap.img_wx_public_sel);
       // imgSel.add(R.mipmap.img_navigation_sel);
        imgSel.add(R.mipmap.img_project_sel);
        imgSel.add(R.mipmap.img_mine_sel);

        imgNor.add(R.mipmap.img_home_nor);
        imgNor.add(R.mipmap.img_wx_public_nor);
       // imgNor.add(R.mipmap.img_navigation_nor);
        imgNor.add(R.mipmap.img_project_nor);
        imgNor.add(R.mipmap.img_mine_nor);

        fragments.add(HomeFrag.getInstance());
        fragments.add(PublicFrag.getInstance());
        //fragments.add(NavigationFrag.getInstance());
        fragments.add(ProjectFrag.getInstance());
        fragments.add(MineFrag.getInstance());

    }

    /**
     * presenter绑定视图
     */
    @Override
    protected void attachPresenterView() {
        mPresenter.attach(this);
    }

    /**
     *
     * @return
     */
    @Override
    protected MainContract.IMainPresenter setProsenter() {
        return new MainPresenter();
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }
}
