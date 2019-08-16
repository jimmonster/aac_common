package com.jinhong.jhtv.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.CollectListBean;
import com.jinhong.jhtv.model.DeleteRecordBean;
import com.jinhong.jhtv.ui.activity.DetailActivity;
import com.jinhong.jhtv.ui.adapter.InfoListAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-16
 * @description :我的收藏fragment
 */
public class CollectionFragment extends BaseFragment {
    private TvRecyclerView mRecyclerView;
    TextView mTvCurrentPage;
    private MutableLiveData<CollectListBean> mCollectListBean;
    List<CollectListBean.DataBean.ListBean> listBeans;
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
        mCollectListBean = mCommonViewModel.getCollectListBean("testott11", "1", "200");

    }

    @Override
    protected void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mTvCurrentPage = view.findViewById(R.id.tv_current_page);
        mTvInstructions = view.findViewById(R.id.tv_instructions);
        mTvPlay = view.findViewById(R.id.tv_play);
        mTvCollection = view.findViewById(R.id.tv_collection);
        mTvPlay.setText("播放");
        mTvCollection.setText("取消收藏");

        mTvInstructions.setText("按遥控器返回键关闭，上下键翻页");
        listBeans = new ArrayList<>();
        InfoListAdapter infoListAdapter = new InfoListAdapter(R.layout.widget_collection, listBeans);
        mRecyclerView.setAdapter(infoListAdapter);
        infoListAdapter.bindToRecyclerView(mRecyclerView);
        mCollectListBean.observe(this, new Observer<CollectListBean>() {
            @Override
            public void onChanged(@Nullable CollectListBean collectListBean) {
                if (collectListBean != null) {
                    listBeans = collectListBean.getData().getList();
                    infoListAdapter.setNewData(CollectionFragment.this.listBeans);
                    int size = collectListBean.getData().getSize();
                    mTvCurrentPage.setText(String.format("(共%d条)", size));
                }
            }
        });

        infoListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String fatherId = "" + listBeans.get(position).getFatherId();
                TextView tvIsCollection = view.findViewById(R.id.tv_isCollection);
                switch (view.getId()) {
                    default:
                        break;
                    case R.id.tv_isCollection:
                        showDialog(infoListAdapter, listBeans, position);
                        tvIsCollection.requestFocus();
                        break;
                    case R.id.tv_play:
                        Bundle bundle = new Bundle();
                        bundle.putString("fatherId", fatherId);
                        startActivity(DetailActivity.class, bundle);
                        break;
                }
            }
        });

    }

    @SuppressLint("NewApi")
    private void showDialog(InfoListAdapter infoListAdapter, List<CollectListBean.DataBean.ListBean> listBeans, int layoutPosition) {
        String fatherId = "" + listBeans.get(layoutPosition).getFatherId();
        String userId = listBeans.get(layoutPosition).getUserId();
        Dialog mDialog = new Dialog(getActivity(), R.style.video_style_dialog_progress);
        mDialog.setContentView(R.layout.dialog_common);
        TextView mTvMessage = mDialog.findViewById(R.id.tv_message);
        Button mBtnSure = mDialog.findViewById(R.id.btn_sure);
        Button mBtnCancel = mDialog.findViewById(R.id.btn_cancel);
        mBtnCancel.requestFocus();
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutableLiveData<DeleteRecordBean> deleteRecordBean = mCommonViewModel.getDeleteRecordBean(fatherId, userId);
                if (listBeans.size() > layoutPosition) {
                    log(layoutPosition);
                    listBeans.remove(layoutPosition);//集合移除该条
                    infoListAdapter.notifyItemRemoved(layoutPosition);//通知移除该条
                    infoListAdapter.notifyItemRangeChanged(layoutPosition, listBeans.size() - layoutPosition);//更新适配器这条后面列表的变化
                    //当前页数/总页数
                    String format = String.format("(共%s条)", listBeans.size());
                    mTvCurrentPage.setText(format);
                }
                mDialog.dismiss();

            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        mDialog.create();
        mDialog.show();

    }

}
