package com.wally.android.todo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wally.android.base.LayoutCallback;

import butterknife.ButterKnife;

/**
 * Package: com.wally.android.todo.base
 * FileName: BaseFragment
 * Date: on 2018/1/28  下午4:53
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public abstract class BaseFragment extends Fragment implements LayoutCallback {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLayoutBefore();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(onLayoutId(), container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onLayoutAfter();
    }

    @Override
    public void onLayoutBefore() {
    }

    @Override
    public void onLayoutAfter() {
    }

    protected <T extends View> T findView(int viewId) {
        return (T) getView().findViewById(viewId);
    }
}