package com.jinhong.jhtv.ui.fragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.model.SingleCollectBean;
import com.jinhong.jhtv.ui.activity.CategoryActivity;
import com.jinhong.jhtv.ui.activity.DetailActivity;
import com.jinhong.jhtv.ui.adapter.ToyVirtualAdapter;
import com.jinhong.jhtv.utils.AutoSizeUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :亲子玩具页面
 */
public class ToyFragment extends BaseFragment {

    private String dataType;//activity传递过来的分类数据
    private RecyclerView recyclerView;
    private MutableLiveData<MainListBean> mMainListBean;
    private String mColumnId;


    public ToyFragment getInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("DATA", s);
        setArguments(bundle);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {
        //获取到activity传递过来的数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            mColumnId = bundle.getString("DATA");
            mMainListBean = mCommonViewModel.getMainListBean(mColumnId);
        }
        //10010


    }

    @Override
    protected void initView(View inflate) {
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

//        layoutManager.setReverseLayout(true);//等比划分

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(AutoSizeUtils.dp2px(getActivity(), 13), AutoSizeUtils.dp2px(getActivity(), 14), AutoSizeUtils.dp2px(getActivity(), 13), AutoSizeUtils.dp2px(getActivity(), 14));
            }
        });


        mMainListBean.observe(this, new Observer<MainListBean>() {
            @Override
            public void onChanged(@Nullable MainListBean mainListBean) {
                try {
                    setToyAdapter(layoutManager, mainListBean);
                } catch (Exception e) {
                    LogUtils.e(e);
                }
            }
        });


    }

    private void setToyAdapter(VirtualLayoutManager layoutManager, MainListBean mainListBean) {
        List<MainListBean.DataBean.PosterVosBean> posterVos = mainListBean.getData().getPosterVos();
        int size = posterVos.size();
        final List<LayoutHelper> helpers = new LinkedList<>();

//网格布局
        final GridLayoutHelper gridLayoutHelper0 = new GridLayoutHelper(2);

        gridLayoutHelper0.setItemCount(2);

        final GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(4);

        gridLayoutHelper1.setItemCount(8);

        helpers.add(gridLayoutHelper0);

        helpers.add(gridLayoutHelper1);

        layoutManager.setLayoutHelpers(helpers);
        Collections.sort(posterVos, (o1, o2) -> Integer.parseInt(o1.getPosterId().substring(3)) - Integer.parseInt(o2.getPosterId().substring(3)));
        ToyVirtualAdapter toyVirtualAdapter = new ToyVirtualAdapter(getContext(), layoutManager, mainListBean);
        recyclerView.setAdapter(toyVirtualAdapter);

        toyVirtualAdapter.setOnItemClickLitener(new ToyVirtualAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                try {
                    switch (position) {
                        default:
                            //todo 请求上传数据接口，并且上传
                            //单条日志上传接口
                            String nowString = TimeUtils.getNowString();
                            HashMap<String, String> params = new HashMap<>();
                            params.put("clickTime", nowString);
                            params.put("clientIp", NetworkUtils.getIPAddress(true));
                            params.put("productName", posterVos.get(position).getMainName());
                            params.put("productPage", mColumnId);
                            params.put("area", "1");
                            params.put("sort", String.valueOf(position));
                            params.put("options", "0");
                            params.put("contentId", posterVos.get(position).getPosterId());
                            params.put("contentName", posterVos.get(position).getMainName());
                            MutableLiveData<SingleCollectBean> singleCollectBean = mCommonViewModel.updateSingleCollectBean(params);
                            singleCollectBean.observe(getActivity(), new Observer<SingleCollectBean>() {
                                        @Override
                                        public void onChanged(@Nullable SingleCollectBean singleCollectBean) {

                                        }
                                    }
                            );
                            Bundle bundle1 = new Bundle();
                            bundle1.putString("fatherId", "" + posterVos.get(position).getFatherId());
                            startActivity(DetailActivity.class, bundle1);
                            break;
                        case 9:
                            Bundle bundle = new Bundle();
                            bundle.putString("columnId", mColumnId);
                            startActivity(CategoryActivity.class, bundle);
                            break;
                    }
                } catch (Exception e) {
                    LogUtils.e(e);
                }
            }
        });

    }
}


