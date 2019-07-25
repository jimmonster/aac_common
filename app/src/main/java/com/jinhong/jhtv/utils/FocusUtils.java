package com.jinhong.jhtv.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-10
 * @description : 焦点工具类
 */
public class FocusUtils {
    final private static float NORMAL = 0.98f;
    final private static float SELECT = 1.0f;
    final private static int DURATION = 200;

    /**
     * 焦点监听
     *
     * @param view
     */

    public static void onFocusChange(View view) {

        view.setBackgroundResource(R.drawable.shape_selector_border_normal);
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    if (hasFocus) {
                        selected(v);
                    } else {
                        unselected(v);
                    }
                }
            }
        });
    }


    public static void unselected(View v) {

        v.setBackgroundResource(R.drawable.shape_selector_border_normal);

        v.animate().scaleY(SELECT).scaleX(SELECT).setDuration(DURATION).start();

    }

    public static void selected(View v) {
        v.setBackgroundResource(R.drawable.shape_selector_border_press);
        v.animate().scaleY(NORMAL).scaleX(NORMAL).setDuration(DURATION).start();


    }

    public static void unselected(View v, int drawable) {

        v.setBackgroundResource(drawable);

        v.animate().scaleY(SELECT).scaleX(SELECT).setDuration(DURATION).start();

    }

    public static void selected(View v, int drawable) {
        v.setBackgroundResource(drawable);
        v.animate().scaleY(NORMAL).scaleX(NORMAL).setDuration(DURATION).start();

    }


}


