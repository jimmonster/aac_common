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
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.model.SingleCollectBean;
import com.jinhong.jhtv.ui.activity.DetailActivity;
import com.jinhong.jhtv.ui.adapter.MainVirtualAdapter;
import com.jinhong.jhtv.utils.AutoSizeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-20
 * @description :主页对应的fragment页面
 */
public class MainFragment extends BaseFragment {

    private String dataType;//activity传递过来的分类数据
    private RecyclerView recyclerView;
    private ArrayList<String> mContents;

    private MutableLiveData<MainListBean> mMainListBean;
    private String mData;


    public MainFragment getInstance(String s) {
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
            mData = bundle.getString("DATA");
            mMainListBean = mCommonViewModel.getMainListBean(mData);
        }


    }

    @Override
    protected void initView(View inflate) {


        /**************/
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
                if (mainListBean != null) {
                    log(mainListBean.getMsg());

                    setMainAdapter(layoutManager, mainListBean);
                }
            }
        });


/**************/


    }

    private void setMainAdapter(VirtualLayoutManager layoutManager, MainListBean mainListBean) {
        int size = mainListBean.getData().getPosterVos().size();
        final List<LayoutHelper> helpers = new LinkedList<>();
        //网格布局
        final GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);

        gridLayoutHelper.setItemCount(2);

//网格布局
        final GridLayoutHelper gridLayoutHelper0 = new GridLayoutHelper(4);

        gridLayoutHelper0.setItemCount(4);

//网格布局
        final GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(6);
        gridLayoutHelper1.setItemCount(6);

//1+N布局
        // OnePlusNLayoutHelperEx onePlusNLayoutHelperEx = new OnePlusNLayoutHelperEx(5);
////标题
//        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
//        linearLayoutHelper.setItemCount(1);


//悬浮布
//        FixLayoutHelper layoutHelper = new FixLayoutHelper(80, 80);
        //流式布局
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(4);
        staggeredGridLayoutHelper.setPadding(0, 0, 0, 0);
        staggeredGridLayoutHelper.setGap(0);
        staggeredGridLayoutHelper.setItemCount(6);

//网格布局
        final GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(4);
        gridLayoutHelper2.setItemCount(4);

//按照顺序添加类型条目布局
        helpers.add(gridLayoutHelper);
        helpers.add(gridLayoutHelper0);
        helpers.add(gridLayoutHelper1);
        //  helpers.add(linearLayoutHelper);
        helpers.add(staggeredGridLayoutHelper);
        helpers.add(gridLayoutHelper2);

        layoutManager.setLayoutHelpers(helpers);

        List<MainListBean.DataBean.PosterVosBean> posterVos = mainListBean.getData().getPosterVos();
        try {
            Collections.sort(posterVos, (o1, o2) -> Integer.parseInt(o1.getPosterId().substring(3)) - Integer.parseInt(o2.getPosterId().substring(3)));
        } catch (Exception e) {
            LogUtils.e(e);
        }
        MainVirtualAdapter mainVirtualAdapter = new MainVirtualAdapter(getContext(), layoutManager, posterVos);

        recyclerView.setAdapter(mainVirtualAdapter);
        mainVirtualAdapter.setOnItemClickLitener(new MainVirtualAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                MainListBean.DataBean.PosterVosBean posterVosBean = mainListBean.getData().getPosterVos().get(position);

                //todo 请求上传数据接口，并且上传
                //单条日志上传接口
                String nowString = TimeUtils.getNowString();
                HashMap<String, String> params = new HashMap<>();

                params.put("clickTime", nowString);
                params.put("clientIp", NetworkUtils.getIPAddress(true));
                params.put("productName", posterVosBean.getMainName());
                params.put("productPage", mData);
                params.put("area", String.valueOf(posterVosBean.getFatherId()));
                params.put("sort", String.valueOf(position));
                params.put("options", "0");
                params.put("contentId", posterVosBean.getPosterId());
                params.put("contentName", posterVosBean.getMainName());
                MutableLiveData<SingleCollectBean> singleCollectBean = mCommonViewModel.updateSingleCollectBean(params);
                singleCollectBean.observe(getActivity(), new Observer<SingleCollectBean>() {
                    @Override
                    public void onChanged(@Nullable SingleCollectBean singleCollectBean) {

                    }
                });


                Bundle bundle = new Bundle();
                bundle.putString("fatherId", "" + posterVosBean.getFatherId());
                startActivity(DetailActivity.class, bundle);
//                toast(position+"posterVosBean.getPosterId():"+posterVosBean.getPosterId());
            }
        });


    }


}


