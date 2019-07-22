package com.jinhong.jhtv.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.model.MainBean1;
import com.jinhong.jhtv.utils.FocusUtils;
import com.jinhong.jhtv.utils.ImageUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-20
 * @description :主页对应的fragment
 */
public class MainFragment extends BaseFragment {

    private TvRecyclerView mRecyclerView;
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

        mRecyclerView = (TvRecyclerView) inflate.findViewById(R.id.recyclerView);

        MainBean1QuickAdapter gsyMenuAdapter = new MainBean1QuickAdapter(mMainBean1s1);
        mRecyclerView.setAdapter(gsyMenuAdapter);
        gsyMenuAdapter.bindToRecyclerView(mRecyclerView);

        mRecyclerView.setOnItemListener(new TvRecyclerView.OnItemListener() {
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                FocusUtils.unselected(itemView);
            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                FocusUtils.selected(itemView);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private class MainBean1QuickAdapter extends BaseMultiItemQuickAdapter<MainBean1, BaseViewHolder> {


        public MainBean1QuickAdapter(List data) {
            super(data);

            addItemType(MainBean1.TYPE1, R.layout.item_main_type1);
            addItemType(MainBean1.TYPE2, R.layout.item_main_type2);
            addItemType(MainBean1.TYPE3, R.layout.item_main_type3);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainBean1 item) {

            switch (helper.getItemViewType()) {
                case MainBean1.TYPE1:
                    ImageUtils.load2Corners(item.getPic(),(ImageView)helper.getView(R.id.iv_pics));

                    break;
                case MainBean1.TYPE2:
                    ImageUtils.load2Circle(item.getPic(),(ImageView)helper.getView(R.id.iv_pics));
                    break;
                case MainBean1.TYPE3:
                    ImageUtils.load(item.getPic(),(ImageView)helper.getView(R.id.iv_pics));
                    break;
                default:
                    break;
            }
        }

    }

}
