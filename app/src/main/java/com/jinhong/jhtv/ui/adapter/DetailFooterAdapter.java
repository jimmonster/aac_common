package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.DetailBean;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class DetailFooterAdapter extends BaseQuickAdapter<DetailBean.DataBean.PosterVoListBean, BaseViewHolder> {

    public DetailFooterAdapter(int layoutResId, @Nullable List<DetailBean.DataBean.PosterVoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailBean.DataBean.PosterVoListBean item) {
        FocusUtils.onFocusChange(helper.itemView);
        ImageUtils.load(item.getPosterPath(), (ImageView) helper.getView(R.id.iv_pics));
        helper.setText(R.id.tv_title, item.getMainName());

    }


}
