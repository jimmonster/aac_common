package com.jinhong.jhtv.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class DetailTabAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements View.OnFocusChangeListener {


    public DetailTabAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {


        helper.setText(R.id.tv_count, item);
        helper.itemView.setOnFocusChangeListener(this);

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v != null) {
            TextView view = (TextView) v.findViewById(R.id.tv_count);
            if (hasFocus) {
                view.setTextColor(Color.parseColor("#e8a007"));
                view.setTextSize(20);
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
            } else {
                view.setTextColor(Color.parseColor("#ffffff"));
                view.setTextSize(16);
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            }
        }
    }
}
