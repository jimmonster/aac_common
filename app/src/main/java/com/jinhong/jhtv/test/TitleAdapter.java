package com.jinhong.jhtv.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-23
 * @description :
 */
 class TitleAdapter extends DelegateAdapter.Adapter<MainViewHolder> {

    private Context mContext;
    private String mTitleText;
    private LayoutHelper mLayoutHelper;

    public TitleAdapter(Context context, String titleText) {
        mContext = context;
        mTitleText = titleText;
        mLayoutHelper = new SingleLayoutHelper();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_vlayout_title, parent, false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

    }

    @Override
    protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {
        ((TextView) holder.itemView.findViewById(R.id.title)).setText(mTitleText + Integer.toString(offsetTotal));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}


 class MainViewHolder extends RecyclerView.ViewHolder {

    public static volatile int existing = 0;
    public static int createdTimes = 0;

    public MainViewHolder(View itemView) {
        super(itemView);
        createdTimes++;
        existing++;
    }

    @Override
    protected void finalize() throws Throwable {
        existing--;
        super.finalize();
    }
}