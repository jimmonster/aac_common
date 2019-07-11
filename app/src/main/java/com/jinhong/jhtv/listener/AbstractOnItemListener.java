package com.jinhong.jhtv.listener;

import android.view.View;

import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :
 */
public abstract class AbstractOnItemListener implements TvRecyclerView.OnItemListener {
    @Override
    public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
        if (itemView != null) {
            FocusUtils.unselected(itemView);
        }

    }

    @Override
    public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
        if (itemView != null) {
            FocusUtils.selected(itemView);
        }
    }

    @Override
    public abstract void onItemClick(TvRecyclerView parent, View itemView, int position);
}
