package com.wally.android.todo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wally.android.todo.dao.DaoMaster;

import org.greenrobot.greendao.database.Database;

import static com.wally.android.todo.dao.DaoMaster.dropAllTables;


/**
 * Package: com.hzh.green.dao.sample.util
 * FileName: MySQLiteOpenHelper
 * Date: on 2017/12/28  下午4:54
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class TodoSQLiteOpenHelper extends DaoMaster.OpenHelper {
    private static final String TAG = TodoSQLiteOpenHelper.class.getSimpleName();

    public TodoSQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public TodoSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (oldVersion == newVersion) {
            Log.i(TAG, "数据库无需升级");
            return;
        }
        Log.i(TAG, "数据库从" + oldVersion + "升级到 ::: " + newVersion + "版本");
        //清除所有表，重建
        dropAllTables(db, true);
        onCreate(db);
    }
}