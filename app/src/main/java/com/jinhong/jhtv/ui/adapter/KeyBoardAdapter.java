package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.FocusUtils;

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
        FocusUtils.onFocusChange(helper.itemView);
        helper.setText(R.id.tv_keycode,item);

    }
}
