package com.jinhong.jhtv.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelperEx;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.MainBean1;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-20
 * @description :主页对应的fragment
 */
public class MainFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private ArrayList<String> mContents;

    private MainBean1 mMainBean1;
    private MainBean1 mMainBean2;
    private MainBean1 mMainBean3;
    private ArrayList<MainBean1> mMainBean1s;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);

        initData();
        initView(inflate);

        return inflate;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFocusBorder != null) {
            mFocusBorder.unBoundGlobalFocusListener();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mFocusBorder != null) {
            mFocusBorder.unBoundGlobalFocusListener();
        }
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mContents = (ArrayList<String>) arguments.get("mainData");
        }
        //todo  3种假数据类型
        //1 GridLayoutManager 一行展示4张图片，展示2行 等比。方形，带圆角，白色选中边框，选中缩小放大
        //2 圆形 单行展示6个 等比
        //3 带标题，图片对称，不等宽高，带圆角
//内容

        mMainBean1s = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mMainBean1 = new MainBean1(1, R.drawable.iv_poster_0);
            mMainBean1.setSpanSize(1);
            mMainBean1s.add(mMainBean1);
        }
        for (int i = 0; i < 6; i++) {
            mMainBean2 = new MainBean1(2, R.drawable.iv_poster_0);
            mMainBean2.setSpanSize(2);
            mMainBean1s.add(mMainBean2);
        }
        for (int i = 0; i < 10; i++) {
            mMainBean3 = new MainBean1(3, R.drawable.iv_poster_0);
            mMainBean3.setSpanSize(3);
            mMainBean1s.add(mMainBean3);
        }


    }

    private void initView(View inflate) {


/**************/
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

//        layoutManager.setReverseLayout(true);//等比划分

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(10, 10, 10, 10);
            }
        });

        final List<LayoutHelper> helpers = new LinkedList<>();

//网格布局
        final GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(4);

        gridLayoutHelper1.setItemCount(8);

//网格布局
        final GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(6);
        gridLayoutHelper.setItemCount(6);

//1+N布局
        OnePlusNLayoutHelperEx onePlusNLayoutHelperEx = new OnePlusNLayoutHelperEx(5);
//网格布局
        final GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(4);
        gridLayoutHelper2.setItemCount(4);
//悬浮布局
//        FixLayoutHelper layoutHelper = new FixLayoutHelper(80, 80);
        //流式布局
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(4);
        staggeredGridLayoutHelper.setItemCount(6);

//按照顺序添加类型条目布局
        helpers.add(gridLayoutHelper1);
        helpers.add(gridLayoutHelper);
//        helpers.add(onePlusNLayoutHelperEx);
        helpers.add(staggeredGridLayoutHelper);
        helpers.add(gridLayoutHelper2);


        layoutManager.setLayoutHelpers(helpers);

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
                        switch (position) {
                            default:
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                                break;

                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(200, 200);
                                holder.itemView.setLayoutParams(layoutParams);
                                ImageView itemView = (ImageView) holder.itemView;
                                itemView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                ImageUtils.load2Circle(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                                break;

                            case 14:
                            case 17:
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                layoutParams = new ViewGroup.LayoutParams(400, 600);
                                holder.itemView.setLayoutParams(layoutParams);
                                ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                                break;

                            case 15:
                            case 16:
                            case 19:
                            case 18:
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                layoutParams = new ViewGroup.LayoutParams(400, 300);
                                holder.itemView.setLayoutParams(layoutParams);
                                ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);

                                break;


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


/**************/


    }


    class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(ImageView itemView) {
            super(itemView);
            //传入item对应的view
            itemView.setFocusable(true);

            FocusUtils.onFocusChange(itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "v:" + v, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}


