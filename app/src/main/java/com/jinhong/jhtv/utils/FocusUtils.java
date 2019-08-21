package com.jinhong.jhtv.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  8019-07-10
 * @description : 焦点工具类
 */
public class FocusUtils {
    final private static float NORMAL = 0.95f;
    final private static float SELECT = 1.0f;
    final private static int DURATION = 800;

    /**
     * 焦点监听,不带圆角
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

    /**
     * 焦点监听,不带圆角
     *
     * @param view
     */

    public static void bindFocus(View view) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                view.setSelected(hasFocus);
            }
        });
    }


    public static void onFocusChange(View view, int selected, int unselected) {
        unselected(view, unselected);
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    if (hasFocus) {
                        selected(v, selected);
                    } else {
                        unselected(v, unselected);
                    }
                }
            }
        });
    }


    public static void onFocusChange(View view, int selected) {

        setResoure(view, selected);

//        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (v != null) {
//                    if (hasFocus) {
//                        selected(v, selected);
//                    } else {
//                        unselected(v, selected);
//                    }
//                }
//            }
//        });
    }


    public static void unselected(View v) {
        v.setSelected(false);
        v.setBackgroundResource(R.drawable.shape_selector_border_normal);

        v.animate().scaleY(SELECT).scaleX(SELECT).setDuration(DURATION).start();

    }

    public static void selected(View v) {
        v.setSelected(true);
        v.setBackgroundResource(R.drawable.shape_selector_border_press);
        v.animate().scaleY(NORMAL).scaleX(NORMAL).setDuration(DURATION).start();


    }

    public static void unselected(View v, int drawable) {
        v.setSelected(false);
        v.setBackgroundResource(drawable);

        v.animate().scaleY(SELECT).scaleX(SELECT).setDuration(DURATION).start();

    }

    public static void setResoure(View v, int drawable) {
        v.setBackgroundResource(drawable);
        v.animate().scaleY(SELECT).scaleX(SELECT).setDuration(DURATION).start();

    }


    public static void selected(View v, int drawable) {
        v.setSelected(true);
        v.setBackgroundResource(drawable);
        v.animate().scaleY(NORMAL).scaleX(NORMAL).setDuration(DURATION).start();

    }


}


