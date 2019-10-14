package com.wanandroid.app.chwanandroid.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.base.basemvp.BaseFragment;
import com.wanandroid.app.chwanandroid.mine.MineContract;
import com.wanandroid.app.chwanandroid.mine.bean.UserBean;
import com.wanandroid.app.chwanandroid.mine.eventMessage.MineEventMessage;
import com.wanandroid.app.chwanandroid.mine.presenter.MinePrsenter;
import com.wanandroid.app.chwanandroid.utils.GlideCircleBorderTransform;
import com.wanandroid.app.chwanandroid.utils.UserSp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * create time on  2019/7/23
 * function:
 */
public class MineFrag extends BaseFragment<MineContract.IMinePresenter>
        implements MineContract.IMineView {


    @Bind(R.id.img_user_bg)
    ImageView imgUserBg;
    @Bind(R.id.img_user)
    ImageView imgUser;
    @Bind(R.id.tv_userName_mine)
    TextView tvUserNameMine;
    @Bind(R.id.layout_about_mine)
    RelativeLayout layoutAboutMine;
    @Bind(R.id.layout_exit_mine)
    RelativeLayout layoutExitMine;

    @Override
    protected MineContract.IMinePresenter setPresenter() {
        return new MinePrsenter();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initViews(View view, LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loadUserInfo();
        Glide.with(mContext)
                .load(R.mipmap.im_user_big)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(50, 6)))
                .into(imgUserBg);

        Glide.with(mContext)
                .load(R.mipmap.im_user_small)
                .apply(RequestOptions.circleCropTransform())
                .apply(RequestOptions.bitmapTransform(new GlideCircleBorderTransform(2,
                        R.color.colorWhite)))
                .into(imgUser);


    }

    public void loadUserInfo() {
        UserBean userBean = UserSp.getUser(mContext);
        if (userBean == null) {
            tvUserNameMine.setText(getResources().getString(R.string.not_login));
            return;
        }

        tvUserNameMine.setText(userBean.getData().getUsername());
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_mine;
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
    public static MineFrag getInstance() {
        MineFrag mineFrag = new MineFrag();
        return mineFrag;
    }

    @Override
    public void showMessage(String s) {
        showToast(s);
    }


    @OnClick({R.id.img_user, R.id.layout_about_mine, R.id.layout_exit_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_user:
                if (checkUserLoginState()) {
                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
                }
                break;
            case R.id.layout_about_mine:
                AboutAtivity.createAboutActivity(mContext);
                break;
            case R.id.layout_exit_mine:
                //请求退出
                mPresenter.loginOut();
                break;
            default:
                break;
        }


    }

    private boolean checkUserLoginState() {
        UserBean bean = UserSp.getUser(mContext);
        return bean == null;
    }


    @Subscribe
    public void changeUserLoginState(MineEventMessage eventMessage) {
        loadUserInfo();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {
        UserSp.clearUserDbData(mContext);
        tvUserNameMine.setText(getResources().getString(R.string.not_login));
        showMessage(getResources().getString(R.string.exit_success));
    }
}
