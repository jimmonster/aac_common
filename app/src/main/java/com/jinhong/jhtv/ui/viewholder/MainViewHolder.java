package com.jinhong.jhtv.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.FocusUtils;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class MainViewHolder extends RecyclerView.ViewHolder {

    public MainViewHolder(ImageView itemView) {
        super(itemView);
        //传入item对应的view
        itemView.setFocusable(true);

        FocusUtils.onFocusChange(itemView, R.drawable.shape_selector_border_corner_press, R.drawable.shape_selector_border_normal);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}