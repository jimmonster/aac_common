package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-20
 * @description :
 */
public class BluesActivity extends BaseActivity {
    private TvRecyclerView mRecyclerviewTabs;
    private TvRecyclerView mRecyclerViewInfo;
    private ArrayList<String> mInfoCount;
    private ArrayList<String> mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blues);
        initData(48);
        initView();
    }

    private void initData(int count) {
        mTabs = new ArrayList<>();
        mInfoCount = new ArrayList<>();


        for (int i = 1; i <= count / 20; i++) {
            mTabs.add(i * 20 - 19 + "-" + i * 20);
            for (int i1 = i * 20 - 19; i1 <= i * 20; i1++) {
                mInfoCount.add("" + i1);
            }

        }
        if (count % 20 > 0) {
            mTabs.add(count / 20 * 20 + "-" + count);
            for (int i1 = count / 20 * 20; i1 <= count; i1++) {
                mInfoCount.add("" + i1);
            }
        }


    }

    private void initView() {
        mRecyclerviewTabs = (TvRecyclerView) findViewById(R.id.recyclerview_tabs);
        mRecyclerViewInfo = (TvRecyclerView) findViewById(R.id.recyclerView_info);
        TabsAdapter tabsAdapter = new TabsAdapter(R.layout.widget_textview_tab, mTabs);
        mRecyclerviewTabs.setAdapter(tabsAdapter);
        tabsAdapter.bindToRecyclerView(mRecyclerviewTabs);
        InfoAdapter infoAdapter = new InfoAdapter(R.layout.widget_textview_tab, mInfoCount);
        mRecyclerViewInfo.setAdapter(infoAdapter);
        infoAdapter.bindToRecyclerView(mRecyclerViewInfo);
    }


    class TabsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public TabsAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_count, item);
        }
    }

    class InfoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public InfoAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_count, item);
        }
    }
}
