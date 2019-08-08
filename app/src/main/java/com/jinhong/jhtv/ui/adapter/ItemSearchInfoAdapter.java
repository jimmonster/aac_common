package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

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
        helper.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    if (hasFocus) {
                        v.setBackgroundResource(R.drawable.iv_search_sbg_f);
                    }else {
                        v.setBackgroundResource(R.drawable.iv_search_sbg);
                    }
                }
            }
        });
        helper.setText(R.id.tv_item_search_info, item.getMainName());

    }
}
