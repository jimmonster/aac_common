package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.views.AutoHorizontalScrollTextView;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :主页界面
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mTvLog;
    private AutoHorizontalScrollTextView mTvNotice;
    private TextClock mTvDate;
    private ImageView mIvTab0;
    private ImageView mIvTab1;
    private ImageView mIvTab2;
    private ImageView mIvTab3;
    private ImageView mIvTab4;
    private ImageView mIvTab5;
    private ImageView mIvPic0;
    private ImageView mIvPic1;
    private ImageView mIvPic2;
    private ImageView mIvPic3;
    private ImageView mIvPic4;
    private ImageView mIvPic5;
    private ImageView mIvPic6;
    private ImageView mIvPic7;
    private ImageView mIvPic8;
    private ImageView mIvPic9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvLog = (ImageView) findViewById(R.id.tv_log);
        mTvNotice = (AutoHorizontalScrollTextView) findViewById(R.id.tv_notice);
        mTvDate = (TextClock) findViewById(R.id.tv_date);
        mIvTab0 = (ImageView) findViewById(R.id.iv_tab0);
        mIvTab1 = (ImageView) findViewById(R.id.iv_tab1);
        mIvTab2 = (ImageView) findViewById(R.id.iv_tab2);
        mIvTab3 = (ImageView) findViewById(R.id.iv_tab3);
        mIvTab4 = (ImageView) findViewById(R.id.iv_tab4);
        mIvTab5 = (ImageView) findViewById(R.id.iv_tab5);
        mIvPic0 = (ImageView) findViewById(R.id.iv_pic0);
        mIvPic1 = (ImageView) findViewById(R.id.iv_pic1);
        mIvPic2 = (ImageView) findViewById(R.id.iv_pic2);
        mIvPic3 = (ImageView) findViewById(R.id.iv_pic3);
        mIvPic4 = (ImageView) findViewById(R.id.iv_pic4);
        mIvPic5 = (ImageView) findViewById(R.id.iv_pic5);
        mIvPic6 = (ImageView) findViewById(R.id.iv_pic6);
        mIvPic7 = (ImageView) findViewById(R.id.iv_pic7);
        mIvPic8 = (ImageView) findViewById(R.id.iv_pic8);
        mIvPic9 = (ImageView) findViewById(R.id.iv_pic9);

        onFocusChange(mIvPic0);
        onFocusChange(mIvPic1);
        onFocusChange(mIvPic2);
        onFocusChange(mIvPic3);
        onFocusChange(mIvPic4);
        onFocusChange(mIvPic5);
        onFocusChange(mIvPic6);
        onFocusChange(mIvPic7);
        onFocusChange(mIvPic8);
        onFocusChange(mIvPic9);


        mIvTab0.setOnClickListener(this);
        mIvTab1.setOnClickListener(this);
        mIvTab2.setOnClickListener(this);
        mIvTab3.setOnClickListener(this);
        mIvTab4.setOnClickListener(this);
        mIvTab5.setOnClickListener(this);
        mIvPic0.setOnClickListener(this);
        mIvPic1.setOnClickListener(this);
        mIvPic2.setOnClickListener(this);
        mIvPic3.setOnClickListener(this);
        mIvPic4.setOnClickListener(this);
        mIvPic5.setOnClickListener(this);
        mIvPic6.setOnClickListener(this);
        mIvPic7.setOnClickListener(this);
        mIvPic8.setOnClickListener(this);
        mIvPic9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_tab0:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_tab1:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_tab2:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_tab3:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_tab4:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_tab5:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_pic0:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic1:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic2:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic3:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic4:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic5:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic6:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic7:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic8:
                startActivity(DetailActivity.class);
                break;
            case R.id.iv_pic9:
                startActivity(DetailActivity.class);
                break;
        }
    }
}
