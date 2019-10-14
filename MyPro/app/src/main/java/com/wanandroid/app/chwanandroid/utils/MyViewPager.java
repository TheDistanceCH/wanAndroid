package com.wanandroid.app.chwanandroid.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * create time on  2019/7/23
 * function:  vpager去除滑动
 */
public class MyViewPager extends ViewPager {
    private boolean canScroll = false;
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }


    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,canScroll);
    }

    /**
     * 设置出去滑动
     * @param item
     * @param smoothScroll
     */
    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, canScroll);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (!canScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (!canScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

}
