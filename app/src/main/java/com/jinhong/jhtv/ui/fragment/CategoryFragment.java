package com.jinhong.jhtv.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.ui.activity.DetailActivity;
import com.jinhong.jhtv.ui.adapter.CategoryRightAdapter;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.tvrecyclerview.widget.SimpleOnItemListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
@SuppressLint("ValidFragment")
public class CategoryFragment extends BaseFragment {
    List<CategoryItemBean> items;
    private TvRecyclerView mRecyclerView;
    private CategoryRightAdapter mCategoryRightAdapter;

    public CategoryFragment(List<CategoryItemBean> data) {
        items = data;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initView(View view) {

        //右边内容
        mRecyclerView = (TvRecyclerView) view.findViewById(R.id.recyclerView_right);
        mCategoryRightAdapter = new CategoryRightAdapter(R.layout.widget_pic, items);
        mRecyclerView.setAdapter(mCategoryRightAdapter);
        initEvent();
    }

    @Override
    protected void initEvent() {
        mCategoryRightAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);

            }
        });

        mRecyclerView.setOnItemListener(new SimpleOnItemListener(){
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                FocusUtils.unselected(itemView);
            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                FocusUtils.selected(itemView);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
