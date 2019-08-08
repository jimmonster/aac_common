package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.FragmentUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.CategoryBean;
import com.jinhong.jhtv.model.CategoryItemBean;
import com.jinhong.jhtv.ui.adapter.CyLeftAdapter;
import com.jinhong.jhtv.ui.fragment.CyFragment;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;

/**
 * @author :  Jim
 * @date :  2019-07-11
 * @description : 二级页面,分类界面
 */
public class CategoryActivity extends BaseActivity {


    private ImageView mIvLogo;
    private TvRecyclerView mRecyclerview;
    private int mLog;
    private CyFragment mCyFragment;

    private CategoryBean mCategoryBean;
    private int mType;
    private int n;
    private int f;
    private int p;
    private LinearLayout mLlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cy_drawing);
        initData();
        getType();


    }

    private void initData() {


        mCategoryBean = new CategoryBean();
        ArrayList<String> tabsName = new ArrayList<>();
        ArrayList<CategoryItemBean> pics = new ArrayList<>();
        tabsName.add("全部");
        tabsName.add("明星宝贝");
        tabsName.add("超轻彩泥");
        tabsName.add("手工秀");

        mCategoryBean.setTabsName(tabsName);

        for (int i = 0; i < 20; i++) {
            CategoryItemBean categoryItemBean = new CategoryItemBean();
            categoryItemBean.setPic("http://pic2.52pk.com/files/allimg/090626/1553504U2-2.jpg");
            categoryItemBean.setTitle("内容标题" + i);
            pics.add(categoryItemBean);
        }
        mCategoryBean.setItems(pics);
        //todo 返回左侧的标题栏
        mCommonViewModel.getCategoryLeftListBean("10007");


    }

    private void getType() {
        int bg, log, n, f, p, btnDrawable, textColor;
        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            mType = bundleExtra.getInt("type", 0);
            switch (mType) {
                case 1://亲子玩具
                    bg = R.drawable.iv_bg_game;
                    log = R.drawable.iv_log_toy;
                    n = R.drawable.iv_btn_game_normal;
                    f = R.drawable.iv_btn_game_focus;
                    p = R.drawable.iv_btn_game_press;
                    btnDrawable = R.drawable.iv_btn_game_normal;
                    textColor = R.color.common_white;
                    initView(bg, log, n, f, p, btnDrawable, textColor);

                    break;
                case 2://亲子游戏

                    bg = R.drawable.iv_bg_game;
                    log = R.drawable.iv_log_game;
                    n = R.drawable.iv_btn_game_normal;
                    f = R.drawable.iv_btn_game_focus;
                    p = R.drawable.iv_btn_game_press;
                    btnDrawable = R.drawable.iv_btn_game_normal;
                    textColor = R.color.common_white;
                    initView(bg, log, n, f, p, btnDrawable, textColor);

                    break;
                case 3://亲子手工
                    bg = R.drawable.iv_bg_drawing;
                    log = R.drawable.iv_log_shougong;
                    n = R.drawable.iv_btn_drawing_normal;
                    f = R.drawable.iv_btn_drawing_focus;
                    p = R.drawable.iv_btn_drawing_press;
                    btnDrawable = R.drawable.iv_btn_drawing_normal;
                    textColor = R.color.common_white;
                    initView(bg, log, n, f, p, btnDrawable, textColor);

                    break;
                case 4://亲子教育

                    bg = R.drawable.iv_bg_edt;
                    log = R.drawable.iv_log_edt;
                    n = R.drawable.iv_btn_edt_normal;
                    f = R.drawable.iv_btn_edt_focus;
                    p = R.drawable.iv_btn_edt_press;
                    btnDrawable = R.drawable.iv_btn_edt_normal;
                    textColor = R.color.common_white;
                    initView(bg, log, n, f, p, btnDrawable, textColor);


                    break;
                case 5://亲子绘画


                    bg = R.drawable.iv_bg_drawing;
                    log = R.drawable.iv_log_huihua;
                    n = R.drawable.iv_btn_drawing_normal;
                    f = R.drawable.iv_btn_drawing_focus;
                    p = R.drawable.iv_btn_drawing_press;
                    btnDrawable = R.drawable.iv_btn_drawing_normal;
                    textColor = R.color.common_white;
                    initView(bg, log, n, f, p, btnDrawable, textColor);


                    break;
                case 6://动画天地

                    mLog = R.drawable.iv_log_shougong;
                    break;
                default:

                    bg = R.drawable.iv_bg_drawing;
                    log = R.drawable.iv_log_huihua;
                    n = R.drawable.iv_btn_drawing_normal;
                    f = R.drawable.iv_btn_drawing_focus;
                    p = R.drawable.iv_btn_drawing_press;
                    btnDrawable = R.drawable.iv_btn_drawing_normal;
                    textColor = R.color.common_white;
                    initView(bg, log, n, f, p, btnDrawable, textColor);

                    break;

            }


        }
    }

    private void initView(int bg, int log, int n, int f, int p, int btnDrawable, int textColor) {
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
        mRecyclerview = (TvRecyclerView) findViewById(R.id.recyclerview);
        CyLeftAdapter cyLeftAdapter = new CyLeftAdapter(R.layout.widget_cy_text, mCategoryBean.getTabsName(), btnDrawable, textColor);
        mRecyclerview.setAdapter(cyLeftAdapter);
        mCyFragment = new CyFragment(mCategoryBean.getItems());
        FragmentUtils.add(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);

        mLlContainer.setBackgroundResource(bg);
        mIvLogo.setImageResource(log);
        initEvent(n, f, p);
    }

    /**
     * @param n 默认
     * @param f 焦点选中
     * @param p 按下
     */
    private void initEvent(int n, int f, int p) {
        mRecyclerview.setSelection(0);
        mRecyclerview.setOnItemListener(new TvRecyclerView.OnItemListener() {
            @Override
            public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
                if (itemView != null) {
                    itemView.setBackgroundResource(n);
                }

            }

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                if (itemView != null) {
                    itemView.setBackgroundResource(f);
                }
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                if (itemView != null) {
                    itemView.setBackgroundResource(p);
                }
                mCyFragment = new CyFragment(mCategoryBean.getItems());
                FragmentUtils.replace(getSupportFragmentManager(), mCyFragment, R.id.fl_replace_fragment);
            }
        });
    }
}
