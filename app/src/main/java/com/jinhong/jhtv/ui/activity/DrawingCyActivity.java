package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.FragmentUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.listener.AbstractCyOnItemListener;
import com.jinhong.jhtv.model.CategoryBean;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.ui.adapter.CyLeftAdapter;
import com.jinhong.jhtv.ui.fragment.CyFragment;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description :亲子手工/绘画页面
 */
public class DrawingCyActivity extends BaseActivity {


    private ImageView mIvLogo;
    private TvRecyclerView mRecyclerview;
    private int mLog;
    private CyFragment mCyFragment;

    private CategoryBean mCategoryBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cy_drawing);
        initData();
        initView();


    }

    private void initData() {
        //log
        mLog = R.drawable.iv_log_shougong;


        mCategoryBean = new CategoryBean();
        ArrayList<String> tabsName = new ArrayList<>();
        ArrayList<CategoryItemBean> pics = new ArrayList<>();
        tabsName.add("全部");
        tabsName.add("明星宝贝");
        tabsName.add("超轻彩泥");
        tabsName.add("手工秀");

        mCategoryBean.setTabsName(tabsName);

        for (int i = 0; i < 20; i++) {
            CategoryItemBean categoryItemBean = new CategoryItemBean();
            categoryItemBean.setPic("http://pic2.52pk.com/files/allimg/090626/1553504U2-2.jpg");
            categoryItemBean.setTitle("内容标题" + i);
            pics.add(categoryItemBean);
        }
        mCategoryBean.setItems(pics);

    }

    private void initView() {
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mIvLogo.setImageResource(mLog);
        mRecyclerview = (TvRecyclerView) findViewById(R.id.recyclerview);
        CyLeftAdapter cyLeftAdapter = new CyLeftAdapter(R.layout.widget_cy_text, mCategoryBean.getTabsName());
        mRecyclerview.setAdapter(cyLeftAdapter);
        mCyFragment = new CyFragment(mCategoryBean.getItems());
        FragmentUtils.add(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);

        initEvent();
    }

    private void initEvent() {
        mRecyclerview.setSelection(0);
        mRecyclerview.setOnItemListener(new AbstractCyOnItemListener() {
            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                super.onItemClick(parent, itemView, position);
                mCyFragment = new CyFragment(mCategoryBean.getItems());
                toast("itemView" + position);
                FragmentUtils.replace(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);
            }
        });
    }
}
