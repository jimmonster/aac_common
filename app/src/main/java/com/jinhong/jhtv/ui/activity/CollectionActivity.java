package com.jinhong.jhtv.ui.activity;

import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CollectListBean;
import com.jinhong.jhtv.model.DeleteRecordBean;
import com.jinhong.jhtv.ui.adapter.InfoListAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :收藏页面
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener {
    private TvRecyclerView mRecyclerView;

    /**
     * 观影记录
     */
    private TextView mTvMovieRecord;
    /**
     * 我的收藏
     */
    private TextView mTvMineCollection;
    private MutableLiveData<CollectListBean> mCollectListBean;
    /**
     * (当前2/5页)
     */
    private TextView mTvCurrentPage;

    List<CollectListBean.DataBean.ListBean> listBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        initData();
        initView();
    }

    private void initData() {
        mCollectListBean = mCommonViewModel.getCollectListBean("testott11", "1", "200");
    }

    private void initView() {
        mTvMovieRecord = (TextView) findViewById(R.id.tv_movie_record);
        mTvMovieRecord.setOnClickListener(this);
        if (mTvMovieRecord.isSelected()) {
            startActivity(RecordActivity.class);
            finish();
        }
        mTvMineCollection = (TextView) findViewById(R.id.tv_mine_collection);
        mTvCurrentPage = (TextView) findViewById(R.id.tv_current_page);
        mTvMineCollection.setOnClickListener(this);
        mTvMineCollection.setSelected(true);
        mTvMineCollection.requestFocus();
        mRecyclerView = (TvRecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setSelection(0);
        listBeans = new ArrayList<>();
        InfoListAdapter infoListAdapter = new InfoListAdapter(R.layout.widget_collection, listBeans);
        mRecyclerView.setAdapter(infoListAdapter);
        infoListAdapter.bindToRecyclerView(mRecyclerView);
        mCollectListBean.observe(this, new Observer<CollectListBean>() {
            @Override
            public void onChanged(@Nullable CollectListBean collectListBean) {
                if (collectListBean != null) {

                    listBeans = collectListBean.getData().getList();
                    int size = collectListBean.getData().getSize();
                    infoListAdapter.setNewData(listBeans);
                    //当前页数/总页数
                    String format = String.format("(共%s条)", size);
                    mTvCurrentPage.setText(format);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_movie_record:
                startActivity(RecordActivity.class);
                finish();

                break;
            case R.id.tv_mine_collection:
                break;
        }
    }


    private void showDialog(InfoListAdapter infoListAdapter, List<CollectListBean.DataBean.ListBean> listBeans, int layoutPosition) {
        String fatherId = "" + listBeans.get(layoutPosition).getFatherId();
        String userId = listBeans.get(layoutPosition).getUserId();
        Dialog mDialog = new Dialog(this, R.style.video_style_dialog_progress);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDialog.create();
        }
        mDialog.show();

    }
}



