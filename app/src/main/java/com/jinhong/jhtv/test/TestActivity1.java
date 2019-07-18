package com.jinhong.jhtv.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.JhBaseActivity;
import com.jinhong.jhtv.ui.views.CustomJzvdStd;

import cn.jzvd.Jzvd;
import me.jessyan.autosize.internal.CancelAdapt;

/**
 * @author :  Jim
 * @date :  2019-07-03
 * @description :
 */
public class TestActivity1 extends JhBaseActivity implements CancelAdapt {

    private CustomJzvdStd myJzvdStd;

    //    String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        myJzvdStd = (CustomJzvdStd) findViewById(R.id.jz_video);
        myJzvdStd.setUp(url, null);
//        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(myJzvdStd.thumbImageView);

    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }



}