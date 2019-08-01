package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.CollectionBean;
import com.jinhong.jhtv.ui.dialog.CommonDialog;
import com.jinhong.jhtv.utils.FocusUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :我的收藏适配器
 */
public class InfoListAdapter extends BaseQuickAdapter<CollectionBean, BaseViewHolder> {

    public InfoListAdapter(int layoutResId, @Nullable List<CollectionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectionBean item) {

        FocusUtils.onFocusChange(helper.itemView.findViewById(R.id.tv_play), R.drawable.iv_collection_co_f, R.drawable.iv_collection_co);

        FocusUtils.onFocusChange(helper.itemView.findViewById(R.id.tv_isCollection), R.drawable.iv_collection_co_f, R.drawable.iv_collection_co);


        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_type, item.getType());
        helper.setText(R.id.tv_isCollection, item.getIsCollect());
        helper.setText(R.id.tv_play, "播放");


       helper.getView(R.id.tv_play).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(mContext, "播放", Toast.LENGTH_SHORT).show();

           }
       });

        helper.getView(R.id.tv_isCollection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDialog.getInstance(mContext).show();
            }
        });
    }
}
