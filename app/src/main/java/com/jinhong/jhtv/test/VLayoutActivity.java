package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.focus.FocusBorder;
import com.owen.tvrecyclerview.widget.TvRecyclerView;
import com.owen.tvrecyclerview.widget.VLayoutManager;

import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-23
 * @description :
 */
public class VLayoutActivity extends BaseActivity {
    private TvRecyclerView mRecyclerView;
    private List<DelegateAdapter.Adapter> adapters;
    private FocusBorder mFocusBorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlayout);
        initView();
    }

    private void initView() {
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        setLayout();
        final DelegateAdapter delegateAdapter = new DelegateAdapter((VLayoutManager) mRecyclerView.getLayoutManager(), true);
        mRecyclerView.setAdapter(delegateAdapter);
        mRecyclerView.setSelectedItemAtCentered(true);
        delegateAdapter.setAdapters(adapters);
        mRecyclerView.setOnItemListener(new TvRecyclerView.OnItemListener() {
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
                Log.d("VLayoutActivity", "position" + position);
                toast("VLayoutActivity position" + position);
            }
        });

    }

    private void setLayout() {
        adapters = new LinkedList<>();
        adapters.add(new TitleAdapter(this, "Title 标题"));

        {
            OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();
//            helper.setBgColor(0xffef8ba3);
            helper.setAspectRatio(3.0f);
            helper.setColWeights(new float[]{40f});
            helper.setRowWeight(40f);
//            helper.setMargin(0, 0, 0, 10);
//            helper.setPadding(10, 10, 10, 10);
            adapters.add(new SubAdapter(this, helper, 4) {
                             @Override
                             public void onBindViewHolder(MainViewHolder holder, int position) {
                                 super.onBindViewHolder(holder, position);
                                 //  holder.itemView.setFocusable(true);
                                 VirtualLayoutManager.LayoutParams lp = (VirtualLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                                 if (position == 0) {
                                     lp.rightMargin = 1;
                                 } else if (position == 1) {

                                 } else if (position == 2) {
                                     lp.topMargin = 1;
                                     lp.rightMargin = 1;
                                 }
                             }
                         }

            );
        }
    }
}