package com.jinhong.jhtv.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.ScreenUtils;
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
                    if (hasFocus) {
                        v.setBackgroundResource(R.drawable.shape_selector_border_press);
                        v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
                    } else {
                        v.setBackgroundResource(R.drawable.shape_selector_border_normal);
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
                    }
                }
            }
        });
    }

    public void startActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);

    }

    public void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}
