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
public class DetailFooterAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements View.OnFocusChangeListener {

    public DetailFooterAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.itemView.setOnFocusChangeListener(this);
        // 加载网络图片
//        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.iv_pics));
//        Glide.with(mContext).load(R.drawable.iv_poster_0).into((ImageView) helper.getView(R.id.iv_pics));
        helper.setImageResource(R.id.iv_pics, R.drawable.iv_poster_0);

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v != null) {
            v.setSelected(hasFocus);
            if (hasFocus) {
                v.setBackgroundResource(R.drawable.shape_selector_border_press);
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
            } else {
                v.setBackgroundResource(R.drawable.shape_selector_border_normal);
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            }
        }
    }
}
