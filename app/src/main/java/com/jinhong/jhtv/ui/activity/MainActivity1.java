package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.adapter.MainTabAdapter;
import com.jinhong.jhtv.ui.leanback.AutoMeaureGridLayoutManager;
import com.jinhong.jhtv.ui.leanback.LinearLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;
import com.jinhong.jhtv.ui.views.AutoHorizontalScrollTextView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :主页界面
 */
public class MainActivity1 extends BaseActivity {
    private ImageView mIvNotice;
    private AutoHorizontalScrollTextView mTvNotice;

    private RecyclerViewTV mRecyclerViewTabs;
    private RecyclerViewTV mRecyclerViewContainer;
    private RelativeLayout mLlContainer;
    private ArrayList<Integer> mTabs;
    private ArrayList<Integer> mPics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initData();
        initView();
    }

    private void initData() {
        //
        mTabs = new ArrayList<>();
        mTabs.add(R.drawable.selector_titles0);
        mTabs.add(R.drawable.selector_titles1);
        mTabs.add(R.drawable.selector_titles2);
        mTabs.add(R.drawable.selector_titles3);
        mTabs.add(R.drawable.selector_titles4);
        mTabs.add(R.drawable.selector_titles5);

        mPics = new ArrayList<>();
        mPics.add(R.drawable.sy01);
        mPics.add(R.drawable.sy02);
        mPics.add(R.drawable.sy03);
        mPics.add(R.drawable.sy04);
        mPics.add(R.drawable.sy05);
        mPics.add(R.drawable.sy06);
        mPics.add(R.drawable.sy07);
        mPics.add(R.drawable.sy08);
        mPics.add(R.drawable.sy09);
        mPics.add(R.drawable.sy10);

    }

    private void initView() {
        mIvNotice = (ImageView) findViewById(R.id.iv_notice);
        mTvNotice = (AutoHorizontalScrollTextView) findViewById(R.id.tv_notice);
        mRecyclerViewTabs = (RecyclerViewTV) findViewById(R.id.recyclerView_tabs);
        mRecyclerViewContainer = (RecyclerViewTV) findViewById(R.id.recyclerView_container);
        mBorder.attachTo(mRecyclerViewTabs);
        mBorder.attachTo(mRecyclerViewContainer);
        initEvent();
    }

    private void initEvent() {
        mRecyclerViewTabs.setLayoutManager(new LinearLayoutManagerTV(this, LinearLayoutManager.HORIZONTAL,false));
        MainTabAdapter mainTabAdapter = new MainTabAdapter(R.layout.widget_tabs, mTabs);
        mRecyclerViewTabs.setAdapter(mainTabAdapter);
        mainTabAdapter.bindToRecyclerView(mRecyclerViewTabs);

        mRecyclerViewContainer.setLayoutManager(new AutoMeaureGridLayoutManager(this,4,LinearLayoutManager.HORIZONTAL,false));
        MainTabAdapter mainTabAdapter0 = new MainTabAdapter(R.layout.widget_images0, mPics);
        mRecyclerViewContainer.setAdapter(mainTabAdapter0);
        mainTabAdapter0.bindToRecyclerView(mRecyclerViewContainer);

    }
}
