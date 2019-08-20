package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.FragmentUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CategoryLeftBean;
import com.jinhong.jhtv.model.MainIdBean;
import com.jinhong.jhtv.ui.adapter.CyLeftAdapter;
import com.jinhong.jhtv.ui.fragment.CyFragment;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.ImageUtils;
import com.jinhong.jhtv.utils.IoUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description : 二级页面,分类界面
 */
public class CategoryActivity extends BaseActivity {


    private ImageView mIvLogo;
    private TvRecyclerView mRecyclerview;
    private int mLog;
    private CyFragment mCyFragment;

    private String columnId;

    private LinearLayout mLlContainer;
    List<CategoryLeftBean.DataBean> dataBeanList;
    private MutableLiveData<CategoryLeftBean> mCategoryLeftListBean;
    private MainIdBean.DataBean mMainIdBeanData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cy_drawing);
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            columnId = bundleExtra.getString("columnId", "");

        }
        initData();
        initView();


    }

    private void initData() {
        String json = IoUtils.inputStreamToString(getResources().openRawResource(R.raw.data_main_id));
        MainIdBean mainIdBean = GsonUtil.GsonToBean(json, MainIdBean.class);
        mMainIdBeanData = mainIdBean.getData();
        mCategoryLeftListBean = mCommonViewModel.getCategoryLeftListBean(columnId);


    }

    int currentPosition = 0;


    private void initView() {
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mRecyclerview = (TvRecyclerView) findViewById(R.id.recyclerview);
        //加载对应log
        if (columnId.equals(mMainIdBeanData.getDraw())) {
            ImageUtils.load(R.drawable.iv_log_huihua, mIvLogo);
        } else if (columnId.equals(mMainIdBeanData.getManual())) {
            ImageUtils.load(R.drawable.iv_log_shougong, mIvLogo);
        } else if (columnId.equals(mMainIdBeanData.getToy())) {
            ImageUtils.load(R.drawable.iv_log_toy, mIvLogo);
        } else if (columnId.equals(mMainIdBeanData.getGame())) {
            ImageUtils.load(R.drawable.iv_log_game, mIvLogo);
        } else if (columnId.equals(mMainIdBeanData.getEducation())) {
            ImageUtils.load(R.drawable.iv_log_edt, mIvLogo);
        }


        dataBeanList = new ArrayList<>();
        CyLeftAdapter cyLeftAdapter = new CyLeftAdapter(R.layout.widget_cy_text, dataBeanList);
        mRecyclerview.setAdapter(cyLeftAdapter);
        mRecyclerview.setSelection(0);
        cyLeftAdapter.bindToRecyclerView(mRecyclerview);

        mCategoryLeftListBean.observe(CategoryActivity.this, new Observer<CategoryLeftBean>() {
            @Override
            public void onChanged(@Nullable CategoryLeftBean categoryLeftBean) {
                if (categoryLeftBean != null) {
                    dataBeanList = categoryLeftBean.getData();
                    cyLeftAdapter.setNewData(dataBeanList);
                    if (mCyFragment == null) {
                        mCyFragment = new CyFragment(CategoryActivity.this.dataBeanList.get(0).getId());
                        FragmentUtils.add(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);
                    }

                    //  mLlContainer.setBackgroundResource(R.drawable.iv_category_bg);
                }

            }
        });

        cyLeftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mCyFragment = new CyFragment(dataBeanList.get(position).getId());
                FragmentUtils.replace(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);
            }
        });

        mRecyclerview.setOnItemListener(new TvRecyclerView.OnItemListener() {
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                //上次选中
                if (currentPosition != position) {
                    currentPosition = position;
                    mRecyclerview.setItemActivated(position);
                }


            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                currentPosition = position;
                //当前选中
                mCyFragment = new CyFragment(dataBeanList.get(position).getId());
                FragmentUtils.replace(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                //点击
                toast("点击" + position);
                log("点击" + position);
            }
        });

    }


}
