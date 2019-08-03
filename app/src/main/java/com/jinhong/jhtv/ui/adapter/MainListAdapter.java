package com.jinhong.jhtv.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class MainListAdapter extends VirtualLayoutAdapter {
    List<MainListBean.DataBean.PosterVosBean> mPosterVos;
    Context mContext;
    public MainListAdapter(@NonNull VirtualLayoutManager layoutManager, Context context, List<MainListBean.DataBean.PosterVosBean> posterVos) {
        super(layoutManager);
        mPosterVos=posterVos;
        mContext =context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(mContext);
        //加载参数
        return  null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.itemView;
        switch (position) {
            default:
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(416, 318);
                holder.itemView.setLayoutParams(layoutParams);

                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                break;

            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                layoutParams = new ViewGroup.LayoutParams(225, 225);
                holder.itemView.setLayoutParams(layoutParams);
                ImageView itemView = (ImageView) holder.itemView;
                itemView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageUtils.load2Circle(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                break;

            case 14:
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                layoutParams = new ViewGroup.LayoutParams(284, 56);
                holder.itemView.setLayoutParams(layoutParams);
                holder.itemView.setFocusable(false);
                ImageUtils.load(R.drawable.iv_qinzi_main_biaoti, (ImageView) holder.itemView);
                break;

            case 15:
            case 18:
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                layoutParams = new ViewGroup.LayoutParams(416, 520);
                holder.itemView.setLayoutParams(layoutParams);
                ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                break;


            case 16:
            case 19:
            case 20:
            case 17:
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                layoutParams = new ViewGroup.LayoutParams(416, 248);
                holder.itemView.setLayoutParams(layoutParams);
                ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);

                break;


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
