package com.jinhong.jhtv.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.views.JzVideoPlayer;
import com.jinhong.jhtv.utils.ImageUtils;

import cn.jzvd.Jzvd;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :视频播放界面
 */
public class VideoActivity extends BaseActivity implements View.OnKeyListener {

    private JzVideoPlayer mJzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
    }

    private void initView() {
        mJzvdStd = (JzVideoPlayer) findViewById(R.id.jz_video);
        mJzvdStd.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", "饺子闭眼睛");
        ImageUtils.load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640", mJzvdStd.thumbImageView);
        initEvent();

    }

    private void initEvent() {
        mJzvdStd.setOnKeyListener(this);

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
            case KeyEvent.KEYCODE_MEDIA_PLAY://播放
                mJzvdStd.onStatePlaying();
                break;
            case KeyEvent.KEYCODE_MEDIA_PAUSE://暂停
                mJzvdStd.onStatePause();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT://左键/快退
                mJzvdStd.onStateAutoComplete();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT://右键//快进
                break;
//            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD://快进
//                break;
//            case KeyEvent.KEYCODE_MEDIA_REWIND://快退
//                break;

        }
        return true;
    }
}
