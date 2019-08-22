package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.FragmentUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.adapter.CollectionAndRecordAdapter;
import com.jinhong.jhtv.ui.fragment.CollectionFragment;
import com.jinhong.jhtv.ui.fragment.RecordFragment;
import com.owen.tab.TvTabLayout;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏和记录页面切换
 */
public class CollectionAndRecordActivity2 extends BaseActivity {

    private TvTabLayout mTabLayout;
    private FrameLayout mFrameLayout;
    /**
     * (当前2/5页)
     */
    private TextView mTvCurrentPage;

    private ArrayList<Fragment> mFragments;
    private String mType;
    private TvRecyclerView mRecyclerviewTabs;
    private ArrayList<String> tabsList;

    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_record2);
        initData();
        initView();

    }

    private void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            mType = bundleExtra.getString("type", "collection");
        }
        //添加页面
        mFragments = new ArrayList<>();
        mFragments.add(new RecordFragment());
        mFragments.add(new CollectionFragment());
        tabsList = new ArrayList<>();
        tabsList.add("观影记录");
        tabsList.add("我的收藏");

    }

    private void initView() {
        mRecyclerviewTabs = (TvRecyclerView) findViewById(R.id.recyclerview_tabs);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);


        CollectionAndRecordAdapter collectionAndRecordAdapter = new CollectionAndRecordAdapter(R.layout.widget_collection_tab, tabsList);
        mRecyclerviewTabs.setAdapter(collectionAndRecordAdapter);
        if ("collection".equals(mType)) {
            mRecyclerviewTabs.setSelection(1);
        } else if ("record".equals(mType)) {
            mRecyclerviewTabs.setSelection(0);
        }


        collectionAndRecordAdapter.bindToRecyclerView(mRecyclerviewTabs);
        FragmentUtils.add(getSupportFragmentManager(), mFragments.get(0), R.id.frame_layout);
        mRecyclerviewTabs.setOnItemListener(new TvRecyclerView.OnItemListener() {
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                //上次选中
                if (currentPosition != position) {
                    currentPosition = position;
                    mRecyclerviewTabs.setItemActivated(position);
                }
            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                currentPosition = position;
                FragmentUtils.replace(getSupportFragmentManager(), mFragments.get(position), R.id.frame_layout);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                currentPosition = position;
                mRecyclerviewTabs.setItemActivated(position);
                FragmentUtils.replace(getSupportFragmentManager(), mFragments.get(position), R.id.frame_layout);

            }
        });
    }


}



