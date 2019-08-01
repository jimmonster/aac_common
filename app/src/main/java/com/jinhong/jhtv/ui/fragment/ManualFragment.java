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
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.ui.activity.CategoryActivity;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :亲子手工页面
 */
public class ManualFragment extends BaseFragment {

    private String dataType;//activity传递过来的分类数据
    private RecyclerView recyclerView;
    private ArrayList<Integer> mPosters;

    public  ManualFragment getInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("DATA", s);
        setArguments(bundle);
        return this;}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        initData();
        initView(inflate);
        return inflate;
    }


    private void initData() {
        //获取到activity传递过来的数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            String data = bundle.getString("DATA");
        }

        mPosters = new ArrayList<>();
        mPosters.add(R.drawable.iv_qinzi_main_pos01);
        mPosters.add(R.drawable.iv_qinzi_main_pos02);
        mPosters.add(R.drawable.iv_qinzi_main_pos02);
        mPosters.add(R.drawable.iv_qinzi_main_pos03);
        mPosters.add(R.drawable.iv_qinzi_main_pos04);
        mPosters.add(R.drawable.iv_qinzi_main_pos05);
        mPosters.add(R.drawable.iv_qinzi_main_pos06);
        mPosters.add(R.drawable.iv_qinzi_main_pos07);
        mPosters.add(R.drawable.iv_qinzi_main_pos08);
        mPosters.add(R.drawable.iv_qinzi_main_pos09);
        mPosters.add(R.drawable.iv_qinzi_main_pos10);
        mPosters.add(R.drawable.iv_qinzi_main_pos11);
        mPosters.add(R.drawable.iv_qinzi_main_pos12);
        mPosters.add(R.drawable.iv_qinzi_main_pos13);
        mPosters.add(R.drawable.iv_qinzi_main_pos14);
        mPosters.add(R.drawable.iv_qinzi_main_pos15);
        mPosters.add(R.drawable.iv_qinzi_main_pos16);
        mPosters.add(R.drawable.iv_qinzi_main_pos17);
        mPosters.add(R.drawable.iv_qinzi_main_pos18);

    }


    private void initView(View inflate) {
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
        final GridLayoutHelper gridLayoutHelper0 = new GridLayoutHelper(2);

        gridLayoutHelper0.setItemCount(2);

        final GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(4);

        gridLayoutHelper1.setItemCount(8);

        helpers.add(gridLayoutHelper0);

        helpers.add(gridLayoutHelper1);

        layoutManager.setLayoutHelpers(helpers);


        recyclerView.setAdapter(
                new VirtualLayoutAdapter(layoutManager) {
                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ImageView imageView = new ImageView(getContext());
                        //加载参数
                        return new ManualViewHolder(imageView);
                    }

                    @Override
                    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                        ImageView imageView = (ImageView) holder.itemView;
                        switch (position) {
                            default:
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(416, 318);
                                holder.itemView.setLayoutParams(layoutParams);
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                ImageUtils.load(mPosters.get(position), (ImageView) holder.itemView);
                                break;

                            case 0:
                            case 1:
                                layoutParams = new ViewGroup.LayoutParams(858, 318);
                                holder.itemView.setLayoutParams(layoutParams);
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                ImageUtils.load(mPosters.get(position), (ImageView) holder.itemView);
                                break;


                            case 9:
                                layoutParams = new ViewGroup.LayoutParams(416, 318);
                                holder.itemView.setLayoutParams(layoutParams);
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                ImageUtils.load(R.drawable.iv_qinzi_more, (ImageView) holder.itemView);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("type", 1);
                                        startActivity(CategoryActivity.class, bundle);
                                    }
                                });

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


    }


    class ManualViewHolder extends RecyclerView.ViewHolder {

        public ManualViewHolder(ImageView itemView) {
            super(itemView);
            //传入item对应的view
            itemView.setFocusable(true);

            FocusUtils.onFocusChange(itemView,R.drawable.shape_selector_border_corner_press,R.drawable.shape_selector_border_normal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "v:" + v, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}


