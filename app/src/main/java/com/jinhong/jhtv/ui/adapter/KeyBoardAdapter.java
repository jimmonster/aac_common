package com.jinhong.jhtv.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.AutoSizeUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-24
 * @description :
 */
public class KeyBoardAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public KeyBoardAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        switch (position) {
            default:
                ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
                params.width = AutoSizeUtils.dp2px(mContext, 70);
                params.height = AutoSizeUtils.dp2px(mContext, 70);
                holder.itemView.setLayoutParams(params);
                holder.itemView.requestLayout();
                holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (v != null) {
                            if (hasFocus) {
                                v.setBackgroundResource(R.drawable.iv_search_btn_f);
                            } else {
                                v.setBackgroundResource(R.drawable.iv_search_btn);
                            }
                        }
                    }
                });
                break;

            case 32:
            case 37:
                params = holder.itemView.getLayoutParams();
                params.width = AutoSizeUtils.dp2px(mContext, 160);
                params.height = AutoSizeUtils.dp2px(mContext, 70);
                holder.itemView.setLayoutParams(params);
                holder.itemView.requestLayout();
                holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (v != null) {
                            if (hasFocus) {
                                v.setBackgroundResource(R.drawable.iv_search_btn02_f);
                            } else {
                                v.setBackgroundResource(R.drawable.iv_search_btn02);
                            }
                        }
                    }
                });
                break;
        }

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {


        helper.setText(R.id.tv_keycode, item);
    }
}
