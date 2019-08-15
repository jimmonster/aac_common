package com.jinhong.jhtv.ui.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.MainIdBean;
import com.jinhong.jhtv.ui.fragment.MainFragment;
import com.jinhong.jhtv.ui.fragment.ToyFragment;
import com.jinhong.jhtv.ui.views.AutoHorizontalScrollTextView;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.IoUtils;

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
    private ArrayList<Integer> mTabs;
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
        //获取到标题栏id
        String json = IoUtils.inputStreamToString(getResources().openRawResource(R.raw.data_main_id));
        MainIdBean mainIdBean = GsonUtil.GsonToBean(json, MainIdBean.class);
        MainIdBean.DataBean data = mainIdBean.getData();
        //添加页面
        mFragments = new ArrayList<>();
        mFragments.add(new MainFragment().getInstance(data.getMain()));
        mFragments.add(new ToyFragment().getInstance(data.getToy()));
        mFragments.add(new ToyFragment().getInstance(data.getGame()));
        mFragments.add(new ToyFragment().getInstance(data.getManual()));
        mFragments.add(new ToyFragment().getInstance(data.getEducation()));
        mFragments.add(new ToyFragment().getInstance(data.getDraw()));
    }

    private void initView() {
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mAstvNotify = (AutoHorizontalScrollTextView) findViewById(R.id.astv_notify);
        mIvSearch = (ImageView) findViewById(R.id.iv_search);
        mIvSearch.requestFocus();
        mIvCollection = (ImageView) findViewById(R.id.iv_collection);
        mIvRecord = (ImageView) findViewById(R.id.iv_record);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), mFragments);


        mIvSearch.setOnClickListener(this);
        mIvCollection.setOnClickListener(this);
        mIvRecord.setOnClickListener(this);

        mTabLayout.setSelectedTabIndicator(R.drawable.selector_main_indicator);

        //添加tab图片
        TabLayout.Tab tab = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab);
        FocusUtils.onFocusChange(tab.view, R.drawable.selector_main_tab0);
        TabLayout.Tab tab1 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab1);
        FocusUtils.onFocusChange(tab1.view, R.drawable.selector_main_tab1);

        TabLayout.Tab tab2 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab2);
        FocusUtils.onFocusChange(tab2.view, R.drawable.selector_main_tab2);

        TabLayout.Tab tab3 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab3);
        FocusUtils.onFocusChange(tab3.view, R.drawable.selector_main_tab3);

        TabLayout.Tab tab4 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);
        mTabLayout.addTab(tab4);
        FocusUtils.onFocusChange(tab4.view, R.drawable.selector_main_tab4);

        TabLayout.Tab tab5 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item);

        mTabLayout.addTab(tab5);
        FocusUtils.onFocusChange(tab5.view, R.drawable.selector_main_tab5);
        mViewPager.setAdapter(viewpagerAdapter);
        mViewPager.setOffscreenPageLimit(-1);
        mTabLayout.setupWithViewPager(mViewPager);


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

    @SuppressLint("NewApi")
    @Override
    public void onBackPressed() {

        Dialog mDialog = new Dialog(this, R.style.video_style_dialog_progress);
        mDialog.setContentView(R.layout.dialog_common);
        TextView mTvMessage = mDialog.findViewById(R.id.tv_message);
        mTvMessage.setText("确定退出当前应用？");
        Button mBtnSure = mDialog.findViewById(R.id.btn_sure);
        Button mBtnCancel = mDialog.findViewById(R.id.btn_cancel);
        mBtnCancel.requestFocus();
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.exitApp();

            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDialog.dismiss();
            }
        });
        mDialog.create();
        mDialog.show();

    }


}

class ViewpagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragmentArrayList;

    public ViewpagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);

        mFragmentArrayList = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//
//        Drawable image = mActivity.getResources().getDrawable(mTabs.get(position));
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString(" ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        return "";
//
//
//    }


}
