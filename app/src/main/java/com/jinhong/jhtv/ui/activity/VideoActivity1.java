package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :视频播放界面
 */
public class VideoActivity1 extends BaseActivity {

    private StandardGSYVideoPlayer mGsyPlayer;

    //    String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video2);
        initView();
    }

    private void initView() {
        mGsyPlayer = (StandardGSYVideoPlayer) findViewById(R.id.gsy_player);
        mGsyPlayer.setUp(url, true, "无标题");
        mGsyPlayer.startWindowFullscreen(this, false, false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键，快退
                toast("向左键");

                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键，快进
                toast("向右键");
                mGsyPlayer.seekTo(20000);

                break;


            default:
                break;
        }

        return super.onKeyDown(keyCode, event);


    }
}