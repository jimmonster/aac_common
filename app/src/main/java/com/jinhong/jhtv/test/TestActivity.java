package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.JhBaseActivity;
import com.jinhong.jhtv.listener.TvOnKeyListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity extends JhBaseActivity {


    private ArrayList<String> mList;
    private TvRecyclerView mRecyclerViewRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initData();
        initView();

    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add("按钮" + i);
        }
    }


    private void initView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_frameLayout);

        mRecyclerViewRight = (TvRecyclerView) findViewById(R.id.recyclerView_right);
        TestAdapter testAdapter = new TestAdapter(R.layout.widget_test_item, mList);
        mRecyclerViewRight.setAdapter(testAdapter);
        //为根布局添加监听
        ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalFocusChangeListener(this);


        testAdapter.bindToRecyclerView(mRecyclerViewRight);
        testAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(TestActivity.this, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerViewRight.setOnKeyListener(new TvOnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return super.onKey(v, keyCode, event);
            }
        });


    }
}
