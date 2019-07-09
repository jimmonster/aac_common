package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.adapter.MbAdapter;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-08
 * @description :萌宝乐园界面
 */
public class MbActivity extends BaseActivity implements RecyclerViewTV.OnItemClickListener {
    private RecyclerViewTV mRecyclerView;
    private ArrayList<Integer> mPics;
    private MbAdapter mMbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mb);
        initData();
        initView();
    }

    private void initData() {
        mPics = new ArrayList<Integer>();
        mPics.add(R.drawable.iv_baijiaxing);
        mPics.add(R.drawable.iv_gushi);
        mPics.add(R.drawable.iv_shuiqiangushi);
        mPics.add(R.drawable.iv_tonghuagushi);
        mPics.add(R.drawable.iv_yingyu);
        mPics.add(R.drawable.iv_yingyuzimu);

    }

    private void initView() {
        mRecyclerView = (RecyclerViewTV) findViewById(R.id.recyclerView);
        GridLayoutManagerTV managerTV = new GridLayoutManagerTV(this, 3);
        managerTV.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(managerTV);
        mMbAdapter = new MbAdapter(R.layout.widget_images, mPics);
        mRecyclerView.setAdapter(mMbAdapter);
        mMbAdapter.bindToRecyclerView(mRecyclerView);
        initEvent();
    }

    private void initEvent() {
        mRecyclerView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
        toast("position:" + position);
    }
}
