package com.jinhong.jhtv.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.DetailCountBean;
import com.jinhong.jhtv.model.DetailFooterBean;
import com.jinhong.jhtv.ui.adapter.DetailCountAdapter;
import com.jinhong.jhtv.ui.adapter.DetailFooterAdapter;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :详情页面
 */
public class DetailActivity extends BaseActivity {
    private ImageView mIvPoster;
    /**
     * 嗨，古德拜
     */
    private TextView mTvTitle;
    /**
     * 类型：搞笑/益智
     */
    private TextView mTvType;
    /**
     * 上映时间：2017年
     */
    private TextView mTvUpdate;
    /**
     * 集数：25集
     */
    private TextView mTvCount;
    /**
     * 剧情介绍
     */
    private TextView mTvIntroduce;
    private LinearLayout mLinearLayout;
    private RecyclerView mRecyclerViewCount;
    private RecyclerView mRecyclerViewFooter;
    private DetailCountAdapter mDetailCountAdapter;
    private DetailCountBean mDetailCountBean;
    private DetailFooterBean mDetailFooterBean;
    private DetailFooterAdapter mDetailFooterAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData();
        initView();
    }

    private void initData() {
        mDetailCountBean = new DetailCountBean();
        ArrayList<String> counts = new ArrayList<>();
        for (int i = 0; i < 48; i++) {
            counts.add("" + i);
        }
        mDetailCountBean.setCount(counts);
        mDetailFooterBean = new DetailFooterBean();
        ArrayList<String> pics = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pics.add("http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg");
        }
        mDetailFooterBean.setPics(pics);

    }

    private void initView() {
        mIvPoster = (ImageView) findViewById(R.id.iv_poster);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvType = (TextView) findViewById(R.id.tv_type);
        mTvUpdate = (TextView) findViewById(R.id.tv_update);
        mTvCount = (TextView) findViewById(R.id.tv_count);
        mTvIntroduce = (TextView) findViewById(R.id.tv_introduce);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mRecyclerViewCount = (RecyclerView) findViewById(R.id.recyclerView_count);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10);
        mRecyclerViewCount.setLayoutManager(gridLayoutManager);
        mDetailCountAdapter = new DetailCountAdapter(R.layout.widget_textview_count, mDetailCountBean.getCount());
        mRecyclerViewCount.setAdapter(mDetailCountAdapter);
        mDetailCountAdapter.bindToRecyclerView(mRecyclerViewCount);
        //底部显示的推送内容
        mRecyclerViewFooter = (RecyclerView) findViewById(R.id.recyclerView_footer);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewFooter.setLayoutManager(linearLayoutManager);
        mDetailFooterAdapter = new DetailFooterAdapter(R.layout.widget_images, mDetailFooterBean.getPics());
        mRecyclerViewFooter.setAdapter(mDetailFooterAdapter);
        mDetailFooterAdapter.bindToRecyclerView(mRecyclerViewFooter);

        ImageUtils.load(this, mDetailFooterBean.getPics().get(0), mIvPoster);


        initEvent();

    }

    private void initEvent() {
        mDetailCountAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerViewCount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    v.setFocusable(hasFocus);
                    if (hasFocus) {
                        v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                    } else {
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    }
                }

            }
        });

        mDetailFooterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mRecyclerViewFooter.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    v.setFocusable(hasFocus);
                    if (hasFocus) {
                        v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                    } else {
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    }
                }

            }
        });

    }


}
