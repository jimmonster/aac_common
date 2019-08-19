package com.jinhong.jhtv.utils;

import android.app.Activity;
import android.util.TypedValue;
import android.view.View;

import com.jinhong.jhtv.R;
import com.owen.focus.FocusBorder;

/**
 * @author :  Jim
 * @date :  2019-08-19
 * @description :
 */
public class BorderUtils {
    private static volatile BorderUtils mInstance;
    private FocusBorder mFocusBorder;

    private BorderUtils(Activity activity) {
        if (null == mFocusBorder) {
            mFocusBorder = new FocusBorder.Builder()
                    .asColor()
                .borderColorRes(R.color.common_orange_dark)//边框颜色
                .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 3f)
                .shadowColorRes(R.color.color_yellow)//阴影颜色
                .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 12f)
                .build(activity);
    }
    }

    public static BorderUtils getInstance(Activity activity) {
        if (mInstance == null) {
            synchronized (BorderUtils.class) {
                if (mInstance == null) {
                    mInstance = new BorderUtils(activity);
                }
            }
        }
        return mInstance;
    }


    public void onMoveFocusBorder(View focusedView, float scale) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale));
        }
    }

    public void onMoveFocusBorder(View focusedView, float scale, float roundRadius) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale, roundRadius));
        }
    }
}
