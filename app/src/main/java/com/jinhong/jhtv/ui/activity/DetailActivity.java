package com.jinhong.jhtv.ui.activity;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.DetailBean;
import com.jinhong.jhtv.model.IsCollectBean;
import com.jinhong.jhtv.model.UpdateCollectBean;
import com.jinhong.jhtv.ui.adapter.DetailCountAdapter;
import com.jinhong.jhtv.ui.adapter.DetailFooterAdapter;
import com.jinhong.jhtv.ui.adapter.DetailTabAdapter;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.LinearLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;
import com.jinhong.jhtv.utils.ImageUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :详情页面
 */
public class DetailActivity extends BaseActivity {

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
     * tv_info
     */
    private TextView mTvInfo1;
    private TextView mTvPlay;

    private RecyclerViewTV mRecyclerViewCount;
    private TvRecyclerView mRecyclerViewRecommend;
    //数据

    private DetailCountAdapter mDetailCountAdapter;
    private DetailFooterAdapter mDetailFooterAdapter;

    private RecyclerViewTV mRecyclerViewTabs;
    private DetailTabAdapter mDetailTabAdapter;
    private TextView mTvIsCollection;
    private LinearLayout mLlDiv;
    private String fatherId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        initView();
        initData();
    }

    private void initView() {
        mIvPoster = (ImageView) findViewById(R.id.iv_poster);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvType = (TextView) findViewById(R.id.tv_type);
        mTvUpdate = (TextView) findViewById(R.id.tv_update);
        mTvCount = (TextView) findViewById(R.id.tv_count);
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        mTvInfo1 = (TextView) findViewById(R.id.tv_info1);
        mTvPlay = (TextView) findViewById(R.id.tv_play);
        mRecyclerViewCount = (RecyclerViewTV) findViewById(R.id.recyclerView_count);
        mRecyclerViewRecommend = (TvRecyclerView) findViewById(R.id.recyclerView_recommend);

        mRecyclerViewTabs = (RecyclerViewTV) findViewById(R.id.recyclerView_tabs);
        mTvIsCollection = (TextView) findViewById(R.id.tv_isCollection);
        mLlDiv = (LinearLayout) findViewById(R.id.ll_div);


    }

    private void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            fatherId = bundleExtra.getString("fatherId", "100673");
        } else {
            fatherId = "100673";
        }


        MutableLiveData<DetailBean> detailBean = mCommonViewModel.getDetailBean(fatherId);
        detailBean.observe(this, new Observer<DetailBean>() {
            @Override
            public void onChanged(@Nullable DetailBean detailBean) {
                if (detailBean != null) {
                    initData2View(detailBean);
                }
            }
        });


    }


    @SuppressLint("DefaultLocale")
    private void initData2View(DetailBean detailBean) {
        DetailBean.DataBean data = detailBean.getData();
        ImageUtils.load(detailBean.getData().getPosterPath(), mIvPoster);
        mTvTitle.setText(detailBean.getData().getMainName());
        mTvInfo1.setText(detailBean.getData().getMainDesc());
        mTvType.setText(String.format("类型：%s", detailBean.getData().getDramaType()));
        mTvUpdate.setText(String.format("上映日期：%s", detailBean.getData().getReleaseTime()));
        mTvCount.setText(String.format("集数：%d", detailBean.getData().getSitnums()));

        //todo 先查看是否收藏，收藏点击取消收藏，否则增加收藏
        MutableLiveData<IsCollectBean> isCollectBean = mCommonViewModel.getIsCollectBean("" + data.getFatherId(), "testott11");
        isCollectBean.observe(this, new Observer<IsCollectBean>() {
            @Override
            public void onChanged(@Nullable IsCollectBean isCollectBean) {
                if (isCollectBean.getStatus() == 0) {
                    mTvIsCollection.setBackgroundResource(R.drawable.selector_collection_yes);

                } else {
                    mTvIsCollection.setBackgroundResource(R.drawable.selector_collection_no);

                    mTvIsCollection.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            MutableLiveData<UpdateCollectBean> updateCollectBean = mCommonViewModel.updateCollectBean("" + data.getFatherId(), "testott11", data.getMainName(), data.getDramaType());

                            updateCollectBean.observe(DetailActivity.this, new Observer<UpdateCollectBean>() {
                                @Override
                                public void onChanged(@Nullable UpdateCollectBean updateCollectBean) {
                                    if (updateCollectBean.getStatus() == 0) {
                                        mTvIsCollection.setBackgroundResource(R.drawable.selector_collection_yes);
                                    } else {
                                        mTvIsCollection.setBackgroundResource(R.drawable.selector_collection_no);

                                    }

                                }
                            });
                        }
                    });
                }
            }
        });


        //集数
        List<DetailBean.DataBean.ChildVosBean> childVos = data.getChildVos();
        mRecyclerViewCount.setLayoutManager(new GridLayoutManagerTV(this, 10));
        mDetailCountAdapter = new DetailCountAdapter(R.layout.widget_textview_count, childVos);
        mRecyclerViewCount.setAdapter(mDetailCountAdapter);
        mDetailCountAdapter.bindToRecyclerView(mRecyclerViewCount);
        mRecyclerViewCount.setOnItemClickListener(new RecyclerViewTV.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
                //todo 跳转到播放页面
                jump2VideoActivity(data, position, childVos);

            }
        });
        mTvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 跳转到播放页面,先记录下观影记录
                jump2VideoActivity(data, 0, childVos);
            }
        });

        //推荐海报
        mDetailFooterAdapter = new DetailFooterAdapter(R.layout.widget_item_detail, data.getPosterVoList());
        mRecyclerViewRecommend.setAdapter(mDetailFooterAdapter);
//        mRecyclerViewCount.setDefaultSelect(0);
        mDetailFooterAdapter.bindToRecyclerView(mRecyclerViewRecommend);
        mDetailFooterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //todo 跳转到当前详情页面，并结束当前详情页面
                int fatherId = detailBean.getData().getPosterVoList().get(position).getFatherId();
                Bundle bundle = new Bundle();
                bundle.putString("fatherId", "" + fatherId);
                startActivity(DetailActivity.class, bundle);
                finish();
            }
        });

        //tabs
        mRecyclerViewTabs.setLayoutManager(new LinearLayoutManagerTV(this, LinearLayoutManager.HORIZONTAL, false));
        mDetailTabAdapter = new DetailTabAdapter(R.layout.widget_textview_tab, childVos);
        mRecyclerViewTabs.setAdapter(mDetailTabAdapter);
//        mRecyclerViewCount.setDefaultSelect(0);
        mRecyclerViewTabs.setOnItemClickListener(new RecyclerViewTV.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
                //todo 加载对应集数

            }
        });

    }

    /**
     * 跳转到视频播放页面
     *
     * @param data     详情页参数
     * @param position 当前集数
     * @param childVos 当前对应的视频播放地址等
     */
    public void jump2VideoActivity(DetailBean.DataBean data, int position, List<DetailBean.DataBean.ChildVosBean> childVos) {
            //  String playUrl = childVos.get(position).getPlayUrl();
            mCommonViewModel.updateCollectBean("" + data.getFatherId(), "testott11", data.getMainName(), data.getDramaType());
//                Bundle bundle = new Bundle();
////                bundle.putString("url", playUrl);
////                bundle.putInt("count", childVos.size());
            startActivity(VideoActivity1.class);




    }
}
