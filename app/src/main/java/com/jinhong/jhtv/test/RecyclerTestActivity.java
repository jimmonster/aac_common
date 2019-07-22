package com.jinhong.jhtv.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.owen.tvrecyclerview.widget.TvRecyclerView;
import com.owen.tvrecyclerview.widget.VLayoutManager;

import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-22
 * @description :
 */
public class RecyclerTestActivity extends BaseActivity {

    private TvRecyclerView mRecyclerView;
    private List<DelegateAdapter.Adapter> adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_test);
        initView();

    }

    private void initView() {
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        final DelegateAdapter delegateAdapter = new DelegateAdapter((VLayoutManager)mRecyclerView.getLayoutManager(), true);
        mRecyclerView.setAdapter(delegateAdapter);
        mRecyclerView.setSelectedItemAtCentered(true);
//        mRecyclerView.setSpacingWithMargins(10, 10);

        adapters = new LinkedList<>();
        setDatas();
        delegateAdapter.setAdapters(adapters);
    }

    private void setDatas() {
        adapters.add(new TitleAdapter(this, "Title 标题"));

        {
            OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();
//            helper.setBgColor(0xffef8ba3);
            helper.setAspectRatio(3.0f);
            helper.setColWeights(new float[]{40f});
            helper.setRowWeight(40f);
//            helper.setMargin(0, 0, 0, 10);
//            helper.setPadding(10, 10, 10, 10);
            adapters.add(new SubAdapter(this, helper, 4) {
                @Override
                public void onBindViewHolder(MainViewHolder holder, int position) {
                    super.onBindViewHolder(holder, position);
                    VirtualLayoutManager.LayoutParams lp = (VirtualLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                    if (position == 0) {
                        lp.rightMargin = 1;
                    } else if (position == 1) {

                    } else if (position == 2) {
                        lp.topMargin = 1;
                        lp.rightMargin = 1;
                    }
                }
            });
        }

        adapters.add(new TitleAdapter(this, "Title 标题"));

        {
            OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();
//            helper.setBgColor(0xff876384);
//            helper.setMargin(10, 10, 10, 10);
//            helper.setPadding(100, 10, 10, 10);
            adapters.add(new SubAdapter(this, helper, 3));
        }

        {
            OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();
//            helper.setBgColor(0xff876384);
//            helper.setMargin(10, 10, 10, 10);
//            helper.setPadding(100, 10, 10, 10);
            adapters.add(new SubAdapter(this, helper, 4));
        }

        {
            GridLayoutHelper layoutHelper;
            layoutHelper = new GridLayoutHelper(8);
//            layoutHelper.setHGap(10);
//            layoutHelper.setVGap(10);
            layoutHelper.setAspectRatio(14f);
            adapters.add(new SubAdapter(this, layoutHelper, 10));
        }

        {
            GridLayoutHelper layoutHelper;
            layoutHelper = new GridLayoutHelper(2);
//            layoutHelper.setMargin(0, 10, 0, 10);
//            layoutHelper.setHGap(3);
            layoutHelper.setAspectRatio(13f);
            adapters.add(new SubAdapter(this, layoutHelper, 2));
        }

        {
            GridLayoutHelper layoutHelper;
            layoutHelper = new GridLayoutHelper(5);
//            layoutHelper.setHGap(10);
//            layoutHelper.setVGap(10);
            layoutHelper.setAspectRatio(4f);
            adapters.add(new SubAdapter(this, layoutHelper, 88));
        }
    }
    static class TitleAdapter extends DelegateAdapter.Adapter<MainViewHolder> {

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

    static class MainViewHolder extends RecyclerView.ViewHolder {

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

    static class SubAdapter extends DelegateAdapter.Adapter<MainViewHolder> {

        private Context mContext;

        private LayoutHelper mLayoutHelper;


        private VirtualLayoutManager.LayoutParams mLayoutParams;
        private int mCount = 0;


        public SubAdapter(Context context, LayoutHelper layoutHelper, int count) {
            this(context, layoutHelper, count, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        }

        public SubAdapter(Context context, LayoutHelper layoutHelper, int count, @NonNull VirtualLayoutManager.LayoutParams layoutParams) {
            this.mContext = context;
            this.mLayoutHelper = layoutHelper;
            this.mCount = count;
            this.mLayoutParams = layoutParams;
        }

        @Override
        public int getItemViewType(int position) {
            return 1;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_vlayout, parent, false));
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            // only vertical
            holder.itemView.setLayoutParams(
                    new VirtualLayoutManager.LayoutParams(mLayoutParams));
        }


        @Override
        protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {
            ((TextView) holder.itemView.findViewById(R.id.title)).setText(Integer.toString(offsetTotal));
        }

        @Override
        public int getItemCount() {
            return mCount;
        }
    }
}


  