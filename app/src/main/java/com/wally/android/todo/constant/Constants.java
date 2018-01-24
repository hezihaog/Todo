package com.wally.android.todo.constant;

/**
 * Package: com.wally.android.todo.constant
 * FileName: Constants
 * Date: on 2018/1/24  上午11:49
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class Constants {
    /**
     * 配置信息
     */
    public static class Config {
        public static final String propertyName = "app.config";
    }

    /**
     * 逻辑删除标志位
     */
    public static class LogicDelete {
        //没有删除
        public static final int NOT_LOGIC_DELETE = 1;
        //删除了
        public static final int IS_LOGIC_DELETE = -100;
    }
}