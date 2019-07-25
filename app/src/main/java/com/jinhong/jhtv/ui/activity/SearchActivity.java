package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.adapter.KeyBoardAdapter;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-24
 * @description :搜索页面
 */
public class SearchActivity extends BaseActivity {
    private TvRecyclerView mRecyclerViewKeyboard;
    private ArrayList<String> mLetters;
    private ImageView mIvLogo;
    private TextView mIvSearchInfo;
    private TvRecyclerView mRecyclerViewInfo;
    private TvRecyclerView mRecyclerViewFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        initView();
    }

    private void initData() {
        //keyboard Data
        mLetters = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            mLetters.add("" + i);
        }

    }


    private void initView() {

        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mIvSearchInfo = (TextView) findViewById(R.id.iv_search_info);
        mRecyclerViewInfo = (TvRecyclerView) findViewById(R.id.recyclerView_info);
        mRecyclerViewFavorite = (TvRecyclerView) findViewById(R.id.recyclerView_favorite);

        mRecyclerViewKeyboard = (TvRecyclerView) findViewById(R.id.recyclerView_keyboard);
        KeyBoardAdapter keyBoardAdapter = new KeyBoardAdapter(R.layout.widget_item_keyboard, mLetters);
        mRecyclerViewKeyboard.setAdapter(keyBoardAdapter);
        keyBoardAdapter.bindToRecyclerView(mRecyclerViewKeyboard);
        keyBoardAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast("position:" + position);
            }
        });


    }
}
