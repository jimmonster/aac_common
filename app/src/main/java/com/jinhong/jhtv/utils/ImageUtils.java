package com.jinhong.jhtv.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class ImageUtils {

    public static void load(String url, ImageView view) {
        Activity topActivity = ActivityUtils.getTopActivity();
        Glide.with(topActivity)
                .load(url)
                .into(view);

    }

}
