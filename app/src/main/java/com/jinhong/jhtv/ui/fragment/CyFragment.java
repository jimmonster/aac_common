package com.jinhong.jhtv.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.listener.AbstractOnItemListener;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.ui.adapter.CyRightAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description : 分类页面，内容展示
 */
@SuppressLint("ValidFragment")
public class CyFragment extends BaseFragment {

    List<CategoryItemBean> items;
    private TvRecyclerView mRecyclerView;
    private CyRightAdapter mCyRightAdapter;

    public CyFragment(List<CategoryItemBean> data) {
        items = data;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_cy, container, false);
        initView(inflate);

        return inflate;
    }

    private void initView(View view) {

        //右边内容
        mRecyclerView = (TvRecyclerView) view.findViewById(R.id.recyclerView_right);
//        mRecyclerView.addItemDecoration(new GridItemDecoration(0,0));
        mCyRightAdapter = new CyRightAdapter(R.layout.widget_cy_poster, items);
        mRecyclerView.setAdapter(mCyRightAdapter);
        initEvent();


    }

    private void initEvent() {
        mRecyclerView.setOnItemListener(new AbstractOnItemListener() {
            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {

                Toast.makeText(getActivity(), "itemView" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
