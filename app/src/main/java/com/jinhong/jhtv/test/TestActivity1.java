package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity1 extends BaseActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }
}