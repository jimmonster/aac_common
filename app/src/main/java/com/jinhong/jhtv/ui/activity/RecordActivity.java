package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
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
import com.owen.tvrecyclerview.widget.TvRecyclerView;

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
    private MutableLiveData<RecordListBean> mRecordListBean;
    private TextView mView;
    List<RecordListBean.DataBean.ListBean> listBeans;
    /**
     * (总共1页)
     */
    private TextView mTvCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        initData();
        initView();
    }

    private void initData() {
        mRecordListBean = mCommonViewModel.getRecordListBean("testott11");
    }


    private void initView() {
        mView = (TextView) findViewById(R.id.view);
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        mTvCurrentPage = (TextView) findViewById(R.id.tv_current_page);
        mTvMovieRecord = (TextView) findViewById(R.id.tv_movie_record);
        mTvMovieRecord.setOnClickListener(this);
        mTvMineCollection = (TextView) findViewById(R.id.tv_mine_collection);

        mTvMineCollection.setOnClickListener(this);
        //默认选中观影记录
        mTvMovieRecord.setSelected(true);
        mTvMovieRecord.requestFocus();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listBeans = new ArrayList<>();
        RecordInfoListAdapter infoListAdapter = new RecordInfoListAdapter(R.layout.widget_record, listBeans);
        mRecyclerView.setAdapter(infoListAdapter);
        infoListAdapter.bindToRecyclerView(mRecyclerView);
        mRecordListBean.observe(this, new Observer<RecordListBean>() {
            @Override
            public void onChanged(@Nullable RecordListBean recordListBean) {
                if (recordListBean != null) {
                    listBeans = recordListBean.getData().getList();
                    infoListAdapter.setNewData(listBeans);
                    int size = recordListBean.getData().getSize();
                    mTvCurrentPage.setText(String.format("(共%d条)", size));

                }
            }
        });
        infoListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    default:break;
                    case R.id.tv_play:
                        Intent intent = new Intent(RecordActivity.this, VideoActivity1.class);
                        //todo 传递url给video
                        startActivity(intent);
                        break;
                }

            }
        });



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


