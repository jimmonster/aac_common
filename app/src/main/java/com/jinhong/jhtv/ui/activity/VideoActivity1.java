package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.views.TvVideoPlayerView;

import java.util.List;

import cn.jzvd.Jzvd;
import me.jessyan.autosize.internal.CancelAdapt;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :视频播放界面
 */
public class VideoActivity1 extends BaseActivity implements CancelAdapt, View.OnKeyListener {

    private TvVideoPlayerView myJzvdStd;

    //    String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);

        myJzvdStd = (TvVideoPlayerView) findViewById(R.id.jz_video);
        myJzvdStd.setUp(url, null);
//        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(myJzvdStd.thumbImageView);
        myJzvdStd.setOnKeyListener(this);

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

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (event.getKeyCode()) {
            default:
                break;
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE://确认
                toast(" 确认");
                break;

            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD://前进
                toast(" 前进");
                break;
            case KeyEvent.KEYCODE_MEDIA_REWIND://前退
                toast(" 前退");
                break;


        }
        return true;
    }

    private class JzMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public JzMenuAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_tvcount, item);

        }
    }
}