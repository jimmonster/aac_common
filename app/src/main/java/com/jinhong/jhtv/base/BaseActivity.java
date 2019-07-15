package com.jinhong.jhtv.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.ui.widgets.BorderView;
import com.jinhong.jhtv.ui.widgets.LoadingFrame;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public abstract class BaseActivity extends AppCompatActivity {

    public BorderView mBorder;
    public String extraBundle = "ExtraBundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setFullScreen(this);//设置全屏
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.setLandscape(this);//设置横屏
        }
        //添加选中焦点边框
        mBorder = new BorderView(this);
        mBorder.setBackgroundResource(R.drawable.iv_focus);


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
                        v.setBackgroundResource(R.drawable.shape_selector_border_press);
//                        v.setPadding(10,10,10,10);
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
                    } else {
                        v.setBackgroundResource(R.drawable.shape_selector_border_normal);
                        v.animate().scaleX(0.98f).scaleY(0.98f).setDuration(200).start();
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
     * 统一界面跳转,携带参数
     *
     * @param activity
     */
    public void startActivity(Class activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(extraBundle, bundle);
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

    /**
     * 统一进度条，加载中
     */
    public void progressLoading() {
        LoadingFrame loadingFrame = new LoadingFrame(this) {
            @Override
            public View onSuccessView() {
                return this;
            }

            @Override
            public int onLoad() {
                return LoadingFrame.LOADING;
            }
        };
        loadingFrame.show();

    }

    /**
     * 统一进度条，加载失败
     */
    public void progressFailed() {
        LoadingFrame loadingFrame = new LoadingFrame(this) {
            @Override
            public View onSuccessView() {
                return this;
            }

            @Override
            public int onLoad() {
                return LoadingFrame.LOADERROR;
            }
        };

        loadingFrame.show();
    }

    /**
     * 统一进度条，加载成功
     */
    public void progressSucceed() {
        LoadingFrame loadingFrame = new LoadingFrame(this) {
            @Override
            public View onSuccessView() {
                return this;
            }

            @Override
            public int onLoad() {
                return LoadingFrame.LOADED;
            }
        };
        loadingFrame.show();

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
