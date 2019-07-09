package com.jinhong.jhtv.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CategoryBean;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.ui.adapter.CategoryLeftAdapter;
import com.jinhong.jhtv.ui.fragment.CategoryFragment;
import com.jinhong.jhtv.ui.leanback.LinearLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :分类页面
 */
public class CategoryActivity extends BaseActivity {
    private RecyclerViewTV mRecyclerViewLeft;
    private LinearLayout mLlContainer;
    private CategoryLeftAdapter mCategoryLeftAdapter;
    private CategoryBean mCategoryBean;

    private FrameLayout mFlReplaceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initData();
        initView();
    }

    private void initData() {
        mCategoryBean = new CategoryBean();

        ArrayList<String> tabsName = new ArrayList<>();
        ArrayList<CategoryItemBean> pics = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            tabsName.add("标题" + i);
        }
        mCategoryBean.setTabsName(tabsName);

        for (int i = 0; i < 10; i++) {
            CategoryItemBean categoryItemBean = new CategoryItemBean();
            categoryItemBean.setPic("http://pic2.52pk.com/files/allimg/090626/1553504U2-2.jpg");
            categoryItemBean.setTitle("内容标题" + i);
            pics.add(categoryItemBean);
        }
        mCategoryBean.setItems(pics);
    }

    private void initView() {
        //左边内容
        mRecyclerViewLeft = (RecyclerViewTV) findViewById(R.id.recyclerView_left);
        LinearLayoutManagerTV linearLayoutManager = new LinearLayoutManagerTV(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewLeft.setLayoutManager(linearLayoutManager);
        mCategoryLeftAdapter = new CategoryLeftAdapter(R.layout.widget_button_tab, mCategoryBean.getTabsName());
        mRecyclerViewLeft.setAdapter(mCategoryLeftAdapter);
        mCategoryLeftAdapter.bindToRecyclerView(mRecyclerViewLeft);

        //背景图片
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        CategoryFragment categoryFragment = new CategoryFragment(mCategoryBean.getItems());
        fragmentTransaction.add(R.id.fl_replace_fragment, categoryFragment).commit();
        initEvent();
    }

    private void initEvent() {

        mCategoryLeftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment(mCategoryBean.getItems());
                fragmentTransaction.replace(R.id.fl_replace_fragment, categoryFragment).commit();

            }
        });
        mRecyclerViewLeft.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    v.setFocusable(hasFocus);
                    if (hasFocus) {
                        v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
                    } else {
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
                    }
                }

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
