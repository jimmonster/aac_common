package com.jinhong.jhtv.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.test.TestActivity1;

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
        checkVersion();
        StartActivityPermissionsDispatcher.needsPermissionWithPermissionCheck(this);
    }

    private void jumpToNextActivity() {
        new Thread(() -> {
            SystemClock.sleep(2000);
            startActivity(MainActivity1.class);
            finish();
        }).start();
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.READ_PHONE_STATE})
    void needsPermission() {
        jumpToNextActivity();
    }

    @OnPermissionDenied({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.READ_PHONE_STATE})
    void onPermissionDenied() {
        //AppUtils.exitApp();
    }

    //检测版本升级
    private void checkVersion() {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        StartActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

}
