package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.utils.FocusUtils;

/**
 * @author :  Jim
 * @date :  2019-08-01
 * @description :
 */
public class ViewTestActivity extends BaseActivity {


    private CardView mCardView0;
    private CardView mCardView1;
    private ImageView mIv0;
    private ImageView mIv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtest);
        initView();


    }

    private void initView() {


        mIv0 = (ImageView) findViewById(R.id.iv0);
        mIv1 = (ImageView) findViewById(R.id.iv1);
        mCardView0 = (CardView) findViewById(R.id.card0);
        mCardView1 = (CardView) findViewById(R.id.card1);
        FocusUtils.onFocusChange(mCardView0,R.drawable.shape_selector_border_corner_press);
        FocusUtils.onFocusChange(mCardView1,R.drawable.shape_selector_border_corner_press);
    }
}
