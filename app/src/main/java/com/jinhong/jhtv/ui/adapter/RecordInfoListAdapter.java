package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.RecordListBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :我的收藏适配器
 */
public class RecordInfoListAdapter extends BaseQuickAdapter<RecordListBean.DataBean.ListBean, BaseViewHolder> {

    public RecordInfoListAdapter(int layoutResId, @Nullable List<RecordListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecordListBean.DataBean.ListBean item) {

        helper.setText(R.id.tv_name, item.getMainName());
        helper.setText(R.id.tv_type, item.getDramaType());
        helper.setText(R.id.tv_progress, item.getDration());
        helper.setText(R.id.tv_play, "播放");
        helper.addOnClickListener(R.id.tv_play);

    }
}
