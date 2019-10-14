package com.wanandroid.app.chwanandroid.base.basemvp;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * create time on  2019/7/14
 * function:
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected SoftReference<IBaseView> mReferenceView;

    private V mProxView;


    @SuppressWarnings("unchecked")
    @Override
    public void attach(final IBaseView view) {

        mReferenceView = new SoftReference<>(view);

        mProxView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(),
                view.getClass().getInterfaces(), new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (mReferenceView == null || mReferenceView.get() == null) {
                            return null;
                        }
                        return method.invoke(mReferenceView.get(), args);
                    }
                });
    }

    //获取view
    public V getView() {
        return mProxView;
    }

    @Override
    public void detach() {
        mReferenceView.clear();
        mReferenceView = null;
        mProxView = null;
    }


    /**
     * 设置忽略的错误类型
     * @param e
     * @return
     */
    public boolean checkMissError(Throwable e) {
        return (e instanceof NullPointerException || e instanceof UndeclaredThrowableException);
    }
}
