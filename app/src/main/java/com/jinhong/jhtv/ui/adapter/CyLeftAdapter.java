package com.jinhong.jhtv.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.CategoryLeftBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :
 */
public class CyLeftAdapter extends BaseQuickAdapter<CategoryLeftBean.DataBean, BaseViewHolder> {


    public CyLeftAdapter(int layoutResId, List<CategoryLeftBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryLeftBean.DataBean item) {
        helper.setText(R.id.tv_cy_left, item.getName());
    }


}
