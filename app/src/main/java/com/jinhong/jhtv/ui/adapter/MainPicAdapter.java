package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public class MainPicAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MainPicAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.getView(R.id.iv_pics).setFocusableInTouchMode(true); // 测试鼠标效果.
        helper.getView(R.id.iv_pics).setFocusable(true);
        // 加载网络图片
        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.iv_pics));


    }
}
