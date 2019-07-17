package com.jinhong.jhtv.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-16
 * @description :
 */
public class FocusImageView extends android.support.v7.widget.AppCompatImageView {
    public FocusImageView(Context context) {
        this(context, null);
    }

    public FocusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

        if (gainFocus) {
            setBackgroundResource(R.drawable.shape_selector_border_press);
            animate().scaleY(1.1f).scaleX(1.1f).setDuration(200).start();
        } else {
            setBackgroundResource(R.drawable.shape_selector_border_normal);
            animate().scaleY(1.0f).scaleX(1.0f).setDuration(200).start();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


}
