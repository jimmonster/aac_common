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
public class MainVirtualAdapter extends VirtualLayoutAdapter {
    private Context mContext;

    private OnItemClickLitener mOnItemClickLitener;
    private final List<MainListBean.DataBean.PosterVosBean> mPosterVos;


    //设置回调接口
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public MainVirtualAdapter(Context context, @NonNull VirtualLayoutManager layoutManager, List<MainListBean.DataBean.PosterVosBean> posterVos) {
        super(layoutManager);
        mContext = context;
        mPosterVos = posterVos;

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
                    ImageUtils.load(mPosterVos.get(position).getPosterPath(), (ImageView) holder.itemView);
                    break;

                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    layoutParams = new ViewGroup.LayoutParams(AutoSizeUtils.dp2px(mContext,225), AutoSizeUtils.dp2px(mContext,225));
                    holder.itemView.setLayoutParams(layoutParams);
                    ImageView itemView = (ImageView) holder.itemView;
                    itemView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ImageUtils.load2Circle(mPosterVos.get(position).getPosterPath(), (ImageView) holder.itemView);
                    break;

//                case 14:
//                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    layoutParams = new ViewGroup.LayoutParams(284, 56);
//                    holder.itemView.setLayoutParams(layoutParams);
//                    holder.itemView.setFocusable(false);
//                    ImageUtils.load(R.drawable.iv_qinzi_main_biaoti, (ImageView) holder.itemView);
//                    break;

                case 14:
                case 17:
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    layoutParams = new ViewGroup.LayoutParams(AutoSizeUtils.dp2px(mContext,440), AutoSizeUtils.dp2px(mContext,520));
                    holder.itemView.setLayoutParams(layoutParams);
                    ImageUtils.load(mPosterVos.get(position).getPosterPath(), (ImageView) holder.itemView);
                    break;

                case 15:
                case 16:
                case 18:
                case 19:

                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    layoutParams = new ViewGroup.LayoutParams(AutoSizeUtils.dp2px(mContext,440), AutoSizeUtils.dp2px(mContext,248));
                    holder.itemView.setLayoutParams(layoutParams);
                    ImageUtils.load(mPosterVos.get(position).getPosterPath(), (ImageView) holder.itemView);

                    break;


            }
        } catch (Exception e) {
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
