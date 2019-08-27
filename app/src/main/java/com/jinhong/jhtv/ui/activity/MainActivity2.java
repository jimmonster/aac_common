package com.jinhong.jhtv.ui.activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.IoUtils;
import com.owen.tab.TabLayout;
import com.owen.tab.TvTabLayout;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
@Deprecated
public class MainActivity2 extends BaseActivity implements View.OnClickListener {


    private TvTabLayout mTabLayout;

    private ArrayList<Fragment> mFragments;

    //  private AutoHorizontalScrollTextView mAstvNotify;

    private ImageView mIvSearch;
    private ImageView mIvCollection;
    private ImageView mIvRecord;
    private ViewPager mViewPager;
    private LinearLayout mLlContainer;


    private ImageView mIvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
//        mAstvNotify = (AutoHorizontalScrollTextView) findViewById(R.id.astv_notify);
        mIvSearch = (ImageView) findViewById(R.id.iv_search);

        mIvCollection = (ImageView) findViewById(R.id.iv_collection);
        mIvRecord = (ImageView) findViewById(R.id.iv_record);

        mIvSearch.setOnClickListener(this);
        mIvCollection.setOnClickListener(this);
        mIvRecord.setOnClickListener(this);
        mTabLayout = (TvTabLayout) findViewById(R.id.tab_layout);

        //添加tab图片
        TabLayout.Tab tab = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2_0);
        mTabLayout.addTab(tab);

        TabLayout.Tab tab1 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2_1);

        mTabLayout.addTab(tab1);

        TabLayout.Tab tab2 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2_2);
        mTabLayout.addTab(tab2);


        TabLayout.Tab tab3 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2_3);
        mTabLayout.addTab(tab3);

        TabLayout.Tab tab4 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2_4);
        mTabLayout.addTab(tab4);

        TabLayout.Tab tab5 = mTabLayout.newTab().setCustomView(R.layout.tab_layout_item2_5);

        mTabLayout.addTab(tab5);

        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());

        mTabLayout.selectTab(0);
        mTabLayout.requestFocus();
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
                Bundle bundle = new Bundle();
                bundle.putString("type", "collection");
                startActivity(CollectionAndRecordActivity.class, bundle);
                break;
            case R.id.iv_record:
                bundle = new Bundle();
                bundle.putString("type", "record");
                startActivity(CollectionAndRecordActivity.class, bundle);
                break;
        }
    }

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDialog.create();
        }
        mDialog.show();

    }

    public class TabSelectedListener implements TvTabLayout.OnTabSelectedListener {

        private Fragment mFragment;

        @Override
        public void onTabSelected(TvTabLayout.Tab tab) {
            tab.getView().setBackgroundResource(R.drawable.selector_main_indicator_select);
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
            tab.getView().setBackgroundResource(R.drawable.selector_main_indicator_unselect);
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
