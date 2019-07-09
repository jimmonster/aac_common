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
            case KeyEvent.KEYCODE_DPAD_CENTER://确认
                toast(" 确认KEYCODE_DPAD_CENTER");
                break;
            case KeyEvent.KEYCODE_MEDIA_PLAY://播放
                toast("播放 KEYCODE_MEDIA_PLAY");
                mJzvdStd.onStatePlaying();
                break;
            case KeyEvent.KEYCODE_MEDIA_PAUSE://暂停
                toast("暂停 KEYCODE_MEDIA_PAUSE");
                mJzvdStd.onStatePause();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT://左键/快退
                toast(" 左键/快退KEYCODE_DPAD_LEFT");
                mJzvdStd.onStateAutoComplete();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT://右键//快进
                toast(" 右键//快进KEYCODE_DPAD_RIGHT");
                break;
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD://快进
                toast(" KEYCODE_MEDIA_FAST_FORWARD");
                break;
            case KeyEvent.KEYCODE_MEDIA_REWIND://上一集
                toast(" 上一集KEYCODE_MEDIA_REWIND");
                break;
            case KeyEvent.KEYCODE_MEDIA_NEXT://下一集
                toast(" 下一集KEYCODE_MEDIA_NEXT");
                break;

            case KeyEvent.KEYCODE_MEDIA_AUDIO_TRACK://下一集
                toast(" KEYCODE_MEDIA_AUDIO_TRACK");
                break;
            case KeyEvent.KEYCODE_MEDIA_CLOSE://下一集
                toast(" KEYCODE_MEDIA_CLOSE");
                break;
            case KeyEvent.KEYCODE_MEDIA_EJECT://下一集
                toast(" KEYCODE_MEDIA_EJECT");
                break;

            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE://下一集
                toast(" KEYCODE_MEDIA_PLAY_PAUSE");
                break;
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS://下一集
                toast(" KEYCODE_MEDIA_PREVIOUS");
                break;
            case KeyEvent.KEYCODE_MEDIA_RECORD://下一集
                toast(" KEYCODE_MEDIA_RECORD");
                break;
            case KeyEvent.KEYCODE_MEDIA_SKIP_BACKWARD://下一集
                toast(" KEYCODE_MEDIA_SKIP_BACKWARD");
                break;

            case KeyEvent.KEYCODE_MEDIA_SKIP_FORWARD://下一集
                toast(" KEYCODE_MEDIA_SKIP_FORWARD");
                break;

            case KeyEvent.KEYCODE_MEDIA_STEP_BACKWARD://下一集
                toast(" KEYCODE_MEDIA_STEP_BACKWARD");
                break;

            case KeyEvent.KEYCODE_MEDIA_STEP_FORWARD://下一集
                toast(" KEYCODE_MEDIA_STEP_FORWARD");
                break;
            case KeyEvent.KEYCODE_MEDIA_STOP://下一集
                toast(" KEYCODE_MEDIA_STOP");
                break;
            case KeyEvent.KEYCODE_MEDIA_TOP_MENU://下一集
                toast(" KEYCODE_MEDIA_TOP_MENU");
                break;

            case KeyEvent.KEYCODE_TV_MEDIA_CONTEXT_MENU://下一集
                toast(" KEYCODE_TV_MEDIA_CONTEXT_MENU");
                break;


        }
        return true;
    }
}
