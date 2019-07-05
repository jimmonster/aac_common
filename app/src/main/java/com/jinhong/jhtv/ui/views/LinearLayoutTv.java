package com.jinhong.jhtv.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author :  Jim
 * @date :  2019-07-05
 * @description : LinearLayout放大遮盖问题处理
 */
public class LinearLayoutTv extends LinearLayout {
    private ControlViewBringToFront mControlViewBringToFront;

    public LinearLayoutTv(Context context, AttributeSet attrs) {
        super(context, attrs);
// TODO Auto-generated constructor stub
//getChildDrawingOrder方法要求这个方法要设置成true
        setChildrenDrawingOrderEnabled(true);
        mControlViewBringToFront = new ControlViewBringToFront(this);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
// TODO Auto-generated method stub
//return super.getChildDrawingOrder(childCount, i);
        return mControlViewBringToFront.getChildDrawingOrder(childCount, i);
    }

    @Override
    public void bringChildToFront(View child) {
// TODO Auto-generated method stub
//super.bringChildToFront(child);
        mControlViewBringToFront.bringChildToFront(this, child);
    }

}

