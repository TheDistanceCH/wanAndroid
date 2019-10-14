package com.wanandroid.app.chwanandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;


import com.wanandroid.app.chwanandroid.base.basehttp.BaseBean;
import com.wanandroid.app.chwanandroid.mine.bean.UserBean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * 用户信息存储
 *
 * @author mylib
 */
public final class UserSp {
    private static final String USER_FILE_NAME = "user_info";
    private static final String KEY_USER_SERIALIZE = "user_serialize";
    private static final String KEY_FINISH_GUIDE = "guide_station";
    /**
     * 保存User对象
     *
     * @param context
     */
    public static void saveUser(Context context, UserBean user) {
        SharedPreferences sp = context.getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        try {
            String ser = serializeObject(user);
            sp.edit().putString(KEY_USER_SERIALIZE, ser).commit();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    /**
     * 获取User 对象
     *
     * @param context
     * @return
     */
    public static UserBean getUser(Context context) {
        if (context == null)
            return null;
        SharedPreferences sp = context.getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        String deSer = sp.getString(KEY_USER_SERIALIZE, "");
        if (!TextUtils.isEmpty(deSer)) {
            try {
                UserBean user = (UserBean) deSerializationObject(deSer);
                return user;
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 序列化对象
     *
     * @return
     * @throws IOException
     */

    private static String serializeObject(BaseBean bean) throws IOException {
        long startTime = System.currentTimeMillis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(bean);
        String serStr = byteArrayOutputStream.toString("ISO-8859-1");
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("序列化耗时为:" + (endTime - startTime));
        return serStr;
    }

    /**
     * 反序列化对象
     *
     * @param str
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static BaseBean deSerializationObject(String str) throws IOException,
            ClassNotFoundException {
        long startTime = System.currentTimeMillis();
        String redStr = java.net.URLDecoder.decode(str, "UTF-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                redStr.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        BaseBean object = (BaseBean) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        long endTime = System.currentTimeMillis();
        return object;
    }

    /*
     * 保存新手界面跳转值
     */

    public static void saveGiude(Context context, boolean bool) {
        SharedPreferences sp = context.getSharedPreferences(KEY_FINISH_GUIDE, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putBoolean(KEY_FINISH_GUIDE, bool);
        edit.commit();
    }

    /*
     * 取出新手界面跳转值
     */
    public static boolean getGuide(Context context) {
        boolean boolean1 = false;
        try {
            SharedPreferences sp = context.getSharedPreferences(KEY_FINISH_GUIDE, Context.MODE_PRIVATE);
            boolean1 = sp.getBoolean(KEY_FINISH_GUIDE, false);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return boolean1;
    }

    /**
     * 清除UserDb数据
     *
     * @param context
     */
    public static void clearUserDbData(Context context) {
        SharedPreferences sp = context.getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().clear().commit();

    }
}