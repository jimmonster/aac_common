package com.jinhong.jhtv.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.MainBean;
import com.jinhong.jhtv.ui.adapter.MainAdapter;
import com.jinhong.jhtv.ui.adapter.MainPicAdapter;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;

import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :主页
 */
@RuntimePermissions
public class MainActivity extends BaseActivity {

    /**
     * 2019年公告上映了
     */
    private TextView mTvNotice;
    /**
     * 07/01 18:00
     */
    private TextView mTvDate;
    private RecyclerView mRecyclerViewTabs;
    private RecyclerViewTV mVerticalGridView;
    private LinearLayout mLlContainer;
    private MainAdapter mMainAdapter;
    private MainBean mMainBean;
    private MainPicAdapter mMainPicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityPermissionsDispatcher.needsPermissionWithPermissionCheck(this);
    }

    @NeedsPermission({Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.READ_LOGS})
    void needsPermission() {
        //权限获取成功
        initData();
        initView();
    }

    @OnPermissionDenied({Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.READ_LOGS})
    void onPermissionDenied() {
        //权限获取失败
        MainActivityPermissionsDispatcher.needsPermissionWithPermissionCheck(this);
    }

    private void initData() {
        //todo 初始化假数据
        mMainBean = new MainBean();
        ArrayList<String> pics = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            titles.add("标题" + i);

        }
        for (int i = 0; i < 10; i++) {

            pics.add("http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg");
        }
        mMainBean.setImages(pics);
        mMainBean.setNotice("通知通知通知通知通知通知通知ttp://pic13.nipic.com/20110409/7119492_114440620000_");
        mMainBean.setTabsTitles(titles);


    }

    private void initView() {
        mTvNotice = (TextView) findViewById(R.id.tv_notice);
        mTvNotice.setText(mMainBean.getNotice());
        mTvDate = (TextView) findViewById(R.id.tv_date);

        mRecyclerViewTabs = (RecyclerView) findViewById(R.id.RecyclerView_tabs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewTabs.setLayoutManager(linearLayoutManager);
        mMainAdapter = new MainAdapter(R.layout.widget_button, mMainBean.getTabsTitles());
        mRecyclerViewTabs.setAdapter(mMainAdapter);
        mMainAdapter.bindToRecyclerView(mRecyclerViewTabs);

        mVerticalGridView = (RecyclerViewTV) findViewById(R.id.recyclerViewTV);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mVerticalGridView.setLayoutManager(gridLayoutManager);
        mMainPicAdapter = new MainPicAdapter(R.layout.widget_images, mMainBean.getImages());
        mVerticalGridView.setAdapter(mMainPicAdapter);
        mMainPicAdapter.bindToRecyclerView(mVerticalGridView);

        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);

        initEvent();
    }

    private void initEvent() {
        mRecyclerViewTabs.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //todo 焦点获取
                if (hasFocus) {
                    v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                } else {
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                }

            }
        });
        mMainAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getApplicationContext(), CategoryActivity2.class);
                startActivity(intent);

            }
        });

        mVerticalGridView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    v.setFocusable(hasFocus);
                    //todo 焦点获取
                    if (hasFocus) {
                        v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                    } else {
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    }
                }
            }
        });

        mMainPicAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }


}
