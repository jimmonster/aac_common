package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.manager.GridLayoutManagerTv;
import com.jinhong.jhtv.ui.manager.LinearLayoutManagerTv;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-04
 * @description :
 */
public class GridListActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    private RecyclerView mRecyclerViewLeft;
    private RecyclerView mRecyclerViewRight;
    private ArrayList<String> mTabs;
    private GridLeftAdapter mGridLeftAdapter;
    private GridRightAdapter mGridRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initData();
        initView();
    }

    private void initData() {
        mTabs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mTabs.add("标题" + i);
        }
    }

    private void initView() {
        mRecyclerViewLeft = (RecyclerView) findViewById(R.id.recyclerView_left);
        mRecyclerViewRight = (RecyclerView) findViewById(R.id.recyclerView_right);
        mRecyclerViewLeft.setLayoutManager(new LinearLayoutManagerTv(this));
        mRecyclerViewRight.setLayoutManager(new GridLayoutManagerTv(this, 4));
        mGridLeftAdapter = new GridLeftAdapter(R.layout.widget_test_item, mTabs);
        mGridRightAdapter = new GridRightAdapter(R.layout.widget_item_posters, mTabs);
        mRecyclerViewRight.setAdapter(mGridRightAdapter);
        mRecyclerViewLeft.setAdapter(mGridLeftAdapter);
        mGridLeftAdapter.bindToRecyclerView(mRecyclerViewLeft);
        mGridRightAdapter.bindToRecyclerView(mRecyclerViewRight);
        initEvent();
    }

    private void initEvent() {
        mGridLeftAdapter.setOnItemClickListener(this);
        mGridRightAdapter.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(this, "view.getId():" + view.getId() + position, Toast.LENGTH_SHORT).show();

    }


    class GridLeftAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public GridLeftAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            onFocusChange(helper.itemView);
            helper.setText(R.id.tv_test, item);
        }
    }

    class GridRightAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public GridRightAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            onFocusChange(helper.itemView);
            ImageUtils.load("http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg", helper.getView(R.id.iv_pics));
        }
    }


}
