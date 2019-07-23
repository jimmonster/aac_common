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

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelperEx;
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

    private ArrayList<MainBean1> mMainBean1s;
    private MainBean1 mMainBean11;
    private MainBean1 mMainBean2;
    private MainBean1 mMainBean3;
    private ArrayList<MainBean1> mMainBean1s1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);

        initData();
        initView(inflate);
        return inflate;

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

        mMainBean1s1 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mMainBean11 = new MainBean1(1, R.drawable.iv_poster_0);
            mMainBean11.setSpanSize(1);
            mMainBean1s1.add(mMainBean11);
        }
        for (int i = 0; i < 6; i++) {
            mMainBean2 = new MainBean1(2, R.drawable.iv_poster_0);
            mMainBean2.setSpanSize(2);
            mMainBean1s1.add(mMainBean2);
        }
        for (int i = 0; i < 10; i++) {
            mMainBean3 = new MainBean1(3, R.drawable.iv_poster_0);
            mMainBean3.setSpanSize(3);
            mMainBean1s1.add(mMainBean3);
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


//悬浮布局
//        FixLayoutHelper layoutHelper = new FixLayoutHelper(80, 80);

//按照顺序添加类型条目布局
        helpers.add(gridLayoutHelper1);
        helpers.add(gridLayoutHelper);
        helpers.add(onePlusNLayoutHelperEx);


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
                        //绑定条目的参数
                        if (position < 8) {
                            ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                        } else if (position < 14) {
                            ImageUtils.load2Circle(R.drawable.iv_poster_0, (ImageView) holder.itemView);
                        } else {
                            ImageUtils.load(R.drawable.iv_poster_0, (ImageView) holder.itemView);
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
            itemView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }

}


