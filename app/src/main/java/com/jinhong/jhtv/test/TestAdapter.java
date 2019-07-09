package com.jinhong.jhtv.test;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-09
 * @description :
 */
public class TestAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    public TestAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        ImageView imageView = (ImageView) helper.getView(R.id.iv_pics);
        ImageUtils.load(item, imageView);

    }
}
