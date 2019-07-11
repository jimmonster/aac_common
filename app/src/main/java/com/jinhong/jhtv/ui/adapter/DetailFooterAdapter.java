package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.FocusUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class DetailFooterAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DetailFooterAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        FocusUtils.onFocusChange(helper.itemView);
        // 加载网络图片
//        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.iv_pics));
//        Glide.with(mContext).load(R.drawable.iv_poster_0).into((ImageView) helper.getView(R.id.iv_pics));
        helper.setImageResource(R.id.iv_pics, R.drawable.iv_poster_0);

    }


}
