package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class DetailCountAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements View.OnFocusChangeListener {
    public DetailCountAdapter(int layoutResId, @Nullable List<String> data) {
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
            if (hasFocus) {
                v.setBackgroundResource(R.drawable.jbtn_f);
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
            } else {
                v.setBackgroundResource(R.drawable.jbtn);
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            }
        }
    }
}
