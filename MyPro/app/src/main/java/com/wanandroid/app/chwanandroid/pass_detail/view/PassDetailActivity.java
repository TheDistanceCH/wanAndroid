package com.wanandroid.app.chwanandroid.pass_detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseActivity;
import com.wanandroid.app.chwanandroid.constant.ConstantClass;
import com.wanandroid.app.chwanandroid.pass_detail.PassDetailContract;
import com.wanandroid.app.chwanandroid.pass_detail.PassDetailContract.IPassDetailView;
import com.wanandroid.app.chwanandroid.pass_detail.presenter.PassDetailPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassDetailActivity extends BaseActivity<PassDetailContract.IPassDetailPresenter>
        implements IPassDetailView {

    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.tv_collect)
    TextView tvCollect;

    @Bind(R.id.webview_passdetail)
    WebView webviewPassdetail;
    @Bind(R.id.progress_detail)
    ProgressBar progressDetail;
    @Bind(R.id.tv_title)
    TextView tvTitle;


    private String title;

    private String passUrl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pass_detail;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

        loadWeb(passUrl);
    }


    @Override
    protected void initDatas() {

        getIntentDatas();
    }

    //获取其他页面传输的数据
    private void getIntentDatas() {
        title = getIntent().getStringExtra("title");
        passUrl = getIntent().getStringExtra("passUrl");

        if (title.equals("") || passUrl.equals("")) {
            showMessage(getResources().getString(R.string.sen_info_error));
            finish();
        }

    }

    @Override
    protected void attachPresenterView() {
        mPresenter.attach(this);
    }

    @Override
    protected PassDetailContract.IPassDetailPresenter setProsenter() {
        return new PassDetailPresenter();
    }


    /**
     * 这里控制进度条的显示与否，当然控件样式的修改也可以在
     * @param b
     */
    @Override
    public void showProgress(boolean b) {
        if (b) {
            progressDetail.setVisibility(View.VISIBLE);
        } else {
            progressDetail.setVisibility(View.GONE);
        }
    }

    @Override
    public void loadWeb(String webUrl) {
        webviewPassdetail.getSettings().setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webviewPassdetail.getSettings().setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webviewPassdetail.getSettings().setDisplayZoomControls(true); //隐藏原生的缩放控件
        webviewPassdetail.getSettings().setBlockNetworkImage(false);//解决图片不显示
        webviewPassdetail.getSettings().setLoadsImagesAutomatically(true); //支持自动加载图片
        webviewPassdetail.getSettings().setDefaultTextEncodingName("utf-8");//设置编码格式

        WebSettings webSetting = webviewPassdetail.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        // webSetting.setSupportZoom(true);
        //webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);

        webviewPassdetail.loadUrl(passUrl);

        //该界面打开更多链接
        webviewPassdetail.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });


        //监听网页的加载进度
        webviewPassdetail.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                if (i < 100) {
                    showProgress(true);
                    webView.setVisibility(View.GONE);
                } else {
                    tvTitle.setSelected(true);
                    tvTitle.setText(title);
                    showProgress(false);
                    webView.setVisibility(View.VISIBLE);

                }
            }
        });


    }

    @Override
    public void onLoadError() {
        showMessage(getResources().getString(R.string.error_internet_null));
        Log.d(ConstantClass.TAG, getLocalClassName() + ":" +
                getResources().getString(R.string.error_internet_null));
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
        Log.d(ConstantClass.TAG, getLocalClassName() + ":" + s);
    }

    @OnClick({R.id.tv_back, R.id.tv_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_collect:
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        webviewPassdetail.onResume();
        webviewPassdetail.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        webviewPassdetail.onPause();
        webviewPassdetail.getSettings().setJavaScriptEnabled(false);
    }

    @Override
    protected void onDestroy() {
        if (webviewPassdetail != null) {
            webviewPassdetail.destroy();
        }
        super.onDestroy();

    }

    /**
     * @param context
     * @param title   文章标题
     * @param url     请求的url地址
     */
    public static void createPassDetailActivity(Context context, String title, String url) {
        Intent intent = new Intent(context, PassDetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("passUrl", url);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
