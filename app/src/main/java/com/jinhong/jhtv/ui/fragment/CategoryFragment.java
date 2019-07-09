package com.jinhong.jhtv.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.ui.activity.DetailActivity;
import com.jinhong.jhtv.ui.adapter.CategoryRightAdapter;
import com.jinhong.jhtv.ui.leanback.GridLayoutManagerTV;
import com.jinhong.jhtv.ui.leanback.RecyclerViewTV;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
@SuppressLint("ValidFragment")
public class CategoryFragment extends BaseFragment {
    List<CategoryItemBean> items;
    private RecyclerViewTV mRecyclerView;
    private CategoryRightAdapter mCategoryRightAdapter;

    public CategoryFragment(List<CategoryItemBean> data) {
        items = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_category, container, false);
        initView(inflate);

        return inflate;
    }

    private void initView(View view) {

        //右边内容
        mRecyclerView = (RecyclerViewTV) view.findViewById(R.id.recyclerView_right);
        GridLayoutManagerTV gridLayoutManager = new GridLayoutManagerTV(getActivity(), 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mCategoryRightAdapter = new CategoryRightAdapter(R.layout.widget_pic, items);
        mRecyclerView.setAdapter(mCategoryRightAdapter);
        mCategoryRightAdapter.bindToRecyclerView(mRecyclerView);
        initEvent();

    }

    private void initEvent() {
        mCategoryRightAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);

            }
        });

    }
}
