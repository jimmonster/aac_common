package com.jinhong.jhtv;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.CrashUtils;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;

/**
 * @author :  Jim
 * @date :  2019-07-10
 * @description :
 */
public class App extends Application implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onCreate() {
        super.onCreate();
        initBugly();//异常捕捉
//         initLeakCanary();//内存泄露检测
    }


    private void initBugly() {

        // CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLYID, false);
        Bugly.init(getApplicationContext(), Constants.BUGLYID, false);
        //本地崩溃检测
        CrashUtils.init();
    }

    private void initLeakCanary() {
        /*LeakCanary*/
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        /*LeakCanary*/
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
