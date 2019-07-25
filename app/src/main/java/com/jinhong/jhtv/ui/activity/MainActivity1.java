package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.fragment.DrawFragment;
import com.jinhong.jhtv.ui.fragment.EducationFragment;
import com.jinhong.jhtv.ui.fragment.GameFragment;
import com.jinhong.jhtv.ui.fragment.MainFragment;
import com.jinhong.jhtv.ui.fragment.ManualFragment;
import com.jinhong.jhtv.ui.fragment.ToyFragment;
import com.jinhong.jhtv.ui.views.AutoHorizontalScrollTextView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :主页界面
 */
public class MainActivity1 extends BaseActivity implements View.OnClickListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LinearLayout mLlContainer;
    private ArrayList<String> mTabs;
    private ArrayList<String> mContents;
    private ArrayList<Fragment> mFragments;
    private ImageView mIvLogo;
    /**
     * 通知栏
     */
    private AutoHorizontalScrollTextView mAstvNotify;

    private ImageView mIvSearch;
    private ImageView mIvCollection;
    private ImageView mIvRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initData();
        initView();
    }

    private void initData() {
        //分类标题
        mTabs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mTabs.add("标题" + i);
        }
        mContents = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mContents.add("内容" + i);
        }
        //添加页面
        mFragments = new ArrayList<>();
        mFragments.add(MainFragment.getInstance("MainFragment"));
        mFragments.add(ToyFragment.getInstance("ToyFragment"));
        mFragments.add(GameFragment.getInstance("GameFragment"));
        mFragments.add(ManualFragment.getInstance("ManualFragment"));
        mFragments.add(EducationFragment.getInstance("EducationFragment"));
        mFragments.add(DrawFragment.getInstance("DrawFragment"));
    }

    private void initView() {
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mAstvNotify = (AutoHorizontalScrollTextView) findViewById(R.id.astv_notify);
        mIvSearch = (ImageView) findViewById(R.id.iv_search);
        mIvCollection = (ImageView) findViewById(R.id.iv_collection);
        mIvRecord = (ImageView) findViewById(R.id.iv_record);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), mTabs, mContents, mFragments);
        mViewPager.setAdapter(viewpagerAdapter);
        mViewPager.setOffscreenPageLimit(-1);
        mTabLayout.setupWithViewPager(mViewPager);


        mIvSearch.setOnClickListener(this);
        mIvCollection.setOnClickListener(this);
        mIvRecord.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_search:
                startActivity(SearchActivity.class);
                break;
            case R.id.iv_collection:
                startActivity(CollectionActivity.class);
                break;
            case R.id.iv_record:
                startActivity(RecordActivity.class);
                break;
        }
    }
}

class ViewpagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> mTabs;
    private ArrayList<String> mContents;
    private ArrayList<Fragment> mFragmentArrayList;

    public ViewpagerAdapter(FragmentManager fm, ArrayList<String> tabs, ArrayList<String> contents, ArrayList<Fragment> fragments) {
        super(fm);
        mTabs = tabs;
        mContents = contents;
        mFragmentArrayList = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position);

    }
}
