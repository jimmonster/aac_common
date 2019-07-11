package com.jinhong.jhtv.utils;

import android.view.View;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-10
 * @description : 焦点工具类
 */
public class FocusUtils {

    /**
     * 焦点监听
     *
     * @param view
     */
    public static void onFocusChange(View view) {
        view.animate().scaleY(0.98f).scaleX(0.98f).setDuration(200).start();
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        v.animate().scaleY(0.98f).scaleX(0.98f).setDuration(200).start();

    }

    public static void selected(View v) {
        v.setBackgroundResource(R.drawable.shape_selector_border_press);
        v.animate().scaleY(1.0f).scaleX(1.0f).setDuration(200).start();

    }

}
