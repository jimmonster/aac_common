package com.jinhong.jhtv.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :
 */
public class MainTabsAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {


    public MainTabsAdapter(int layoutResId, List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        ImageUtils.load(item,helper.getView(R.id.tv_main_tab));
    }


}
