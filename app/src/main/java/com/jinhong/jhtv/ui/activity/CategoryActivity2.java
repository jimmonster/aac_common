package com.jinhong.jhtv.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;
import com.jinhong.jhtv.ui.leanback.adapter.GeneralAdapter;
import com.jinhong.jhtv.ui.leanback.adapter.LeftMenuPresenter;
import com.jinhong.jhtv.ui.leanback.adapter.RecyclerViewPresenter;
import com.jinhong.jhtv.ui.views.MainUpView;
import com.jinhong.jhtv.ui.widgets.bridge.RecyclerViewBridge;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :分类页面
 */
public class CategoryActivity2 extends BaseActivity implements RecyclerViewTV.OnItemListener {

    private RecyclerViewTV mRecyclerView;
    private RecyclerViewPresenter mRecyclerViewPresenter;
    private GeneralAdapter mGeneralAdapter;
    private RecyclerViewBridge mRecyclerViewBridge;
    private View oldView;
    private MainUpView mMainUpView1;
    private int mSavePos = 0;//默认显示位置
    Handler mFocusHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mRecyclerView.setDefaultSelect(mSavePos);
        }
    };
    Handler moreHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mRecyclerViewPresenter.addDatas(msg.arg1);
            mSavePos = mRecyclerView.getSelectPostion();
            mRecyclerView.setOnLoadMoreComplete(); // 加载更多完毕.
            mFocusHandler.sendEmptyMessageDelayed(10, 10); // 延时请求焦点.
        }
    };
    private RecyclerViewTV mRecyclerViewLeft;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);
        initView();
    }


    private void initView() {
        mMainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        mMainUpView1.setEffectBridge(new RecyclerViewBridge());
        mRecyclerView = (RecyclerViewTV) findViewById(R.id.recyclerView);
        mRecyclerViewLeft = (RecyclerViewTV) findViewById(R.id.recyclerView_left);
        // 初始化左侧菜单.
        initLeftMenu();
        testRecyclerViewGridLayout(RecyclerView.VERTICAL);

        // 注意这里，需要使用 RecyclerViewBridge 的移动边框 Bridge.
        mRecyclerViewBridge = (RecyclerViewBridge) mMainUpView1.getEffectBridge();

        mRecyclerView.setOnItemListener(this);
        // item 单击事件处理.
        mRecyclerView.setOnItemClickListener(new RecyclerViewTV.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 左侧菜单栏
     */
    private void initLeftMenu() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewLeft.setLayoutManager(layoutManager);
        mRecyclerViewLeft.setFocusable(false);
        GeneralAdapter generalAdapter = new GeneralAdapter(new LeftMenuPresenter());
        mRecyclerViewLeft.setAdapter(generalAdapter);
        mRecyclerViewLeft.setOnItemListener(new RecyclerViewTV.OnItemListener() {
            @Override
            public void onItemPreSelected(RecyclerViewTV parent, View itemView, int position) {
                // 传入 itemView也可以, 自己保存的 oldView也可以.
                mRecyclerViewBridge.setUnFocusView(itemView);
            }

            @Override
            public void onItemSelected(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.0f);
                oldView = itemView;
            }

            /**
             * 这里是调整开头和结尾的移动边框.
             */
            @Override
            public void onReviseFocusFollow(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.0f);
                oldView = itemView;
            }
        });
        mRecyclerViewLeft.setOnItemClickListener(new RecyclerViewTV.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
                // 测试.
                mRecyclerViewBridge.setFocusView(itemView, oldView, 1.0f);
                oldView = itemView;
                //侧边栏更新右边
                Toast.makeText(CategoryActivity2.this, "侧边栏更新", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 测试GridLayout.
     */
    private void testRecyclerViewGridLayout(int orientation) {
        GridLayoutManagerTV gridlayoutManager = new GridLayoutManagerTV(this, 4); // 解决快速长按焦点丢失问题.
        gridlayoutManager.setOrientation(orientation);
        mRecyclerView.setLayoutManager(gridlayoutManager);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setSelectedItemAtCentered(true); // 设置item在中间移动.
        mRecyclerViewPresenter = new RecyclerViewPresenter(25);
        mGeneralAdapter = new GeneralAdapter(mRecyclerViewPresenter);
        mRecyclerView.setAdapter(mGeneralAdapter);
        mRecyclerView.setPagingableListener(new RecyclerViewTV.PagingableListener() {
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
