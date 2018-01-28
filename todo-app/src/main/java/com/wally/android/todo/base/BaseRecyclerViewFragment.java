package com.wally.android.todo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wally.android.todo.R;

/**
 * Package: com.wally.android.todo.base
 * FileName: BaseListFragment
 * Date: on 2018/1/28  下午4:57
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public abstract class BaseRecyclerViewFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    @Override
    public int onLayoutId() {
        return R.layout.fragment_base;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
        onRecyclerViewReady(mRecyclerView, mRecyclerView.getAdapter());
    }

    /**
     * 设置RecyclerView控件
     */
    private void setupRecyclerView() {
        mRecyclerView = findView(R.id.base_recycler_view);
        mRecyclerView.setAdapter(onRecyclerViewAdapterReady());
        mRecyclerView.setLayoutManager(onRecyclerViewLayoutManagerReady());
    }

    /**
     * 获取适配器时回调
     */
    protected abstract RecyclerView.Adapter onRecyclerViewAdapterReady();

    /**
     * 设置布局布局管理器时回调
     */
    protected abstract RecyclerView.LayoutManager onRecyclerViewLayoutManagerReady();

    /**
     * RecyclerView设置完毕时回调
     */
    protected void onRecyclerViewReady(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
    }
}