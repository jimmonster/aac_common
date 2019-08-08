package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.SearchBean;
import com.jinhong.jhtv.ui.adapter.ItemFavoriteAdapter;
import com.jinhong.jhtv.ui.adapter.ItemSearchInfoAdapter;
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
    private TextView mTvSearchInfo;
    private TvRecyclerView mRecyclerViewInfo;
    private TvRecyclerView mRecyclerViewFavorite;

    private String searchInfo = "";
    private ArrayList<Integer> mFavorite;
    private SearchBean.DataBean mSearchInfoData;
    private ItemSearchInfoAdapter mSearchInfoAdapter;
    private MutableLiveData<SearchBean> mSearchBeanLiveData;
    private LinearLayout mLlKeyboard;


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
        for (int i = 65; i <= 90; i++) {
            mLetters.add("" + (char) i);

        }
        for (int i = 0; i < 6; i++) {
            mLetters.add("" + i);
        }


        mFavorite = new ArrayList<>();
        mFavorite.add(R.drawable.iv_search_ip01);
        mFavorite.add(R.drawable.iv_search_ip02);
        mFavorite.add(R.drawable.iv_search_ip03);
        mFavorite.add(R.drawable.iv_search_ip04);
        mFavorite.add(R.drawable.iv_search_ip05);
        mFavorite.add(R.drawable.iv_search_ip06);
        //requestSearchInfo

        mSearchBeanLiveData = mCommonViewModel.getSearchBean("");

    }


    private void initView() {

        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mTvSearchInfo = (TextView) findViewById(R.id.tv_search_info);
        mLlKeyboard = (LinearLayout) findViewById(R.id.ll_keyboard);

        //搜索内容
        mRecyclerViewInfo = (TvRecyclerView) findViewById(R.id.recyclerView_info);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        mRecyclerViewInfo.setLayoutManager(linearLayoutManager1);

        setInfoAdapterData();
        //推荐收藏
        mRecyclerViewFavorite = (TvRecyclerView) findViewById(R.id.recyclerView_favorite);
        ItemFavoriteAdapter favoriteAdapter = new ItemFavoriteAdapter(R.layout.widget_item_favorite, mFavorite);
        mRecyclerViewFavorite.setAdapter(favoriteAdapter);

        //按键
        mRecyclerViewKeyboard = (TvRecyclerView) findViewById(R.id.recyclerView_keyboard);
        KeyBoardAdapter keyBoardAdapter = new KeyBoardAdapter(R.layout.widget_item_keyboard, mLetters);

        mRecyclerViewKeyboard.setAdapter(keyBoardAdapter);
        keyBoardAdapter.bindToRecyclerView(mRecyclerViewKeyboard);

        keyBoardAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    default:
                        toast("position:" + position);
                        searchInfo += mLetters.get(position);
                        mTvSearchInfo.setText(searchInfo);
                        //todo 请求后台
                        //最开始就请求一次热门的ip


                        break;

                    case 32://删除
                        if (searchInfo != null && searchInfo.length() > 0) {
                            int length = searchInfo.length();
                            length--;
                            searchInfo = searchInfo.substring(0, length);
                            mTvSearchInfo.setText(searchInfo);
                            //todo 请求后台


                        } else {
                            toast("搜索内容不能为空");
                        }

                        break;

                    case 37://清空
                        searchInfo = "";
                        mTvSearchInfo.setText(searchInfo);
                        break;
                }


            }
        });
        mLlKeyboard.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchInfo != null && searchInfo.length() > 0) {
                    int length = searchInfo.length();
                    length--;
                    searchInfo = searchInfo.substring(0, length);
                    mTvSearchInfo.setText(searchInfo);
                    //todo 请求后台


                } else {
                    toast("搜索内容不能为空");
                }

            }
        });
        mLlKeyboard.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 6;
                mTvSearchInfo.setText(searchInfo);
            }
        });
        mLlKeyboard.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 7;
                mTvSearchInfo.setText(searchInfo);
            }
        });
        mLlKeyboard.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 8;
                mTvSearchInfo.setText(searchInfo);
            }
        });
        mLlKeyboard.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 9;
                mTvSearchInfo.setText(searchInfo);
            }
        });
        mLlKeyboard.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo = "";
                mTvSearchInfo.setText(searchInfo);
            }
        });


    }

    private void setInfoAdapterData() {
        mSearchBeanLiveData.observe(this, new Observer<SearchBean>() {
            @Override
            public void onChanged(@Nullable SearchBean searchBean) {
                if (searchBean.getData() != null) {
                    mSearchInfoAdapter = new ItemSearchInfoAdapter(R.layout.widget_item_search_info, searchBean.getData().getList());
                    mRecyclerViewInfo.setAdapter(mSearchInfoAdapter);
                }
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_1:   //数字键1
                toast("数字键1" + searchInfo);
                if (searchInfo != null && searchInfo.length() > 0) {
                    int length = searchInfo.length();
                    length--;
                    searchInfo = searchInfo.substring(0, length);
                    mTvSearchInfo.setText(searchInfo);
                    //todo 请求后台

                } else {
                    toast("搜索内容不能为空");
                }
                break;

            default:
                break;
        }

        return super.onKeyDown(keyCode, event);

    }


}
