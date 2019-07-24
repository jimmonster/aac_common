package com.jinhong.jhtv.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

        int mBorderWidth = 1;       //描边的宽度
        int mBorderColor = Color.parseColor("#ffff4444");//描边颜色
        if (mBorderWidth == 0) {
            return;
        }
        Canvas canvas = new Canvas();
        final Paint mBorderPaint = new Paint();//画刷
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setAntiAlias(true);//空心样式
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        /**
         * 坐标x：view宽度的一半 坐标y：view高度的一半 半径r：因为是view宽度的一半-border
         */
        canvas.drawCircle(v.getWidth() >> 1, v.getHeight() >> 1, (v.getWidth() >> 1), mBorderPaint);
        v.draw(canvas);

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


