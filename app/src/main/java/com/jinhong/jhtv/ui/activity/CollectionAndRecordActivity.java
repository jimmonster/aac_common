package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.fragment.MainFragment;
import com.jinhong.jhtv.ui.fragment.ToyFragment;
import com.jinhong.jhtv.utils.FocusUtils;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏和记录页面切换
 */
@Deprecated
public class CollectionAndRecordActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_record);
        initData();
        initView();
    }

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new MainFragment().getInstance("10007"));
        mFragments.add(new ToyFragment().getInstance("10037"));
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout.setSelectedTabIndicator(R.drawable.selector_main_indicator);

        //添加tab图片
        TabLayout.Tab tab = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2);
        mTabLayout.addTab(tab);
        FocusUtils.onFocusChange(tab.view, R.drawable.selector_main_tab0);

        TabLayout.Tab tab1 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2);
        mTabLayout.addTab(tab1);
        FocusUtils.onFocusChange(tab1.view, R.drawable.selector_main_tab1);

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), mFragments);

        mViewPager.setAdapter(viewpagerAdapter);
        mViewPager.setOffscreenPageLimit(-1);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}



