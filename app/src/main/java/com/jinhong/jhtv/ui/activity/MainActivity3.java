package com.jinhong.jhtv.ui.activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FragmentUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.MainIdBean;
import com.jinhong.jhtv.ui.adapter.MainTabsAdapter;
import com.jinhong.jhtv.ui.fragment.MainFragment;
import com.jinhong.jhtv.ui.fragment.ToyFragment;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.IoUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class MainActivity3 extends BaseActivity implements View.OnClickListener {


    private ArrayList<Fragment> mFragments;

    //  private AutoHorizontalScrollTextView mAstvNotify;

    private ImageView mIvSearch;
    private ImageView mIvCollection;
    private ImageView mIvRecord;


    private ImageView mIvLogo;
    private TvRecyclerView mRecyclerviewTabs;
    private ArrayList<Integer> tabsList;

    private Fragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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

    int currentPosition = 0;

    private void initView() {
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
//        mAstvNotify = (AutoHorizontalScrollTextView) findViewById(R.id.astv_notify);
        mIvSearch = (ImageView) findViewById(R.id.iv_search);

        mIvCollection = (ImageView) findViewById(R.id.iv_collection);
        mIvRecord = (ImageView) findViewById(R.id.iv_record);
        mRecyclerviewTabs = (TvRecyclerView) findViewById(R.id.recyclerview_tabs);

        mIvSearch.setOnClickListener(this);
        mIvCollection.setOnClickListener(this);
        mIvRecord.setOnClickListener(this);

        tabsList = new ArrayList<>();
        tabsList.add(R.drawable.iv_main_btn01);
        tabsList.add(R.drawable.iv_main_btn02);
        tabsList.add(R.drawable.iv_main_btn03);
        tabsList.add(R.drawable.iv_main_btn04);
        tabsList.add(R.drawable.iv_main_btn05);
        tabsList.add(R.drawable.iv_main_btn06);

        MainTabsAdapter cyLeftAdapter = new MainTabsAdapter(R.layout.widget_main_tab, tabsList);
        mRecyclerviewTabs.setAdapter(cyLeftAdapter);
        mRecyclerviewTabs.setSelection(0);
        cyLeftAdapter.bindToRecyclerView(mRecyclerviewTabs);
        FragmentUtils.add(getSupportFragmentManager(), mFragments.get(0), R.id.frame_layout);
        mRecyclerviewTabs.setOnItemListener(new TvRecyclerView.OnItemListener() {
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                //上次选中
                if (currentPosition != position) {
                    currentPosition = position;
                    mRecyclerviewTabs.setItemActivated(position);
                }

            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                currentPosition = position;
                FragmentUtils.replace(getSupportFragmentManager(), mFragments.get(position), R.id.frame_layout);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                currentPosition = position;
                mRecyclerviewTabs.setItemActivated(position);
                FragmentUtils.replace(getSupportFragmentManager(), mFragments.get(position), R.id.frame_layout);

            }
        });

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
                startActivity(CollectionAndRecordActivity2.class, bundle);
                break;
            case R.id.iv_record:
                bundle = new Bundle();
                bundle.putString("type", "record");
                startActivity(CollectionAndRecordActivity2.class, bundle);
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

}
