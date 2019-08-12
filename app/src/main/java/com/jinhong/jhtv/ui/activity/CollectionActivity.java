package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CollectListBean;
import com.jinhong.jhtv.ui.adapter.InfoListAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏页面
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener {
    private TvRecyclerView mRecyclerView;

    /**
     * 观影记录
     */
    private TextView mTvMovieRecord;
    /**
     * 我的收藏
     */
    private TextView mTvMineCollection;
    private MutableLiveData<CollectListBean> mCollectListBean;
    /**
     * (当前2/5页)
     */
    private TextView mTvCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        initData();
        initView();
    }

    private void initData() {


        mCollectListBean = mCommonViewModel.getCollectListBean("testott11", "1", "200");
    }

    private void initView() {
        mTvMovieRecord = (TextView) findViewById(R.id.tv_movie_record);
        mTvMovieRecord.setOnClickListener(this);
        mTvMineCollection = (TextView) findViewById(R.id.tv_mine_collection);
        mTvCurrentPage = (TextView) findViewById(R.id.tv_current_page);
        mTvMineCollection.setOnClickListener(this);
        mTvMineCollection.setSelected(true);
        mTvMineCollection.requestFocus();
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        mCollectListBean.observe(this, new Observer<CollectListBean>() {
            @Override
            public void onChanged(@Nullable CollectListBean collectListBean) {
                if (collectListBean != null) {
                    List<CollectListBean.DataBean.ListBean> listBeans = collectListBean.getData().getList();
                    int pageNum = collectListBean.getData().getPageNum();
                    int pages = collectListBean.getData().getPages();


                    InfoListAdapter infoListAdapter = new InfoListAdapter(R.layout.widget_collection, listBeans);
                    mRecyclerView.setAdapter(infoListAdapter);
                    infoListAdapter.bindToRecyclerView(mRecyclerView);

                    //当前页数/总页数
                    String format = String.format("(总共%s页)", pages);
                    mTvCurrentPage.setText(format);
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
                startActivity(RecordActivity.class);
                finish();

                break;
            case R.id.tv_mine_collection:
                break;
        }
    }
}



