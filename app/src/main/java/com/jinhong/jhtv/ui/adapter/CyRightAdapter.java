package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public class CyRightAdapter extends BaseQuickAdapter<CategoryItemBean, BaseViewHolder> {

    public CyRightAdapter(int layoutResId, @Nullable List<CategoryItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryItemBean item) {
        FocusUtils.onFocusChange(helper.itemView);
        helper.setText(R.id.tv_title, item.getTitle());
        ImageUtils.load(R.drawable.iv_poster_0, (ImageView) helper.getView(R.id.iv_pics));


    }
}
