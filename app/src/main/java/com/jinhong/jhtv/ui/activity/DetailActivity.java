package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.DetailBean;
import com.jinhong.jhtv.model.DetailedCard;
import com.jinhong.jhtv.ui.adapter.DetailCountAdapter;
import com.jinhong.jhtv.ui.adapter.DetailFooterAdapter;
import com.jinhong.jhtv.ui.adapter.DetailTabAdapter;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.LinearLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

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
    private TvRecyclerView mRecyclerViewRecommend;
    //数据
    private DetailedCard mDetailedCard;
    private ArrayList<String> mCount;
    private DetailCountAdapter mDetailCountAdapter;
    private DetailFooterAdapter mDetailFooterAdapter;
    private ArrayList<String> mPosters;
    private RecyclerViewTV mRecyclerViewTabs;
    private ArrayList<String> mTabs;
    private DetailTabAdapter mDetailTabAdapter;
    private TextView mTvIsCollection;
    private LinearLayout mLlDiv;
    private String fatherId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        initData();
    }

    private void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            fatherId = bundleExtra.getString("fatherId", "100673");
        } else {
            fatherId = "100673";
        }

        //todo 根据ID加载当前的电视剧

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


        MutableLiveData<DetailBean> detailBean = mCommonViewModel.getDetailBean(fatherId);
        detailBean.observe(this, new Observer<DetailBean>() {
            @Override
            public void onChanged(@Nullable DetailBean detailBean) {
                if (detailBean != null) {

                    log(detailBean.getMsg());

                    initView(detailBean);
                }
            }
        });


    }


    private void initView(DetailBean detailBean) {
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
        mRecyclerViewRecommend = (TvRecyclerView) findViewById(R.id.recyclerView_recommend);

        mRecyclerViewTabs = (RecyclerViewTV) findViewById(R.id.recyclerView_tabs);
        mTvIsCollection = (TextView) findViewById(R.id.tv_isCollection);
        mLlDiv = (LinearLayout) findViewById(R.id.ll_div);

        ImageUtils.load(detailBean.getData().getPosterPath()!=null?detailBean.getData().getPosterPath():"", mIvPoster);
        mTvTitle.setText(detailBean.getData().getMainName());
        mTvInfo0.setText(detailBean.getData().getMainDesc());
        mTvType.setText(detailBean.getData().getContentType());
        mTvUpdate.setText(detailBean.getData().getReleaseTime());
        //  mTvCount.setText(detailBean.getData().getSitnums());


        DetailBean.DataBean data = detailBean.getData();
        //集数
        mRecyclerViewCount.setLayoutManager(new GridLayoutManagerTV(this, 10));
        mDetailCountAdapter = new DetailCountAdapter(R.layout.widget_textview_count, mCount);
        mRecyclerViewCount.setAdapter(mDetailCountAdapter);
        mRecyclerViewCount.setOnItemClickListener(this);
        //推荐海报
        mDetailFooterAdapter = new DetailFooterAdapter(R.layout.widget_item_detail, data.getPosterVoList());
        mRecyclerViewRecommend.setAdapter(mDetailFooterAdapter);
//        mRecyclerViewCount.setDefaultSelect(0);
        mRecyclerViewRecommend.setOnItemListener(new TvRecyclerView.OnItemListener() {
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                FocusUtils.unselected(itemView);

            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                FocusUtils.selected(itemView);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                toast(position + "位置");
            }
        });
        //tabs
        mRecyclerViewTabs.setLayoutManager(new LinearLayoutManagerTV(this, LinearLayoutManager.HORIZONTAL, false));
        mDetailTabAdapter = new DetailTabAdapter(R.layout.widget_textview_tab, mTabs);
        mRecyclerViewTabs.setAdapter(mDetailTabAdapter);
//        mRecyclerViewCount.setDefaultSelect(0);
        mRecyclerViewTabs.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
        startActivity(VideoActivity1.class);
        toast(position + "位置");

    }
}
