package com.jinhong.jhtv.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

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

    public static void load(int drawable, ImageView view) {
        Activity topActivity = ActivityUtils.getTopActivity();
        Glide.with(topActivity)
                .load(drawable)
                .into(view);

    }


    public static void load2Circle(int drawable, ImageView view) {
        RequestOptions options = RequestOptions.circleCropTransform();
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
//                .skipMemoryCache(true);//不做内存缓存

        Activity topActivity = ActivityUtils.getTopActivity();
        Glide.with(topActivity)
                .load(drawable)
                .apply(options)
                .into(view);

    }


    public static void load2Corners(int drawable, ImageView view) {

//设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(30);
//通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

        Activity topActivity = ActivityUtils.getTopActivity();
        Glide.with(topActivity)
                .load(drawable)
                .apply(options)
                .into(view);

    }


}
