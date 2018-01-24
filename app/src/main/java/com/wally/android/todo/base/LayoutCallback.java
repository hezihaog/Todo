package com.wally.android.todo.base;

/**
 * Package: com.wally.android.todo.ui.base
 * FileName: LayoutCallback
 * Date: on 2018/1/23  下午10:50
 * Auther: zihe
 * Descirbe:布局回调接口
 * Email: hezihao@linghit.com
 */

public interface LayoutCallback {
    /**
     * 设置布局之前回调，可拿取一些传过来的参数
     */
    void onLayoutBefore();

    /**
     * 获取布局资源id，开始设置布局
     */
    int onLayoutId();

    /**
     * 设置布局之后，可查找一些控件进行相关设置
     */
    void onLayoutAfter();
}