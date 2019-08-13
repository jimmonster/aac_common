package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity1 extends BaseActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mArrayList;
    private TextView mTv1;
    private TextView mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initData();
        initView();
    }

    private void initData() {
        mArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mArrayList.add("按键" + i);
        }
    }

    private void initView() {
        mTv1 = (TextView) findViewById(R.id.tv_1);
        mTv2 = (TextView) findViewById(R.id.tv_2);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(R.layout.widget_cy_text, mArrayList);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.bindToRecyclerView(mRecyclerView);
        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                view.setSelected(true);
                view.setPressed(true);
              //  mTv1.requestFocus();
            }
        });


    }

}

class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_cy_left, item);


    }
}