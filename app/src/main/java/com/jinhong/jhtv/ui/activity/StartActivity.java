package com.jinhong.jhtv.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;
import com.blankj.utilcode.util.AppUtils;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * @author :  Jim
 * @date :  2019-07-17
 * @description :开始界面，版本检测，界面跳转
 */
@RuntimePermissions
public class StartActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        StartActivityPermissionsDispatcher.needsPermissionWithPermissionCheck(this);
        checkVersion();

    }

    private void jumpToNextActivity() {
        new Thread(() -> {
            SystemClock.sleep(2000);
            startActivity(MainActivity.class);
            finish();
        }).start();
    }

    @NeedsPermission({Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void needsPermission() {
        jumpToNextActivity();
    }

    @OnPermissionDenied({Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onPermissionDenied() {
        AppUtils.exitApp();
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



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        StartActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

}
