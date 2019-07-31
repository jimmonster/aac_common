package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.fragment.DrawFragment;
import com.jinhong.jhtv.utils.FocusUtils;

/**
 * @author :  Jim
 * @date :  2019-07-29
 * @description :
 */
public class TabLayoutTest extends BaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_test);
        initView();


    }


    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        TabTestAdapter tabTestAdapter = new TabTestAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(tabTestAdapter);


        TabLayout.Tab tab = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab);
        FocusUtils.onFocusChange(tab.view, R.drawable.btn01_f, R.drawable.btn01);
        TabLayout.Tab tab1 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab1);
        FocusUtils.onFocusChange(tab1.view, R.drawable.btn01_f, R.drawable.btn01);
        TabLayout.Tab tab2 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab2);
        FocusUtils.onFocusChange(tab2.view, R.drawable.btn01_f, R.drawable.btn01);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FocusUtils.selected(tab.view, R.drawable.btn01_f);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                FocusUtils.unselected(tab.view, R.drawable.btn01);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }


    class TabTestAdapter extends FragmentStatePagerAdapter {

        public TabTestAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new DrawFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}


