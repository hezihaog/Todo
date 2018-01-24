package com.wally.android.todo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wally.android.todo.dao.DaoMaster;
import com.wally.android.todo.dao.DaoSession;


public class TodoGreenDaoManager {
    private static final String DB_NAME = "mmc_wish_tree_plug_dao";
    private static volatile TodoGreenDaoManager mInstance;
    private static Context context;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static boolean isInited = false;

    private TodoGreenDaoManager() {
        if (mInstance == null) {
            TodoSQLiteOpenHelper openHelper = new TodoSQLiteOpenHelper(context, DB_NAME);
            SQLiteDatabase db = openHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(db);
            mDaoSession = mDaoMaster.newSession();
        }
        isInited = true;
    }

    /**
     * 初始化
     */
    public static void init(Context context) {
        if (context == null) {
            throw new RuntimeException("init方法传入的context不能为空");
        }
        TodoGreenDaoManager.context = context;
        mInstance = new TodoGreenDaoManager();
    }

    /**
     * 获取实例
     */
    public static TodoGreenDaoManager getInstance() {
        if (!isInited) {
            throw new RuntimeException("请先调用init方法进行初始化");
        }
        if (mInstance == null) {
            synchronized (TodoGreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new TodoGreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public static Context getContext() {
        return context;
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}