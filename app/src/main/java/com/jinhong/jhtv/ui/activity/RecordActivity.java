package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.RecordListBean;
import com.jinhong.jhtv.ui.adapter.RecordInfoListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :观影记录页面
 */
public class RecordActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private List<RecordListBean.DataBean.ListBean> mInfoList;
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
        setContentView(R.layout.activity_record);
        initData();
        initView();
    }

    private void initData() {
        mInfoList = new ArrayList<>();

        MutableLiveData<RecordListBean> recordListBean = mCommonViewModel.getRecordListBean("testott11");
        recordListBean.observe(this, new Observer<RecordListBean>() {
            @Override
            public void onChanged(@Nullable RecordListBean recordListBean) {
                if (recordListBean != null) {
                    mInfoList = recordListBean.getData().getList();
                }
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecordInfoListAdapter infoListAdapter = new RecordInfoListAdapter(R.layout.widget_record, mInfoList);
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
        //默认选中我的收藏
        mTvMovieRecord.setSelected(true);
        mTvMovieRecord.requestFocus();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_movie_record:

                break;
            case R.id.tv_mine_collection:
                startActivity(CollectionActivity.class);
                finish();
                break;
        }
    }
}


