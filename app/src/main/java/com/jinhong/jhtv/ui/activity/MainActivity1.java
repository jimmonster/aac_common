package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.fragment.MainFragment;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :主页界面
 */
public class MainActivity1 extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LinearLayout mLlContainer;
    private ArrayList<String> mTabs;
    private ArrayList<String> mContents;

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
            mTabs.add("标题"+i);
        }
        mContents = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mContents.add("内容"+i);
        }
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), mTabs,mContents);
        mViewPager.setAdapter(viewpagerAdapter);
        mViewPager.setOffscreenPageLimit(viewpagerAdapter.getCount());
        mTabLayout.setupWithViewPager(mViewPager);

    }



}

class  ViewpagerAdapter extends FragmentStatePagerAdapter{
    private ArrayList<String> mTabs;
    private ArrayList<String> mContents;

    public ViewpagerAdapter(FragmentManager fm,ArrayList<String> tabs,ArrayList<String> contents) {
        super(fm);
        mTabs=tabs;
        mContents=contents;
    }


    @Override
    public Fragment getItem(int i) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("mainData",mContents);
        mainFragment.setArguments(bundle);
        return mainFragment;
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
