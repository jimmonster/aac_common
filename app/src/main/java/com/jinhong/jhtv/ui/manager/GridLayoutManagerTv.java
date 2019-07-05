package com.jinhong.jhtv.ui.manager;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author :  Jim
 * @date :  2019-07-04
 * @description : 解决焦点抢占问题
 */
public class GridLayoutManagerTv extends android.support.v7.widget.GridLayoutManager {
    public GridLayoutManagerTv(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public GridLayoutManagerTv(Context context, int spanCount) {
        super(context, spanCount);
    }

    public GridLayoutManagerTv(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public View onInterceptFocusSearch(View focused, int direction) {
        int span = getSpanCount();
        int lastVisibleItemPos = findLastVisibleItemPosition();//最新的已显示的Item的位置
        int count = getItemCount();
        int fromPos = getPosition(focused);

        switch (direction) {
            case View.FOCUS_UP:
                fromPos = (fromPos - span);
                break;
            case View.FOCUS_DOWN:
                fromPos = (fromPos + span);
                break;
            case View.FOCUS_RIGHT:
                fromPos++;
                break;
            case View.FOCUS_LEFT:
                fromPos--;
                break;
            default:
                break;
        }
        if (fromPos < 0 || fromPos >= count) {
            return focused;
        } else {

            //如果下一个位置大于最新的已显示的item，即下一个位置的View没有显示，则滑动到那个位置，让他显示，就可以获取焦点了
            if (fromPos > lastVisibleItemPos) {
                scrollToPosition(fromPos);
                // scrollToPosition(fromPos);会导致onscroll方法被调用，又加载了数据，逻辑错误

            }
        }

        return super.onInterceptFocusSearch(focused, direction);
    }
}