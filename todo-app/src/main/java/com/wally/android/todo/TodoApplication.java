package com.wally.android.todo;

import android.app.Application;
import android.os.Handler;

import com.wally.android.todo.util.EventBusUtil;
import com.wally.android.todo.util.PropertyUtil;
import com.wally.android.todo.util.TodoGreenDaoManager;

/**
 * Package: com.wally.android.todo
 * FileName: TodoApplication
 * Date: on 2018/1/24  下午12:11
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class TodoApplication extends Application {
    private static TodoApplication instnace;
    private Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        instnace = this;
        mainHandler = new Handler(getMainLooper());
        EventBusUtil.init();
        PropertyUtil.init(this);
        TodoGreenDaoManager.init(this);
    }

    public static TodoApplication getInstnace() {
        return instnace;
    }

    public void post(Runnable runnable) {
        mainHandler.post(runnable);
    }

    public void postDelayed(Runnable runnable, long delayMillis) {
        mainHandler.postDelayed(runnable, delayMillis);
    }
}