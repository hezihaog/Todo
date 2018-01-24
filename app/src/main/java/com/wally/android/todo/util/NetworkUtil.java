package com.wally.android.todo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Package: oms.mmc.WishingTree.Utils
 * FileName: NetworkUtil
 * Date: on 2018/1/3  下午4:24
 * Auther: zihe
 * Descirbe:网络工具类
 * Email: hezihao@linghit.com
 */

public class NetworkUtil {
    /**
     * 是否有网络连接
     */
    public static boolean hasNetwork(Context context) {
        try {
            ConnectivityManager localConnectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            //注意添加权限，android.permission.ACCESS_NETWORK_STATE
            NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
            if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {
                return true;
            }
        } catch (Throwable localThrowable) {
            localThrowable.printStackTrace();
        }
        return false;
    }

    /**
     * 是否wifi下
     */
    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }
}