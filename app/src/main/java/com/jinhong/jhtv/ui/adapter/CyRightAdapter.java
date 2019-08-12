package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.ProgrammeBean;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public class CyRightAdapter extends BaseQuickAdapter<ProgrammeBean.DataBean.ListBean, BaseViewHolder> {
    public CyRightAdapter(int layoutResId, @Nullable List<ProgrammeBean.DataBean.ListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ProgrammeBean.DataBean.ListBean item) {
        FocusUtils.onFocusChange(helper.itemView);
        helper.setText(R.id.tv_title, item.getMainName());
        ImageUtils.load(item.getPosterPath(), (ImageView) helper.getView(R.id.iv_pics));


    }
}
