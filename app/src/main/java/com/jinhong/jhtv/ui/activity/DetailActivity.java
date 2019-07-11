package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.DetailedCard;
import com.jinhong.jhtv.ui.adapter.DetailCountAdapter;
import com.jinhong.jhtv.ui.adapter.DetailFooterAdapter;
import com.jinhong.jhtv.ui.adapter.DetailTabAdapter;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.LinearLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;
import com.jinhong.jhtv.utils.IoUtils;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :详情页面
 */
public class DetailActivity extends BaseActivity implements RecyclerViewTV.OnItemClickListener {

    private ImageView mIvPoster;
    /**
     * 嗨，顾得白之奇妙生活
     */
    private TextView mTvTitle;
    /**
     * 类型：搞笑/益智
     */
    private TextView mTvType;
    /**
     * 上映时间：2019
     */
    private TextView mTvUpdate;
    /**
     * 集数：32
     */
    private TextView mTvCount;
    private LinearLayout mLlContainer;
    /**
     * 剧情介绍：
     */
    private TextView mTvInfo0;
    /**
     * tv_info
     */
    private TextView mTvInfo1;
    private TextView mTvPlay;

    private RecyclerViewTV mRecyclerViewCount;
    private RecyclerViewTV mRecyclerViewRecommend;
    //数据
    private DetailedCard mDetailedCard;
    private ArrayList<String> mCount;
    private DetailCountAdapter mDetailCountAdapter;
    private DetailFooterAdapter mDetailFooterAdapter;
    private ArrayList<String> mPosters;
    private RecyclerViewTV mRecyclerViewTabs;
    private ArrayList<String> mTabs;
    private DetailTabAdapter mDetailTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData();
        initView();
    }

    private void initData() {
        String json = IoUtils
                .inputStreamToString(getResources().openRawResource(R.raw.data_detail));
        mDetailedCard = new Gson().fromJson(json, DetailedCard.class);
        mTabs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mTabs.add(i * 10 + "-" + (i + 1) * 10);
        }
        mCount = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            mCount.add("" + i);
        }

        mPosters = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mPosters.add("http://img.ewebweb.com/uploads/20190403/14/1554273928-MGSPXDUfBJ.jpg");
        }
    }

    private void initView() {
        mIvPoster = (ImageView) findViewById(R.id.iv_poster);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvType = (TextView) findViewById(R.id.tv_type);
        mTvUpdate = (TextView) findViewById(R.id.tv_update);
        mTvCount = (TextView) findViewById(R.id.tv_count);
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        mTvInfo0 = (TextView) findViewById(R.id.tv_info0);
        mTvInfo1 = (TextView) findViewById(R.id.tv_info1);
        mTvPlay = (TextView) findViewById(R.id.tv_play);
        mRecyclerViewCount = (RecyclerViewTV) findViewById(R.id.recyclerView_count);
        mRecyclerViewRecommend = (RecyclerViewTV) findViewById(R.id.recyclerView_recommend);

        mRecyclerViewTabs = (RecyclerViewTV) findViewById(R.id.recyclerView_tabs);
        initEvent();
    }

    private void initEvent() {
        //集数
        mRecyclerViewCount.setLayoutManager(new GridLayoutManagerTV(this, 10));
        mDetailCountAdapter = new DetailCountAdapter(R.layout.widget_textview_count, mCount);
        mRecyclerViewCount.setAdapter(mDetailCountAdapter);
        mRecyclerViewCount.setOnItemClickListener(this);
        //推荐海报
        mRecyclerViewRecommend.setLayoutManager(new GridLayoutManagerTV(this, 4));
        mDetailFooterAdapter = new DetailFooterAdapter(R.layout.widget_item_poster0, mPosters);
        mRecyclerViewRecommend.setAdapter(mDetailFooterAdapter);
//        mRecyclerViewCount.setDefaultSelect(0);
        mRecyclerViewRecommend.setOnItemClickListener(this);
        //tabs
        mRecyclerViewTabs.setLayoutManager(new LinearLayoutManagerTV(this, LinearLayoutManager.HORIZONTAL, false));
        mDetailTabAdapter = new DetailTabAdapter(R.layout.widget_textview_tab, mTabs);
        mRecyclerViewTabs.setAdapter(mDetailTabAdapter);
//        mRecyclerViewCount.setDefaultSelect(0);
        mRecyclerViewTabs.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
        startActivity(VideoActivity.class);
//        toast(position + "位置");

    }


}
