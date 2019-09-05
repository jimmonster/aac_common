package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

/**
 * @author :  Jim
 * @date :  2019-09-03
 * @description :
 */
public class OrderActivity extends BaseActivity implements View.OnClickListener {
    /**
     * 订购包月
     */
    private TextView mTvBuyEveryMonth;
    /**
     * 订购30天
     */
    private TextView mTvBuyOneMonth;
    /**
     * 返回
     */
    private TextView mTvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
    }

    private void initView() {
        mTvBuyEveryMonth = (TextView) findViewById(R.id.tv_buy_every_month);
        mTvBuyEveryMonth.setOnClickListener(this);
        mTvBuyOneMonth = (TextView) findViewById(R.id.tv_buy_one_month);
        mTvBuyOneMonth.setOnClickListener(this);
        mTvBack = (TextView) findViewById(R.id.tv_back);
        mTvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_buy_every_month:
                toast("tv_buy_every_month");
                break;
            case R.id.tv_buy_one_month:
                toast("tv_buy_every_month");
                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }
}
