package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.CollectListBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :我的收藏适配器
 */
public class InfoListAdapter extends BaseQuickAdapter<CollectListBean.DataBean.ListBean, BaseViewHolder> {


    public InfoListAdapter(int layoutResId, @Nullable List<CollectListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectListBean.DataBean.ListBean item) {

        helper.setText(R.id.tv_name, item.getMainName());
        helper.setText(R.id.tv_type, item.getDramaType());
        helper.setText(R.id.tv_isCollection, item.getCreatetime() + "");
        helper.setText(R.id.tv_play, "播放");
        helper.setText(R.id.tv_isCollection, "取消收藏");
        helper.addOnClickListener(R.id.tv_play);
        helper.addOnClickListener(R.id.tv_isCollection);

    }

}
