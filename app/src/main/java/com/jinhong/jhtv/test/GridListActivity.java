package com.jinhong.jhtv.test;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.utils.FocusUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-04
 * @description :
 */
public class GridListActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private ArrayList<Integer> mFavorite;
    private ArrayList<String> mInfos;
    private String searchInfo = "";
    private ArrayList<String> mLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initData();
        initView();
    }

    private void initData() {
        //keyboard Data
        mLetters = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            mLetters.add("" + (char) i);

        }
        for (int i = 0; i < 6; i++) {
            mLetters.add("" + i);
        }
        mLetters.add("删除");
        mLetters.add("");
        for (int i = 6; i < 10; i++) {
            mLetters.add("" + i);
        }
        mLetters.add("清空");


        mFavorite = new ArrayList<>();
        mFavorite.add(R.drawable.iv_search_ip01);
        mFavorite.add(R.drawable.iv_search_ip02);
        mFavorite.add(R.drawable.iv_search_ip03);
        mFavorite.add(R.drawable.iv_search_ip04);
        mFavorite.add(R.drawable.iv_search_ip05);
        mFavorite.add(R.drawable.iv_search_ip06);

        mInfos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mInfos.add("小猪佩奇玩玩具：" + i);

        }
    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this, VirtualLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

//        layoutManager.setReverseLayout(true);//等比划分

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 0);
            }
        });

        final List<LayoutHelper> helpers = new LinkedList<>();

//网格布局
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(8);
        staggeredGridLayoutHelper.setHGap(0);
        staggeredGridLayoutHelper.setVGap(0);
        staggeredGridLayoutHelper.setItemCount(mLetters.size());
        helpers.add(staggeredGridLayoutHelper);
        layoutManager.setLayoutHelpers(helpers);

        recyclerView.setAdapter(
                new VirtualLayoutAdapter(layoutManager) {
                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.widget_item_keyboard, parent, false);
                        TextView textView = inflate.findViewById(R.id.tv_keycode);
                        //加载参数
                        return new MainViewHolder(textView);
                    }

                    @Override
                    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                        TextView textView = (TextView) holder.itemView;
                        switch (position) {
                            default:
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(70, 70);
                                holder.itemView.setLayoutParams(layoutParams);
                                textView.setText(mLetters.get(position));
                                break;

                            case 32:
                                layoutParams = new ViewGroup.LayoutParams(160, 70);
                                holder.itemView.setLayoutParams(layoutParams);
                                textView.setText(mLetters.get(position));
                                break;
                            case 37:
                                layoutParams = new ViewGroup.LayoutParams(160, 70);
                                holder.itemView.setLayoutParams(layoutParams);
                                textView.setText(mLetters.get(position));
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

    class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(TextView itemView) {
            super(itemView);
            //传入item对应的view
            FocusUtils.onFocusChange(itemView, R.drawable.iv_search_btn_f, R.drawable.iv_search_btn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

        }
    }


}
