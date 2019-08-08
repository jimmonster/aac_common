package com.jinhong.jhtv.base;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.ui.widgets.BorderView;
import com.jinhong.jhtv.ui.widgets.LoadingFrame;
import com.jinhong.jhtv.vm.viewmodel.CommonViewModel;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public abstract class BaseActivity extends AppCompatActivity {
    public CommonViewModel mCommonViewModel;
    public BorderView mBorder;
    public String extraBundle = "ExtraBundle";
    @SuppressLint("HandlerLeak")
    public Handler baseHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            baseHandler(msg);

        }
    };


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    public void baseHandler(Message msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setFullScreen(this);//设置全屏
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.setLandscape(this);//设置横屏
        }
        mCommonViewModel = ViewModelProviders.of(this).get(CommonViewModel.class);
        //添加选中焦点边框
        mBorder = new BorderView(this);
        mBorder.setBackgroundResource(R.drawable.iv_focus);


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
     * 统一log
     *
     * @param str
     */
    public void log(Object str) {
        String clazz = this.getClass().getSimpleName();
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        LogUtils.e("jim:" + clazz + "******" + method, "\n                        " + str + "                    \n");
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

    /**
     * 监听app 的点击事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //有按下动作时取消定时
                //todo 请求上传数据接口，并且上传
                //单条日志上传接口
                //{
                //"clickTime":”20190303101010”,
                //    "clientIp":"1.1.1.1",
                //    "productName":"qhz",
                //"productPage":"category",
                //"area":”1”,
                //    "sort":"3",
                //    "options":"0",
                //"contentId":"100010",
                //“contentName”:”小猪佩奇”
                //
                //}
                String nowString = TimeUtils.getNowString();
                HashMap<String, String> params = new HashMap<>();

                params.put("clickTime",nowString);
                params.put("clientIp", NetworkUtils.getIPAddress(true));
                params.put("productName","qhz");
                params.put("productPage","category");
                params.put("area","1");
                params.put("sort","3");
                params.put("options","0");
                params.put("contentId","100010");
                params.put("contentName","小猪佩奇");
                mCommonViewModel.updateSingleCollectBean(params);
                break;
            default:
                break;

        }
        return super.dispatchTouchEvent(ev);

    }


}
