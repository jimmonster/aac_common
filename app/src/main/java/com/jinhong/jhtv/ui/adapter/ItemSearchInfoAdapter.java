package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-30
 * @description :
 */
public class ItemSearchInfoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ItemSearchInfoAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    if (hasFocus) {
                        v.setBackgroundResource(R.color.color_orange_e4a74c);
                    }else {
                        v.setBackgroundResource(R.color.color_blue_5f71bb);
                    }
                }
            }
        });
        helper.setText(R.id.tv_item_search_info, item);

    }
}