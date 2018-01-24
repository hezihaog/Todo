package com.wally.android.todo.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Package: PACKAGE_NAME
 * FileName: BaseActivity
 * Date: on 2018/1/23  下午10:49
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public abstract class BaseActivity extends AppCompatActivity implements LayoutCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLayoutBefore();
        setContentView(onLayoutId());
        ButterKnife.bind(this);
        onLayoutAfter();
    }

    @Override
    public void onLayoutBefore() {

    }

    @Override
    public void onLayoutAfter() {

    }
}
