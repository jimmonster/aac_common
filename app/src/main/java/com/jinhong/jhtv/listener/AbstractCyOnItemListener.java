package com.jinhong.jhtv.listener;

import android.view.View;

import com.jinhong.jhtv.R;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :
 */
public class AbstractCyOnItemListener implements TvRecyclerView.OnItemListener {
    @Override
    public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
        if (itemView != null) {
            itemView.setBackgroundResource(R.drawable.iv_btn_drawing_normal);
        }

    }

    @Override
    public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
        if (itemView != null) {
            itemView.setBackgroundResource(R.drawable.iv_btn_drawing_focus);
        }
    }

    @Override
    public void onItemClick(TvRecyclerView parent, View itemView, int position) {
        if (itemView != null) {
            itemView.setBackgroundResource(R.drawable.iv_btn_drawing_press);
        }
    }
}
