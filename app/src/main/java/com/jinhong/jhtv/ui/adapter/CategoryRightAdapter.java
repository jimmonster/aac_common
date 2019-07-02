package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.CategoryItemBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public class CategoryRightAdapter extends BaseQuickAdapter<CategoryItemBean, BaseViewHolder> {

    public CategoryRightAdapter(int layoutResId, @Nullable List<CategoryItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryItemBean item) {
        helper.setText(R.id.tv_title,item.getTitle());
        // 加载网络图片
        Glide.with(mContext).load(item.getPic()).into((ImageView) helper.getView(R.id.iv_pics));



    }
}
