package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CollectionBean;
import com.jinhong.jhtv.ui.adapter.InfoListAdapter;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏页面
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener {
    private TvRecyclerView mRecyclerView;
    private ArrayList<CollectionBean> mInfoList;
    /**
     * 观影记录
     */
    private TextView mTvMovieRecord;
    /**
     * 我的收藏
     */
    private TextView mTvMineCollection;


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
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        InfoListAdapter infoListAdapter = new InfoListAdapter(R.layout.widget_collection, mInfoList);
        mRecyclerView.setAdapter(infoListAdapter);
        infoListAdapter.bindToRecyclerView(mRecyclerView);
        infoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast("view" + position);
            }
        });
        mTvMovieRecord = (TextView) findViewById(R.id.tv_movie_record);
        mTvMovieRecord.setOnClickListener(this);
        mTvMineCollection = (TextView) findViewById(R.id.tv_mine_collection);
        mTvMineCollection.setOnClickListener(this);
        mTvMineCollection.requestFocus();
        FocusUtils.onFocusChange(mTvMovieRecord, R.drawable.iv_collection_btn_f, R.drawable.iv_collection_btn_x);
        FocusUtils.onFocusChange(mTvMineCollection, R.drawable.iv_collection_btn_f, R.drawable.iv_collection_btn_x);
        //默认选中我的收藏
        mTvMineCollection.requestFocus();
        mTvMineCollection.setBackgroundResource(R.drawable.iv_collection_btn_f);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_movie_record:
                startActivity(RecordActivity.class);
                finish();

                break;
            case R.id.tv_mine_collection:
                break;
        }
    }
}



