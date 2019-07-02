package com.jinhong.jhtv.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class ImageUtils {

    public static void load(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .into(view);

    }

}
