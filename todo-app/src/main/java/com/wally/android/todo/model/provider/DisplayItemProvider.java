package com.wally.android.todo.model.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.wally.android.recyclerview.adapter.base.RecyclerViewHolder;
import com.wally.android.recyclerview.adapter.multitype.BaseViewProvider;
import com.wally.android.todo.R;
import com.wally.android.todo.model.item.DisplayItem;

/**
 * Package: com.wally.android.todo.model.provider
 * FileName: DisplayItemProvider
 * Date: on 2018/1/28  下午6:27
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class DisplayItemProvider extends BaseViewProvider<DisplayItem> {
    private TextView todoContentTv;

    public DisplayItemProvider(@NonNull Context context) {
        super(context);
    }

    @Override
    public int onLayoutId() {
        return R.layout.item_todo_list;
    }

    @Override
    public void onViewHolderIsCreated(RecyclerViewHolder holder) {
        todoContentTv = holder.get(R.id.todoContent);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, DisplayItem bean, int position) {
        todoContentTv.setText(String.valueOf(position));
    }
}