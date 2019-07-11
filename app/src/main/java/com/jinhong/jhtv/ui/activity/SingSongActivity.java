package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

/**
 * @author :  Jim
 * @date :  2019-07-09
 * @description :
 */
public class SingSongActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvPic0;
    private RelativeLayout mRlContainer0;
    private ImageView mIvPic1;
    private RelativeLayout mRlContainer1;
    private ImageView mIvPic2;
    private RelativeLayout mRlContainer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singsong);
        initView();
    }

    private void initView() {
      
        mIvPic0 = (ImageView) findViewById(R.id.iv_pic0);
        mRlContainer0 = (RelativeLayout) findViewById(R.id.rl_container0);
        mBorder.attachTo(mRlContainer0);
        mRlContainer0.setOnClickListener(this);
        mIvPic1 = (ImageView) findViewById(R.id.iv_pic1);
        mRlContainer1 = (RelativeLayout) findViewById(R.id.rl_container1);
        mBorder.attachTo(mRlContainer1);
        mRlContainer1.setOnClickListener(this);
        mIvPic2 = (ImageView) findViewById(R.id.iv_pic2);
        mRlContainer2 = (RelativeLayout) findViewById(R.id.rl_container2);
        mBorder.attachTo(mRlContainer2);
        mRlContainer2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rl_container0:
                break;
            case R.id.rl_container1:
                break;
            case R.id.rl_container2:
                break;
        }
    }
}
