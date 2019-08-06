package com.jinhong.jhtv.ui.fragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.blankj.utilcode.util.LogUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;
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
            String data = bundle.getString("DATA");
        }
        mMainListBean = mCommonViewModel.getMainListBean("10007");


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
                outRect.set(13, 12, 13, 12);
            }
        });

        final List<LayoutHelper> helpers = new LinkedList<>();

//网格布局
        final GridLayoutHelper gridLayoutHelper0 = new GridLayoutHelper(4);

        gridLayoutHelper0.setItemCount(8);

//网格布局
        final GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(6);
        gridLayoutHelper1.setItemCount(6);

//1+N布局
        // OnePlusNLayoutHelperEx onePlusNLayoutHelperEx = new OnePlusNLayoutHelperEx(5);
//标题
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);

//网格布局
        final GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(4);
        gridLayoutHelper2.setItemCount(4);
//悬浮布局
//        FixLayoutHelper layoutHelper = new FixLayoutHelper(80, 80);
        //流式布局
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(4);
        staggeredGridLayoutHelper.setHGap(0);
        staggeredGridLayoutHelper.setVGap(0);
        staggeredGridLayoutHelper.setItemCount(6);

//按照顺序添加类型条目布局
        helpers.add(gridLayoutHelper0);
        helpers.add(gridLayoutHelper1);
        helpers.add(linearLayoutHelper);
        helpers.add(staggeredGridLayoutHelper);
        helpers.add(gridLayoutHelper2);


        layoutManager.setLayoutHelpers(helpers);

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
        List<MainListBean.DataBean.PosterVosBean> posterVos = mainListBean.getData().getPosterVos();
        recyclerView.setAdapter(
                new VirtualLayoutAdapter(layoutManager) {
                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ImageView imageView = new ImageView(getContext());
                        //加载参数
                        return new MainViewHolder(imageView);
                    }

                    @Override
                    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


                        ImageView imageView = (ImageView) holder.itemView;
                        try {
                            switch (position) {
                                default:
                                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(416, 318);
                                    holder.itemView.setLayoutParams(layoutParams);

                                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                    ImageUtils.load(posterVos.get(position).getHomePosterPath(), (ImageView) holder.itemView);
                                    break;

                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    layoutParams = new ViewGroup.LayoutParams(225, 225);
                                    holder.itemView.setLayoutParams(layoutParams);
                                    ImageView itemView = (ImageView) holder.itemView;
                                    itemView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    ImageUtils.load2Circle(posterVos.get(position).getHomePosterPath(), (ImageView) holder.itemView);
                                    break;

                                case 14:
                                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    layoutParams = new ViewGroup.LayoutParams(284, 56);
                                    holder.itemView.setLayoutParams(layoutParams);
                                    holder.itemView.setFocusable(false);
                                    ImageUtils.load(posterVos.get(position).getHomePosterPath(), (ImageView) holder.itemView);
                                    break;

                                case 15:
                                case 18:
                                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                    layoutParams = new ViewGroup.LayoutParams(416, 520);
                                    holder.itemView.setLayoutParams(layoutParams);
                                    ImageUtils.load(posterVos.get(position).getHomePosterPath(), (ImageView) holder.itemView);
                                    break;


                                case 16:
                                case 19:
                                case 20:
                                case 17:
                                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                    layoutParams = new ViewGroup.LayoutParams(416, 248);
                                    holder.itemView.setLayoutParams(layoutParams);
                                    ImageUtils.load(posterVos.get(position).getHomePosterPath(), (ImageView) holder.itemView);

                                    break;


                            }
                        } catch (Exception e) {
                            LogUtils.e(e);
                        }


                    }

                    @Override
                    public int getItemCount() {
                        List<LayoutHelper> helpers = getLayoutHelpers();
                        if (helpers == null) {
                            return 0;
                        }
                        int count = 0;
                        for (int i = 0, size = helpers.size(); i < size; i++) {
                            count += helpers.get(i).getItemCount();
                        }
                        return count;
                    }

                }

        );

    }


    class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(ImageView itemView) {
            super(itemView);
            //传入item对应的view
            itemView.setFocusable(true);

            FocusUtils.onFocusChange(itemView, R.drawable.shape_selector_border_corner_press, R.drawable.shape_selector_border_normal);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "v:" + v, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}


