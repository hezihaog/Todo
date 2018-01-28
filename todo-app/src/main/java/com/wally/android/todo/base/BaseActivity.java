package com.wally.android.todo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.wally.android.base.LayoutCallback;
import com.wally.android.todo.util.FragmentFactory;

import butterknife.ButterKnife;

/**
 * Package: PACKAGE_NAME
 * FileName: BaseActivity
 * Date: on 2018/1/23  下午10:49
 * Auther: zihe
 * Descirbe:Activity基类
 * Email: hezihao@linghit.com
 */

public abstract class BaseActivity extends AppCompatActivity implements LayoutCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLayoutBefore();
        setContentView(onLayoutId());
        ButterKnife.bind(this);
        setupFragment();
        onLayoutAfter();
    }

    @Override
    public void onLayoutBefore() {

    }

    @Override
    public void onLayoutAfter() {

    }

    public BaseActivity getActivity() {
        return this;
    }

    /**
     * 准备fragment
     */
    protected void setupFragment() {
    }

    /**
     * 添加一个fragment到指定容器中
     *
     * @param fragmentClazz fragment的class
     * @param containerId   容器id
     */
    protected void addFragment(Class fragmentClazz, int containerId) {
        addFragment(fragmentClazz, null, containerId);
    }

    /**
     * 添加一个fragment到指定容器中
     *
     * @param fragmentClazz fragment的class
     * @param args          传递的参数
     * @param containerId   容器id
     */
    protected void addFragment(Class fragmentClazz, Bundle args, int containerId) {
        Fragment fragment = FragmentFactory.newInstance(getActivity(), fragmentClazz, args);
        getSupportFragmentManager().beginTransaction().add(containerId, fragment, fragment.getClass().getName()).commit();
    }
}
