package com.wally.android.todo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wally.android.recyclerview.adapter.multitype.MultiTypeAdapter;
import com.wally.android.todo.base.BaseRecyclerViewFragment;
import com.wally.android.todo.model.item.DisplayItem;
import com.wally.android.todo.model.provider.DisplayItemProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.wally.android.todo.ui.fragment
 * FileName: AllTodoListFragment
 * Date: on 2018/1/28  下午5:13
 * Auther: zihe
 * Descirbe:所有代办事项fragment
 * Email: hezihao@linghit.com
 */

public class AllTodoListFragment extends BaseRecyclerViewFragment {

    @Override
    protected RecyclerView.Adapter onRecyclerViewAdapterReady() {
        return new MultiTypeAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager onRecyclerViewLayoutManagerReady() {
        return new LinearLayoutManager(getActivity());
    }

    @Override
    protected void onRecyclerViewReady(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        MultiTypeAdapter typeAdapter = (MultiTypeAdapter) adapter;
        typeAdapter.register(DisplayItem.class, new DisplayItemProvider(getActivity()));
        typeAdapter.addDatas(onGetData());
    }

    private List<DisplayItem> onGetData() {
        ArrayList<DisplayItem> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add(new DisplayItem());
        }
        return items;
    }
}