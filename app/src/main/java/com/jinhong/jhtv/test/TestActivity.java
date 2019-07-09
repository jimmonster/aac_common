package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    /**
     * 测试焦点切换0
     */
    private TextView mTvTest0;
    /**
     * 测试焦点切换0
     */
    private TextView mTvTest1;
    /**
     * 确定
     */
    private TextView mTvCenter;
    /**
     * 上
     */
    private TextView mTvUp;
    /**
     * 下
     */
    private TextView mTvDown;
    /**
     * 左
     */
    private TextView mTvLeft;
    /**
     * 右
     */
    private TextView mTvRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initView();
    }


    private void initView() {
        mTvCenter = (TextView) findViewById(R.id.tv_center);
        mTvCenter.setOnClickListener(this);
        mTvUp = (TextView) findViewById(R.id.tv_up);
        mTvUp.setOnClickListener(this);
        mTvDown = (TextView) findViewById(R.id.tv_down);
        mTvDown.setOnClickListener(this);
        mTvLeft = (TextView) findViewById(R.id.tv_left);
        mTvLeft.setOnClickListener(this);
        mTvRight = (TextView) findViewById(R.id.tv_right);
        mTvRight.setOnClickListener(this);
        setOnFocusChange();
        setOnKey();

    }

    private void setOnKey() {
        mTvCenter.setOnKeyListener(this);
        mTvUp.setOnKeyListener(this);
        mTvDown.setOnKeyListener(this);
        mTvLeft.setOnKeyListener(this);
        mTvRight.setOnKeyListener(this);
    }

    private void setOnFocusChange() {
        mTvCenter.setOnFocusChangeListener(this);
        mTvUp.setOnFocusChangeListener(this);
        mTvDown.setOnFocusChangeListener(this);
        mTvLeft.setOnFocusChangeListener(this);
        mTvRight.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_center:
                toast("onClick确认");
                startActivity(GridListActivity.class);
                break;
            case R.id.tv_up:
                toast("onClick上");
                break;
            case R.id.tv_down:
                toast("onClick下");
                break;
            case R.id.tv_left:
                toast("onClick左");
                break;
            case R.id.tv_right:
                toast("onClick右");
                break;
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v != null) {
            if (hasFocus) {
                v.animate().scaleX(1.5f).scaleY(1.5f).setDuration(300).start();
            } else {

                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
            }
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //Android TV 按键定制化调试
//        switch (event.getKeyCode()) {
//            case KeyEvent.KEYCODE_DPAD_UP://上键
//                toast("onKey上键");
//                break;
//            case KeyEvent.KEYCODE_DPAD_DOWN://下键
//                toast("onKey下键");
//                break;
//            case KeyEvent.KEYCODE_DPAD_LEFT://左键
//                toast("onKey左键");
//                break;
//            case KeyEvent.KEYCODE_DPAD_RIGHT://右键
//                toast("onKey右键");
//                break;
//            case KeyEvent.KEYCODE_ENTER://回车
//                toast("onKey回车");
//                break;
//
//            default:
//                break;
//        }

        return false;
    }

}
