package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-08
 * @description :
 */
public class MbAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {


    public MbAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        FocusUtils.onFocusChange(helper.itemView);
        ImageUtils.load(item, (ImageView) helper.getView(R.id.iv_pics));

    }

}
