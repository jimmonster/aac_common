package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.SearchBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-30
 * @description :
 */
public class ItemSearchInfoAdapter extends BaseQuickAdapter<SearchBean.DataBean.ListBean, BaseViewHolder> {


    public ItemSearchInfoAdapter(int layoutResId, @Nullable List<SearchBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.DataBean.ListBean item) {
        helper.setText(R.id.tv_item_search_info, item.getMainName());

    }
}
