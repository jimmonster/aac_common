package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.DetailBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class DetailCountAdapter extends BaseQuickAdapter<DetailBean.DataBean.ChildVosBean, BaseViewHolder> {
    public DetailCountAdapter(int layoutResId, @Nullable List<DetailBean.DataBean.ChildVosBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailBean.DataBean.ChildVosBean item) {
        helper.setText(R.id.tv_count, item.getSort());

    }


}
