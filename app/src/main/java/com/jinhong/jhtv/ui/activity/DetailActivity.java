package com.jinhong.jhtv.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
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
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;
import com.jinhong.jhtv.ui.leanback.adapter.GeneralAdapter;
import com.jinhong.jhtv.ui.leanback.adapter.RecyclerViewPresenter;
import com.jinhong.jhtv.ui.views.MainUpView;
import com.jinhong.jhtv.ui.widgets.bridge.RecyclerViewBridge;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :详情页面
 */
public class DetailActivity extends BaseActivity implements RecyclerViewTV.OnItemListener {
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
    private RecyclerViewTV mRecyclerViewFooter;
    private DetailCountAdapter mDetailCountAdapter;
    private DetailCountBean mDetailCountBean;
    private DetailFooterBean mDetailFooterBean;
    private DetailFooterAdapter mDetailFooterAdapter;

    private RecyclerViewPresenter mRecyclerViewPresenter;
    private GeneralAdapter mGeneralAdapter;
    private RecyclerViewBridge mRecyclerViewBridge;
    private View oldView;
    private MainUpView mMainUpView1;
    private int mSavePos = 0;//默认显示位置
    Handler mFocusHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mRecyclerViewFooter.setDefaultSelect(mSavePos);
        }
    };
    Handler moreHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mRecyclerViewPresenter.addDatas(msg.arg1);
            mSavePos = mRecyclerViewFooter.getSelectPostion();
            mRecyclerViewFooter.setOnLoadMoreComplete(); // 加载更多完毕.
            mFocusHandler.sendEmptyMessageDelayed(10, 10); // 延时请求焦点.
        }
    };


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
        mMainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        mMainUpView1.setEffectBridge(new RecyclerViewBridge());
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

      /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewFooter.setLayoutManager(linearLayoutManager);
        mDetailFooterAdapter = new DetailFooterAdapter(R.layout.widget_images, mDetailFooterBean.getPics());
        mRecyclerViewFooter.setAdapter(mDetailFooterAdapter);
        mDetailFooterAdapter.bindToRecyclerView(mRecyclerViewFooter);*/
        //底部显示的推送内容
        mRecyclerViewFooter = (RecyclerViewTV) findViewById(R.id.recyclerView_footer);
        testRecyclerViewGridLayout(RecyclerView.VERTICAL);

        // 注意这里，需要使用 RecyclerViewBridge 的移动边框 Bridge.
        mRecyclerViewBridge = (RecyclerViewBridge) mMainUpView1.getEffectBridge();

        mRecyclerViewFooter.setOnItemListener(this);
        // item 单击事件处理.
        mRecyclerViewFooter.setOnItemClickListener(new RecyclerViewTV.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }
        });

        ImageUtils.load(mDetailFooterBean.getPics().get(0), mIvPoster);


        initEvent();

    }

    /**
     * 测试GridLayout.
     */
    private void testRecyclerViewGridLayout(int orientation) {
        GridLayoutManagerTV gridlayoutManager = new GridLayoutManagerTV(this, 4); // 解决快速长按焦点丢失问题.
        gridlayoutManager.setOrientation(orientation);
        mRecyclerViewFooter.setLayoutManager(gridlayoutManager);
        mRecyclerViewFooter.setFocusable(false);
        mRecyclerViewFooter.setSelectedItemAtCentered(true); // 设置item在中间移动.
        mRecyclerViewPresenter = new RecyclerViewPresenter(25);
        mGeneralAdapter = new GeneralAdapter(mRecyclerViewPresenter);
        mRecyclerViewFooter.setAdapter(mGeneralAdapter);
        mRecyclerViewFooter.setPagingableListener(new RecyclerViewTV.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                // 加载更多测试.
//                moreHandler.removeCallbacksAndMessages(null);
                Message msg = moreHandler.obtainMessage();
                msg.arg1 = 21;
                moreHandler.sendMessageDelayed(msg, 3000);
            }
        });
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


    }

    @Override
    public void onItemPreSelected(RecyclerViewTV parent, View itemView, int position) {
        mRecyclerViewBridge.setUnFocusView(oldView);

    }

    @Override
    public void onItemSelected(RecyclerViewTV parent, View itemView, int position) {
        mRecyclerViewBridge.setFocusView(itemView, 1.2f);
        oldView = itemView;

    }

    @Override
    public void onReviseFocusFollow(RecyclerViewTV parent, View itemView, int position) {
        mRecyclerViewBridge.setFocusView(itemView, 1.2f);
        oldView = itemView;
    }


}
