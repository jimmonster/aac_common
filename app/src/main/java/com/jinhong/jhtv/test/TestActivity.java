package com.jinhong.jhtv.test;

import android.os.Bundle;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity extends BaseActivity {


    private RecyclerViewTV mRecyclerView;
    private ArrayList<Integer> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initData();
        initView();

    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mList.add(R.drawable.iv_poster_0);
        }
    }


    private void initView() {

        mRecyclerView = (RecyclerViewTV) findViewById(R.id.recyclerView);
        mBorder.attachTo(mRecyclerView);
        TestAdapter menuAdapter = new TestAdapter(R.layout.widget_images, mList);
        mRecyclerView.setLayoutManager(new GridLayoutManagerTV(this, 3));
        mRecyclerView.setAdapter(menuAdapter);
        menuAdapter.bindToRecyclerView(mRecyclerView);
        //  mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
