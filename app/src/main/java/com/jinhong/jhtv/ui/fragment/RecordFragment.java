package com.jinhong.jhtv.ui.fragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.RecordListBean;
import com.jinhong.jhtv.ui.activity.VideoActivity1;
import com.jinhong.jhtv.ui.adapter.RecordInfoListAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-16
 * @description :观影记录fragment
 */
public class RecordFragment extends BaseFragment {

    private TvRecyclerView mRecyclerView;
    TextView mTvCurrentPage;
    private MutableLiveData<RecordListBean> mRecordListBean;
    List<RecordListBean.DataBean.ListBean> listBeans;
    private TextView mTvInstructions;
    private TextView mTvPlay;
    private TextView mTvCollection;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_collection;
    }

    @Override
    protected void initData() {
        super.initData();
        mRecordListBean = mCommonViewModel.getRecordListBean("testott11");

    }

    @Override
    protected void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mTvCurrentPage = view.findViewById(R.id.tv_current_page);
        mTvInstructions = view.findViewById(R.id.tv_instructions);
        mTvPlay = view.findViewById(R.id.tv_play);
        mTvCollection = view.findViewById(R.id.tv_collection);
        mTvPlay.setText("进度");
        mTvCollection.setText("播放");
        mTvInstructions.setText("为您保存一个月内观看时长超过半分钟的节目记录，按上下键翻页");
        listBeans = new ArrayList<>();
        RecordInfoListAdapter infoListAdapter = new RecordInfoListAdapter(R.layout.widget_record, listBeans);
        mRecyclerView.setAdapter(infoListAdapter);
        infoListAdapter.bindToRecyclerView(mRecyclerView);
        mRecordListBean.observe(this, new Observer<RecordListBean>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onChanged(@Nullable RecordListBean recordListBean) {
                if (recordListBean != null) {
                    listBeans = recordListBean.getData().getList();
                    infoListAdapter.setNewData(listBeans);
                    int size = recordListBean.getData().getSize();
                    mTvCurrentPage.setText(String.format("(共%d条)", size));
                }

            }
        });

        infoListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    default:
                        break;
                    case R.id.tv_play:
                        Intent intent = new Intent(getActivity(), VideoActivity1.class);
                        //todo 传递url给video
                        startActivity(intent);
                        break;
                }

            }
        });

    }

}
