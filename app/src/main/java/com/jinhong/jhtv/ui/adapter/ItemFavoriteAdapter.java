package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-30
 * @description :
 */
public class ItemFavoriteAdapter extends BaseQuickAdapter<MainListBean.DataBean.PosterVosBean, BaseViewHolder> {
    public ItemFavoriteAdapter(int layoutResId, @Nullable ArrayList<MainListBean.DataBean.PosterVosBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainListBean.DataBean.PosterVosBean item) {
        FocusUtils.onFocusChange(helper.itemView);
        ImageUtils.load(item.getPosterPath(), (ImageView) helper.getView(R.id.iv_pics));

    }
}
