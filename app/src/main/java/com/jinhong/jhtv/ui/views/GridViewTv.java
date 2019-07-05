package com.jinhong.jhtv.ui.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * @author :  Jim
 * @date :  2019-07-05
 * @description :
 */

public class GridViewTv extends GridView {
    private View mLastView = null;
    private int mSelectedPosition;
    /**
     *
     * @author zhanghuagang 2017.7.6
     *
     */
    public GridViewTv(Context context) {
        this(context, null);
    }

    public GridViewTv(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setChildrenDrawingOrderEnabled(true);
        setSmoothScrollbarEnabled(true);
    }

    public GridViewTv(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        super.setChildrenDrawingOrderEnabled(enabled);
    }

    public int getSelectedPosition() {
        return mSelectedPosition;
    }

    public void setSelectedPosition(int mSelectedPosition) {
        this.mSelectedPosition = mSelectedPosition;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private void zoomInView(View v){
        AnimatorSet animSet = new AnimatorSet();
        float[] values = new float[] { 1.0f  ,1.18f  };
        animSet.playTogether(ObjectAnimator.ofFloat(v, "scaleX", values),
                ObjectAnimator.ofFloat(v, "scaleY", values));
        animSet.setDuration(100).start();
    }

    private void zoomOutView(View v){
        AnimatorSet animSet = new AnimatorSet();
        float[] values = new float[] { 1.18f  ,1.0f  };
        animSet.playTogether(ObjectAnimator.ofFloat(v, "scaleX", values),
                ObjectAnimator.ofFloat(v, "scaleY", values));
        animSet.setDuration(100).start();
    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view!=null) {
            zoomInView(view);
        }
        if (view != mLastView && mLastView!=null) {
            zoomOutView(mLastView);
        }
        mLastView=view;
    }




    /**
     * 此方法用来完美觉得item放大 ，绘制顺序出现问题的
     */
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        if (this.getSelectedItemPosition() != -1) {
            if (i + this.getFirstVisiblePosition() == this.getSelectedItemPosition()) {// //这是原本要在最后一个刷新的item
                return childCount - 1;
            }
            if (i == childCount - 1) {// 这是最后一个需要刷新的item
                return this.getSelectedItemPosition() - this.getFirstVisiblePosition();
            }
        }
        return i;
    }


}