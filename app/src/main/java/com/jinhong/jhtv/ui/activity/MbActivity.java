package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.listener.AbstractOnItemListener;
import com.jinhong.jhtv.ui.adapter.MbAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-08
 * @description :萌宝乐园界面
 */
public class MbActivity extends BaseActivity {
    private TvRecyclerView mRecyclerView;
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
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        mMbAdapter = new MbAdapter(R.layout.widget_images, mPics);
        mRecyclerView.setAdapter(mMbAdapter);
        initEvent();
    }

    private void initEvent() {
        mRecyclerView.setOnItemListener(new AbstractOnItemListener() {
            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                toast("onItemClick:" + position);
            }
        });
    }


}
