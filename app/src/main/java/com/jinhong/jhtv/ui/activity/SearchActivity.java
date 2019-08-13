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

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.MainIdBean;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.model.SearchBean;
import com.jinhong.jhtv.ui.adapter.ItemFavoriteAdapter;
import com.jinhong.jhtv.ui.adapter.ItemSearchInfoAdapter;
import com.jinhong.jhtv.ui.adapter.KeyBoardAdapter;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.IoUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private SearchBean.DataBean mSearchInfoData;
    private ItemSearchInfoAdapter mSearchInfoAdapter;
    private MutableLiveData<SearchBean> mSearchBeanLiveData;
    private LinearLayout mLlKeyboard;
    /**
     * (共1条搜索记录）
     */
    private TextView mTvCurrentPage;
    /**
     * 小朋友们最爱看
     */
    private TextView mTvFavorite;
    private MutableLiveData<MainListBean> mMainListBean;
    private ArrayList<MainListBean.DataBean.PosterVosBean> mPosterVosBeans;


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

        String json = IoUtils.inputStreamToString(getResources().openRawResource(R.raw.data_main_id));
        MainIdBean mainIdBean = GsonUtil.GsonToBean(json, MainIdBean.class);
        MainIdBean.DataBean data = mainIdBean.getData();
        mPosterVosBeans = new ArrayList<>();

        mMainListBean = mCommonViewModel.getMainListBean(data.getMain());
        mMainListBean.observe(this, new Observer<MainListBean>() {
            @Override
            public void onChanged(@Nullable MainListBean mainListBean) {
                if (mainListBean != null) {
                    List<MainListBean.DataBean.PosterVosBean> posterVos = mainListBean.getData().getPosterVos();
                    Collections.sort(posterVos, (o1, o2) -> Integer.parseInt(o1.getPosterId().substring(3)) - Integer.parseInt(o2.getPosterId().substring(3)));

                    for (int i = 8; i <= 13; i++) {
                        if (posterVos.get(i) != null) {
                            mPosterVosBeans.add(posterVos.get(i));
                        }
                    }

                }

            }
        });

    }


    private void initView() {

        mTvCurrentPage = (TextView) findViewById(R.id.tv_current_page);
        mTvFavorite = (TextView) findViewById(R.id.tv_favorite);
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mTvSearchInfo = (TextView) findViewById(R.id.tv_search_info);
        mLlKeyboard = (LinearLayout) findViewById(R.id.ll_keyboard);

        //搜索内容
        mRecyclerViewInfo = (TvRecyclerView) findViewById(R.id.recyclerView_info);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        mRecyclerViewInfo.setLayoutManager(linearLayoutManager1);


        //推荐收藏


        mRecyclerViewFavorite = (TvRecyclerView) findViewById(R.id.recyclerView_favorite);
        ItemFavoriteAdapter favoriteAdapter = new ItemFavoriteAdapter(R.layout.widget_item_favorite, mPosterVosBeans);
        mRecyclerViewFavorite.setAdapter(favoriteAdapter);
        favoriteAdapter.bindToRecyclerView(mRecyclerViewFavorite);
        favoriteAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("fatherId", "" + mPosterVosBeans.get(position).getFatherId());
                startActivity(DetailActivity.class, bundle);
            }
        });


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
                        searchInfo += mLetters.get(position);
                        mTvSearchInfo.setText(searchInfo);
                        //最开始就请求一次热门的ip

                        mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                        setData2Adapter();

                        break;

                    case 32://删除
                        if (searchInfo != null && searchInfo.length() > 0) {
                            int length = searchInfo.length();
                            length--;
                            searchInfo = searchInfo.substring(0, length);
                            mTvSearchInfo.setText(searchInfo);
                            mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                            setData2Adapter();

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
                    mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                    setData2Adapter();

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

    public void setData2Adapter() {
        mSearchBeanLiveData.observe(this, new Observer<SearchBean>() {
            @Override
            public void onChanged(@Nullable SearchBean searchBean) {
                try {
                    if (searchBean.getData() != null) {
                        mTvCurrentPage.setText(String.format("(共%d条搜索记录）", searchBean.getData().getSize()));
                        mSearchInfoAdapter = new ItemSearchInfoAdapter(R.layout.widget_item_search_info, searchBean.getData().getList());
                        mRecyclerViewInfo.setAdapter(mSearchInfoAdapter);
                        mSearchInfoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                //todo 跳转到详情页面
                                Bundle bundle = new Bundle();
                                bundle.putString("fatherId", "" + searchBean.getData().getList().get(position).getFatherId());
                                startActivity(DetailActivity.class);
                            }
                        });
                    }
                } catch (Exception e) {
                    LogUtils.e(e);
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
                    mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                    setData2Adapter();
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
