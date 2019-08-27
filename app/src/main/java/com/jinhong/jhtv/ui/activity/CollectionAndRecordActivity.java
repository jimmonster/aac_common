package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.fragment.CollectionFragment;
import com.jinhong.jhtv.ui.fragment.RecordFragment;
import com.owen.tab.TabLayout;
import com.owen.tab.TvTabLayout;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏和记录页面切换
 */
@Deprecated
public class CollectionAndRecordActivity extends BaseActivity {

    private TvTabLayout mTabLayout;
    private FrameLayout mFrameLayout;
    /**
     * (当前2/5页)
     */
    private TextView mTvCurrentPage;

    private ArrayList<Fragment> mFragments;
    private String mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_record);
        initData();
        initView();

    }

    private void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            mType = bundleExtra.getString("type", "collection");
        }
        //添加页面
        mFragments = new ArrayList<>();
        mFragments.add(new RecordFragment());
        mFragments.add(new CollectionFragment());

    }

    private void initView() {

        mTabLayout = (TvTabLayout) findViewById(R.id.tab_layout);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        mTvCurrentPage = (TextView) findViewById(R.id.tv_current_page);
        //添加tab图片
        TabLayout.Tab tab = mTabLayout.newTab().setText("观影记录");
        TabLayout.Tab tab1 = mTabLayout.newTab().setText("我的收藏");

        if ("collection".equals(mType)) {
            mTabLayout.addTab(tab, false);
            mTabLayout.addTab(tab1, true);

        } else if ("record".equals(mType)) {
            mTabLayout.addTab(tab, true);
            mTabLayout.addTab(tab1, false);
        }


        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());
        mTabLayout.requestFocus();

    }


    public class TabSelectedListener implements TvTabLayout.OnTabSelectedListener {

        private Fragment mFragment;

        @Override
        public void onTabSelected(TvTabLayout.Tab tab) {
            tab.getView().setBackgroundResource(R.drawable.selector_collection_indicator_yes);
            tab.getView().setSelected(true);
            final int position = tab.getPosition();
            mFragment = getSupportFragmentManager().findFragmentByTag(position + "");
            FragmentTransaction mFt = getSupportFragmentManager().beginTransaction();
            if (mFragment == null) {
                mFragment = mFragments.get(position);
                mFt.add(R.id.frame_layout, mFragment, String.valueOf(position));
            } else {
                mFt.attach(mFragment);
            }
            mFt.commit();

        }

        @Override
        public void onTabUnselected(TvTabLayout.Tab tab) {
            tab.getView().setBackgroundResource(R.drawable.selector_collection_indicator_no);
            tab.getView().setSelected(false);
            if (mFragment != null) {
                FragmentTransaction mFt = getSupportFragmentManager().beginTransaction();
                mFt.detach(mFragment);
                mFt.commit();
            }
        }

        @Override
        public void onTabReselected(TvTabLayout.Tab tab) {
        }
    }

}



