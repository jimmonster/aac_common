package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-24
 * @description :
 */
public class KeyBoardAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public KeyBoardAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    if (hasFocus) {
                        v.setBackgroundResource(R.drawable.iv_search_btn_f);
                    } else {
                        v.setBackgroundResource(R.drawable.iv_search_btn);
                    }
                }
            }
        });
        helper.setText(R.id.tv_keycode, item);

    }
}
