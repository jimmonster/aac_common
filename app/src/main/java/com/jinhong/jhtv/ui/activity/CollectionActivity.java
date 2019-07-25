package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CollectionBean;
import com.jinhong.jhtv.ui.adapter.InfoListAdapter;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏页面
 */
public class CollectionActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<CollectionBean> mInfoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        initData();
        initView();
    }

    private void initData() {
        mInfoList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            CollectionBean collectionBean = new CollectionBean();
            collectionBean.setName("标题" + i);
            collectionBean.setType("类型" + i);
            collectionBean.setIsCollect("收藏" + i);
            mInfoList.add(collectionBean);
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        InfoListAdapter infoListAdapter = new InfoListAdapter(R.layout.widget_collection, mInfoList);
        mRecyclerView.setAdapter(infoListAdapter);
        infoListAdapter.bindToRecyclerView(mRecyclerView);
        infoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast("view" + position);
            }
        });
    }
}



