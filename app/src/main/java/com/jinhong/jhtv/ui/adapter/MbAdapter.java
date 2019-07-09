package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-08
 * @description :
 */
public class MbAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> implements View.OnFocusChangeListener {


    public MbAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.itemView.setOnFocusChangeListener(this);
        ImageUtils.load(item,(ImageView)helper.getView(R.id.iv_pics));

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v != null) {
            if (hasFocus) {
                v.setBackgroundResource(R.drawable.iv_focus);
                v.setPadding(12,12,12,12);
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
            } else {
                v.setBackgroundResource(R.drawable.shape_selector_border_normal);
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            }
        }
    }
}
