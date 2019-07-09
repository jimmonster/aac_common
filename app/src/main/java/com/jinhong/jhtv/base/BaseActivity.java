package com.jinhong.jhtv.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setFullScreen(this);//设置全屏
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.setLandscape(this);//设置横屏
        }


    }


    /**
     * 焦点变化统一的处理
     *
     * @param view
     */
    public void onFocusChange(View view) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v != null) {
                    v.setSelected(hasFocus);
                    if (hasFocus) {
                        v.setPadding(10,10,10,10);
                        v.setBackgroundResource(R.drawable.iv_focus);
                        v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
                    } else {

                        v.setBackgroundResource(R.drawable.shape_selector_border_normal);
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
                    }
                }
            }
        });
    }

    /**
     * 统一界面跳转
     *
     * @param activity
     */
    public void startActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
//        ActivityUtils.startActivity(intent);

    }


    /**
     * 统一toast
     *
     * @param str
     */
    public void toast(String str) {
        ToastUtils.showShort(str);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
