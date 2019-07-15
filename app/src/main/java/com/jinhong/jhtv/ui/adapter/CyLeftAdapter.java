package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

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
    private int mBtnDrawable, mTextColor;

    public CyLeftAdapter(int layoutResId, @Nullable List<String> data, int btnDrawable, int textColor) {
        super(layoutResId, data);
        mBtnDrawable = btnDrawable;
        mTextColor = textColor;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView textView = (TextView) helper.getView(R.id.tv_cy_left);
        helper.setText(R.id.tv_cy_left, item);
        textView.setBackgroundResource(mBtnDrawable);
        textView.setTextColor(mTextColor);


    }
}
