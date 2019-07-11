package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :
 */
public class CyLeftAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CyLeftAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_cy_left,item);

    }
}
