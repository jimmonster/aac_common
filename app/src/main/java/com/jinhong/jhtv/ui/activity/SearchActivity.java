package com.jinhong.jhtv.ui.activity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private ArrayList<MainListBean.DataBean.PosterVosBean> mPosterVosBeans = new ArrayList<>();
    private List<SearchBean.DataBean.ListBean> mNoData;
    private MainIdBean.DataBean mDataBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        initView();
    }

    private void initData() {
        mNoData = new ArrayList<>();
        SearchBean.DataBean.ListBean listBean = new SearchBean.DataBean.ListBean();
        listBean.setMainName("当前请求数据为空");
        mNoData.add(listBean);

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
        mDataBean = mainIdBean.getData();
        //推荐收藏
        mMainListBean = mCommonViewModel.getMainListBean(mDataBean.getMain());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPosterVosBeans.clear();
    }

    private void initView() {

        mTvCurrentPage = (TextView) findViewById(R.id.tv_current_page);
        mTvFavorite = (TextView) findViewById(R.id.tv_favorite);
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mTvSearchInfo = (TextView) findViewById(R.id.tv_search_info);
        mLlKeyboard = (LinearLayout) findViewById(R.id.ll_keyboard);

        //搜索内容
        mRecyclerViewInfo = (TvRecyclerView) findViewById(R.id.recyclerView_info);

        mSearchInfoAdapter = new ItemSearchInfoAdapter(R.layout.widget_item_search_info, mNoData);
        mRecyclerViewInfo.setAdapter(mSearchInfoAdapter);
        mSearchInfoAdapter.bindToRecyclerView(mRecyclerViewInfo);
        //初始化展示推荐的数据
        mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
        setData2Adapter(true);
        mSearchInfoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mSearchInfoData != null && mSearchInfoData.getList() != null && mSearchInfoData.getList().size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fatherId", "" + mSearchInfoData.getList().get(position).getFatherId());
                    startActivity(DetailActivity.class, bundle);
                }
            }
        });


        mRecyclerViewFavorite = (TvRecyclerView) findViewById(R.id.recyclerView_favorite);
        ItemFavoriteAdapter favoriteAdapter = new ItemFavoriteAdapter(R.layout.widget_item_favorite, mPosterVosBeans);
        mRecyclerViewFavorite.setAdapter(favoriteAdapter);
        favoriteAdapter.bindToRecyclerView(mRecyclerViewFavorite);
        mMainListBean.observe(this, new Observer<MainListBean>() {
            @Override
            public void onChanged(@Nullable MainListBean mainListBean) {
                if (mainListBean != null) {
                    List<MainListBean.DataBean.PosterVosBean> posterVos = mainListBean.getData().getPosterVos();
                    Collections.sort(posterVos, (o1, o2) -> Integer.parseInt(o1.getPosterId().substring(3)) - Integer.parseInt(o2.getPosterId().substring(3)));
                    mPosterVosBeans.clear();
                    for (int i = 6; i <= 11; i++) {
                        if (posterVos.get(i) != null) {
                            mPosterVosBeans.add(posterVos.get(i));
                        }
                    }
                    favoriteAdapter.setNewData(mPosterVosBeans);


                }

            }
        });
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
                searchInfo += mLetters.get(position);
                mTvSearchInfo.setText(searchInfo);
                mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                setData2Adapter(true);


            }
        });
        mLlKeyboard.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = searchInfo.length();
                length--;
                searchInfo = searchInfo.substring(0, length < 0 ? 0 : length);
                //删除
                mTvSearchInfo.setText(searchInfo);
                if (!TextUtils.isEmpty(searchInfo) && length >= 0) {
                    mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                    setData2Adapter(true);
                } else {
                    setData2Adapter(false);
                }

            }
        });
        mLlKeyboard.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 6;
                mTvSearchInfo.setText(searchInfo);
                mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                setData2Adapter(true);
            }
        });
        mLlKeyboard.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 7;
                mTvSearchInfo.setText(searchInfo);
                mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                setData2Adapter(true);
            }
        });
        mLlKeyboard.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 8;
                mTvSearchInfo.setText(searchInfo);
                mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                setData2Adapter(true);
            }
        });
        mLlKeyboard.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInfo += 9;
                mTvSearchInfo.setText(searchInfo);
                mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                setData2Adapter(true);
            }
        });
        mLlKeyboard.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清空
                searchInfo = "";
                mTvSearchInfo.setText(searchInfo);
                setData2Adapter(false);
            }
        });


    }

    public void setData2Adapter(boolean isClick) {


        mSearchBeanLiveData.observe(this, new Observer<SearchBean>() {
            @Override
            public void onChanged(@Nullable SearchBean searchBean) {
                if (searchBean != null) {
                    mSearchInfoData = searchBean.getData();
                    if (mSearchInfoData.getSize() > 0) {
                        mTvCurrentPage.setText(String.format("(共%d条搜索记录）", searchBean.getData().getSize()));
                        mSearchInfoAdapter.setNewData(searchBean.getData().getList());
                    } else {
                        mTvCurrentPage.setText(String.format("(共%d条搜索记录）", 0));
                        mSearchInfoAdapter.setNewData(mNoData);
                    }
                }


            }


        });


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_1:   //返回键,删除键
                toast("数字键1" + searchInfo);
                if (!TextUtils.isEmpty(searchInfo)) {
                    int length = searchInfo.length();
                    length--;
                    searchInfo = searchInfo.substring(0, length);
                    mTvSearchInfo.setText(searchInfo);
                    mSearchBeanLiveData = mCommonViewModel.getSearchBean(searchInfo);
                    setData2Adapter(true);

                } else {
                    setData2Adapter(false);
                }
                break;

            default:
                break;
        }

        return super.onKeyDown(keyCode, event);

    }


}
