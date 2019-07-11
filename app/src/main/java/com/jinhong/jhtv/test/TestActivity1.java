package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity1 extends BaseActivity {


    private ArrayList<Integer> mList;
    private TabLayout mTablayout;
    private ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
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


        TabLayout.Tab tab = new TabLayout.Tab();
        tab.setIcon(R.drawable.selector_titles0);
        mTablayout.addTab(tab);
        mTablayout.addTab(tab);
        mTablayout.addTab(tab);
        mTablayout.addTab(tab);
        TestFragmentAdapter testFragmentAdapter = new TestFragmentAdapter();
        mViewpager.setAdapter(testFragmentAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }

    class TestFragmentAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }
}
