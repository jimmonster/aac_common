package com.jinhong.jhtv;

import android.app.Application;

import com.blankj.utilcode.util.CrashUtils;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * @author :  Jim
 * @date :  2019-07-10
 * @description :
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initBugly();//异常捕捉
        // initLeakCanary();//内存泄露检测

    }



    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLYID, false);
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

}
