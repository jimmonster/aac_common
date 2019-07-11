package com.jinhong.jhtv.ui.widgets;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :
 */
public class GridItemDecoration extends RecyclerView.ItemDecoration {

    //X内间距
    private float xOffset;
    //Y内间距
    private float yOffset;

    public GridItemDecoration(float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager manager = (GridLayoutManager) parent.getLayoutManager();
            int spanCount = manager.getSpanCount();
            int position = parent.getChildAdapterPosition(view);
            int count = state.getItemCount();
            //开始份数(从0增加到spanCout-1份 0 1 2 ... spanCount - 1 )
            int startPer = position % spanCount;
            //结束份数(从spanCount-1递减到0份 spanCount-1 ... 2 1 0)
            int endPer = spanCount - 1 - startPer;
            //判断方向
            boolean vertival = manager.canScrollVertically();
            if (vertival) {
                //将每个间距划分成spanCount份，并求出每份的值per
                float per = xOffset / spanCount;

                boolean isTop = position < spanCount;
                outRect.left = (int)(per * startPer);
                outRect.right = (int)(per * endPer);
                outRect.top = (int)(isTop ? 0 : yOffset);
                outRect.bottom = 0;
            } else {
                //将每个间距划分成spanCount份，并求出每份的值per
                float per = yOffset / spanCount;

                outRect.left = (int)(position < spanCount ? 0 : xOffset);
                outRect.right = 0;
                outRect.top = (int)per * startPer;
                outRect.bottom = (int)per * endPer;
            }
        } else {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }
}