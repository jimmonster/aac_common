package com.jinhong.jhtv.ui.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.model.CollectListBean;
import com.jinhong.jhtv.model.IsCollectBean;
import com.jinhong.jhtv.vm.viewmodel.CommonViewModel;

import java.util.HashMap;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :我的收藏适配器
 */
public class InfoListAdapter extends BaseQuickAdapter<CollectListBean.DataBean.ListBean, BaseViewHolder> {
    List<CollectListBean.DataBean.ListBean> mListBeans;
    CommonViewModel mCommonViewModel;

    public InfoListAdapter(int layoutResId, @Nullable List<CollectListBean.DataBean.ListBean> data, CommonViewModel commonViewModel) {
        super(layoutResId, data);
        mListBeans = data;
        mCommonViewModel = commonViewModel;
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectListBean.DataBean.ListBean item) {

        helper.setText(R.id.tv_name, item.getMainName());
        helper.setText(R.id.tv_type, item.getDramaType());
        helper.setText(R.id.tv_isCollection, item.getCreatetime() + "");
        helper.setText(R.id.tv_play, "播放");


        helper.getView(R.id.tv_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "播放", Toast.LENGTH_SHORT).show();

            }
        });
        TextView isCollection = helper.getView(R.id.tv_isCollection);
        HashMap<String, String> params = new HashMap<>();
        params.put("fatherId", "" + item.getFatherId());
        params.put("userId", item.getUserId());
        isCollection.setText("已收藏");


        helper.getView(R.id.tv_isCollection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(item.getFatherId(), item.getUserId(), helper.getLayoutPosition());
            }
        });


    }

    @SuppressLint("NewApi")
    private void showDialog(int fatherId, String userId, int layoutPosition) {

        Dialog mDialog = new Dialog(mContext, R.style.video_style_dialog_progress);
        mDialog.setContentView(R.layout.dialog_common);
        TextView mTvMessage = mDialog.findViewById(R.id.tv_message);
        Button mBtnSure = mDialog.findViewById(R.id.btn_sure);
        Button mBtnCancel = mDialog.findViewById(R.id.btn_cancel);
        mBtnCancel.requestFocus();
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutableLiveData<IsCollectBean> isCollectBean = mCommonViewModel.getIsCollectBean("" + fatherId, userId);
                isCollectBean.observe((LifecycleOwner) mContext, new Observer<IsCollectBean>() {
                    @Override
                    public void onChanged(@Nullable IsCollectBean isCollectBean) {
                        if (isCollectBean.getStatus() == 0) {
                            mListBeans.remove(layoutPosition);//集合移除该条
                            notifyItemRemoved(layoutPosition);//通知移除该条
                            notifyItemRangeChanged(layoutPosition, mListBeans.size() - layoutPosition);//更新适配器这条后面列表的变化
                        }
                    }
                });

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
