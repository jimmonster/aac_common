package com.jinhong.jhtv.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.utils.AutoSizeUtils;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-10
 * @description :
 */
public class ToyVirtualAdapter extends VirtualLayoutAdapter {
    private Context mContext;
    MainListBean mMainListBean;
    private OnItemClickLitener mOnItemClickLitener;


    //设置回调接口
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public ToyVirtualAdapter(Context context, @NonNull VirtualLayoutManager layoutManager, MainListBean mainListBean) {
        super(layoutManager);
        mContext = context;
        mMainListBean = mainListBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       ImageView imageView = new ImageView(mContext);
        //传入item对应的view
        imageView.setFocusable(true);

        FocusUtils.onFocusChange(imageView, R.drawable.shape_selector_border_corner_press, R.drawable.shape_selector_border_normal);
        return new BaseViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        List<MainListBean.DataBean.PosterVosBean> posterVos = mMainListBean.getData().getPosterVos();
        ImageView imageView = (ImageView) holder.itemView;
        //通过为条目设置点击事件触发回调
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickLitener.onItemClick(view, position);
                }
            });
        }

        try {


            switch (position) {
                default:
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(AutoSizeUtils.dp2px(mContext,416), AutoSizeUtils.dp2px(mContext,318));
                    holder.itemView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageUtils.load(posterVos.get(position).getPosterPath(), (ImageView) holder.itemView);
                    break;

                case 0:
                case 1:
                    layoutParams = new ViewGroup.LayoutParams(AutoSizeUtils.dp2px(mContext,858), AutoSizeUtils.dp2px(mContext,318));
                    holder.itemView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageUtils.load(posterVos.get(position).getPosterPath(), (ImageView) holder.itemView);
                    break;


                case 9:
                    layoutParams = new ViewGroup.LayoutParams(AutoSizeUtils.dp2px(mContext,416), AutoSizeUtils.dp2px(mContext,318));
                    holder.itemView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageUtils.load(R.drawable.iv_qinzi_more, (ImageView) holder.itemView);
                    break;


            }
        } catch (
                Exception e
        ) {
            LogUtils.e(e);
        }

    }


    @Override
    public int getItemCount() {
        List<LayoutHelper> helpers = getLayoutHelpers();
        if (helpers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0, size = helpers.size(); i < size; i++) {
            count += helpers.get(i).getItemCount();
        }
        return count;
    }
}
