package com.wanandroid.app.chwanandroid.wx_public.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseActivity;
import com.wanandroid.app.chwanandroid.pass_detail.view.PassDetailActivity;
import com.wanandroid.app.chwanandroid.wx_public.PublicSearchContract;
import com.wanandroid.app.chwanandroid.wx_public.adapter.SearchPublicAdapter;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicSearchBean;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicTitleListBean;
import com.wanandroid.app.chwanandroid.wx_public.listener.OnSubPublicListener;
import com.wanandroid.app.chwanandroid.wx_public.presenter.PublicSearchPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PublicSearchActivity extends BaseActivity<PublicSearchContract.IPublicSearchPresenter>
        implements PublicSearchContract.IPublicSearchView {

    @Bind(R.id.edit_search)
    EditText editSearch;
    @Bind(R.id.img_search)
    ImageView imgSearch;
    @Bind(R.id.layout_public)
    RelativeLayout layoutPublic;
    @Bind(R.id.linear_publicSearch)
    LinearLayout linearPublicSearch;
    @Bind(R.id.scroll_publicSearch)
    HorizontalScrollView scrollPublicSearch;
    @Bind(R.id.recy_publicSearch)
    RecyclerView recyPublicSearch;
    @Bind(R.id.smart_publicSearch)
    SmartRefreshLayout smartPublicSearch;

    private List<PublicSearchBean.DataBean.DatasBean> datas = new ArrayList<>();
    private SearchPublicAdapter adapter;
    private int weixin;

    //上一次点击的公众号
    private TextView tvOld;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_public_search;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

        getIntentValue();

        //监听edit的回车键
        addEditListener();
        adapter = new SearchPublicAdapter(this, datas, new OnSubPublicListener() {
            @Override
            public void onItemClick(int pos) {
                goDetailActivity(datas.get(pos).getTitle(),datas.get(pos).getLink());
            }
        });

        recyPublicSearch.setAdapter(adapter);
        recyPublicSearch.setLayoutManager(new LinearLayoutManager(
                PublicSearchActivity.this));

        smartPublicSearch.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (!TextUtils.isEmpty(editSearch.getText().toString())) {
                    mPresenter.loadrMore();
                } else {
                    showToast(getString(R.string.edit_search_null));
                    smartPublicSearch.finishLoadMore();
                }

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (!TextUtils.isEmpty(editSearch.getText().toString())) {
                    mPresenter.fresh(weixin,editSearch.getText().toString());
                } else {
                    showToast(getString(R.string.edit_search_null));
                    smartPublicSearch.finishRefresh();
                }
            }
        });

        mPresenter.requestPublicTitle();


    }

    private void addEditListener() {
        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    onViewClicked();
                }
                return true;
            }
        });
    }

    @Override
    protected void initDatas() {

    }

    private void getIntentValue() {
        weixin = getIntent().getIntExtra("searchWeiXin", 0);
    }

    @Override
    protected void attachPresenterView() {

        mPresenter.attach(this);
    }

    @Override
    protected PublicSearchContract.IPublicSearchPresenter setProsenter() {
        return new PublicSearchPresenter();
    }


    @Override
    public void onSuccess() {
        smartPublicSearch.finishRefresh();
        smartPublicSearch.finishLoadMore();
        smartPublicSearch.setEnableLoadMore(true);
    }

    @Override
    public void onFailure() {
        smartPublicSearch.finishLoadMore();
        smartPublicSearch.finishRefresh();
        smartPublicSearch.setEnableLoadMore(false);
    }

    @Override
    public void onUpdateDatas(List<PublicSearchBean.DataBean.DatasBean> datas) {
        if (datas == null || datas.size() == 0) {
            return;
        }
        this.datas.clear();
        this.datas.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    /**
     * 添加公众号的item
     *
     * @param datas
     */
    @Override
    public void updateTitles(final List<PublicTitleListBean.DataBean> datas) {

        if (datas == null || datas.size() == 0) return;
        for ( int i = 0; i < datas.size(); i++) {
            final TextView textView = new TextView(PublicSearchActivity.this);
            textView.setText(datas.get(i).getName());
            textView.setTextColor(getResources().getColor(R.color.colorBlack));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            textView.setGravity(Gravity.CENTER);

            if(weixin == datas.get(i).getId()){
                textView.setBackground(getResources().
                        getDrawable(R.drawable.tv_publi_search_item_sel));
                tvOld = textView;
            }else {
                textView.setBackground(getResources().getDrawable(R.drawable.tv_publi_search_item));
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(20, 2, 20, 2);
            textView.setLayoutParams(layoutParams);


            //添加监听
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    weixin = datas.get(finalI).getId();
                    textView.setBackground(getResources().getDrawable(R.drawable.tv_publi_search_item_sel));
                    if(tvOld!=null && tvOld!=textView){
                        tvOld.setBackground(getResources().getDrawable(
                                R.drawable.tv_publi_search_item));
                    }
                    tvOld = textView;

                }
            });

            linearPublicSearch.addView(textView);


        }

        linearPublicSearch.invalidate();
    }

    @Override
    public void goDetailActivity(String title, String url) {
        if(TextUtils.isEmpty(title)|| TextUtils.isEmpty(url))return;

        PassDetailActivity.createPassDetailActivity(PublicSearchActivity.this,title,url);
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }


    @OnClick(R.id.img_search)
    public void onViewClicked() {
//        if(TextUtils.isEmpty(editSearch.getText().toString())){
//            showToast(getString(R.string.edit_search_null));
//        }
        mPresenter.fresh(weixin, editSearch.getText().toString().trim());
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);
    }


    public static void getInstance(Context context, int weixin) {
        Intent intent = new Intent(context, PublicSearchActivity.class);
        intent.putExtra("searchWeiXin", weixin);
        context.startActivity(intent);
    }
}
