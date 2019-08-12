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
import com.jinhong.jhtv.ui.adapter.CyLeftAdapter;
import com.jinhong.jhtv.ui.fragment.CyFragment;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cy_drawing);
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            columnId = bundleExtra.getString("columnId", "");

        }
        initView();
        initData();


    }

    private void initView() {
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mRecyclerview = (TvRecyclerView) findViewById(R.id.recyclerview);

    }

    private void initData() {

        MutableLiveData<CategoryLeftBean> categoryLeftListBean = mCommonViewModel.getCategoryLeftListBean(columnId);
        categoryLeftListBean.observe(CategoryActivity.this, new Observer<CategoryLeftBean>() {
            @Override
            public void onChanged(@Nullable CategoryLeftBean categoryLeftBean) {
                if (categoryLeftBean != null) {

                    initData2View(categoryLeftBean);
                }

            }
        });


    }


    private void initData2View(CategoryLeftBean categoryLeftBean) {

        List<CategoryLeftBean.DataBean> data = categoryLeftBean.getData();

        CyLeftAdapter cyLeftAdapter = new CyLeftAdapter(R.layout.widget_cy_text, data);
        mRecyclerview.setAdapter(cyLeftAdapter);
        mCyFragment = new CyFragment(data.get(0).getId());
        FragmentUtils.add(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);

        mLlContainer.setBackgroundResource(R.drawable.iv_category_bg);
        mIvLogo.setImageResource(R.drawable.iv_log_edt);

        mRecyclerview.setSelection(0);
        cyLeftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mCyFragment = new CyFragment(data.get(position).getId());
                FragmentUtils.replace(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);
            }
        });

    }


}
