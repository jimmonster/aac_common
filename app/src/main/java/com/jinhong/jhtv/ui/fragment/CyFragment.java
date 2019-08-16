package com.jinhong.jhtv.ui.fragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.listener.AbstractOnItemListener;
import com.jinhong.jhtv.model.ProgrammeBean;
import com.jinhong.jhtv.ui.activity.DetailActivity;
import com.jinhong.jhtv.ui.adapter.CyRightAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description : 分类页面，内容展示
 */
@SuppressLint("ValidFragment")
public class CyFragment extends BaseFragment {

    int columnId;
    private TvRecyclerView mRecyclerView;
    private CyRightAdapter mCyRightAdapter;
    private MutableLiveData<ProgrammeBean> mProgrammeBean;
    private TextView mTvPageCount;
    private List<ProgrammeBean.DataBean.ListBean> mListBeans;

    public CyFragment(int data) {
        columnId = data;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_cy;
    }

    @Override
    protected void initData() {
        super.initData();
        mProgrammeBean = mCommonViewModel.getProgrammeBean("" + columnId);

    }

    @Override
    protected void initView(View view) {
        mTvPageCount = (TextView) view.findViewById(R.id.tv_page_count);

        //右边内容
        mRecyclerView = (TvRecyclerView) view.findViewById(R.id.recyclerView_right);

        mListBeans = new ArrayList<>();
        mCyRightAdapter = new CyRightAdapter(R.layout.widget_cy_poster, mListBeans);
        mRecyclerView.setAdapter(mCyRightAdapter);
        mCyRightAdapter.bindToRecyclerView(mRecyclerView);
        mProgrammeBean.observe(getActivity(), new Observer<ProgrammeBean>() {
            @Override
            public void onChanged(@Nullable ProgrammeBean programmeBean) {
                if (programmeBean != null) {
                    mListBeans = programmeBean.getData().getList();
                    mCyRightAdapter.setNewData(mListBeans);
                    mTvPageCount.setText(String.format("共%d条", mListBeans.size()));
                }
            }
        });
        mRecyclerView.setOnItemListener(new AbstractOnItemListener() {
            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                int fatherId = mListBeans.get(position).getFatherId();
                Bundle bundle = new Bundle();
                bundle.putString("fatherId", "" + fatherId);
                startActivity(DetailActivity.class, bundle);
            }
        });


    }


}
