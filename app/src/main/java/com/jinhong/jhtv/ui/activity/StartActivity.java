package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.os.SystemClock;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

/**
 * @author :  Jim
 * @date :  2019-07-17
 * @description :开始界面，版本检测，界面跳转
 */
public class StartActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        checkVersion();
        jumpToNextActivity();
    }

    private void jumpToNextActivity() {
        new Thread(() -> {
            SystemClock.sleep(2000);
            startActivity(MainActivity.class);
            finish();
        }).start();
    }


    //检测版本升级
    private void checkVersion() {
        AllenVersionChecker
                .getInstance()
                .requestVersion()
                .setRequestUrl("服务器版本地址")
                .request(new RequestVersionListener() {

                    @Override
                    public UIData onRequestVersionSuccess(String result) {
                        //get the data response from server,parse,get the `downloadUlr` and some other ui date
                        //return null if you dont want to update application
                        return UIData.create().setDownloadUrl("下载apk地址");
                    }

                    @Override
                    public void onRequestVersionFailure(String message) {

                    }
                })
                .executeMission(getApplicationContext());
    }
}
