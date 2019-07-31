package com.jinhong.jhtv.test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.views.TvVideoPlayerView;
import com.jinhong.jhtv.ui.widgets.DialogUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.Timer;
import java.util.TimerTask;

import cn.jzvd.JZMediaInterface;
import cn.jzvd.JZUtils;
import me.jessyan.autosize.internal.CancelAdapt;

/**
 * @author :  Jim
 * @date :  2019-07-18
 * @description :饺子播放器，已废弃
 */

@Deprecated
public class VideoTestActivity extends BaseActivity implements CancelAdapt {

    private static final String TAG = "VideoTestActivity";

    //    String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
    public int seekBarProgress = 0;
    public int seekBarCurrent = 0;
    public int seekBarTotal = 0;

    private TvRecyclerView mRecyclerViewMenu;
    /**
     * 上一页
     */
    private TextView mTvUpPage;
    /**
     * 下一页
     */
    private TextView mTvNextPage;
    private LinearLayout mLlMenuContainer;
    private TvVideoPlayerView mJzvdStd;
    private RelativeLayout mRl_menu_tip;
    public int state = -1;
    


    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                default:
                    break;
                case 0x1:
                    mRl_menu_tip.setVisibility(View.INVISIBLE);
                    break;
                case 0x2:
                    seekBarCurrent = msg.arg1;
                    seekBarProgress = msg.arg2;
                   // setSeekBar(seekBarCurrent, 0, seekBarProgress);
                    break;


            }
        }
    };
    private SeekBar mSeekBar;
    private TextView mCurrent;
    private TextView mTotal;
    private SeekBarTimerTask mSeekBarTimerTask;
    private JZMediaInterface mMediaInterface;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);
        initView();
        initData();
    }

    private void initData() {
        mJzvdStd.setUp(url, null);
        mJzvdStd.startVideo();
        Timer timer = new Timer();
        timer.schedule(new SeekBarTimerTask(), 0, 300);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x1;
                mHandler.sendMessage(message);
            }
        }, 5000);

    }

    private void initView() {
        mRecyclerViewMenu = (TvRecyclerView) findViewById(R.id.recyclerView_menu);
        mRl_menu_tip = (RelativeLayout) findViewById(R.id.rl_menu_tip);

        mTvUpPage = (TextView) findViewById(R.id.tv_up_page);
        mTvNextPage = (TextView) findViewById(R.id.tv_next_page);
        mLlMenuContainer = (LinearLayout) findViewById(R.id.ll_menu_container);
        mJzvdStd = (TvVideoPlayerView) findViewById(R.id.jz_video);
        mJzvdStd.findViewById(R.id.surface_container).setFocusable(false);//整个videoView
        mSeekBar = (SeekBar) findViewById(R.id.seekbar_progress);//滚动条
        mSeekBar.setMax(100);
        mSeekBar.setProgress(0);
        mCurrent = (TextView) findViewById(R.id.tv_current);
        mTotal = (TextView) findViewById(R.id.tv_total);
        mMediaInterface = mJzvdStd.mediaInterface;
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged:" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch:" );
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch:" );
            }
        });


    }

    public class SeekBarTimerTask extends TimerTask {

        @Override
        public void run() {
            seekBarCurrent = (int) mJzvdStd.getCurrentPositionWhenPlaying();
            seekBarTotal = (int) mJzvdStd.getDuration();
            seekBarProgress = (int) (seekBarCurrent * 100 / (seekBarTotal == 0 ? 1 : seekBarTotal));
            //不能在子线程更新UI
            Message message = mHandler.obtainMessage();
            message.what = 0x2;//进度条消息；
            message.arg1 = seekBarCurrent;
            message.arg2 = seekBarProgress;
            mHandler.sendMessage(message);
        }
    }


    private void setSeekBar(long currentTime, long duration, int progress) {
//        if (progress != 0) {
////            mSeekBar.setProgress(progress);
////        }
        if (currentTime != 0) {
            mCurrent.setText(JZUtils.stringForTime(currentTime));
        }
        if (duration != 0) {
            mTotal.setText(JZUtils.stringForTime(duration));
        } else {
            mTotal.setText(JZUtils.stringForTime(mJzvdStd.getDuration()));

        }

        mMediaInterface.seekTo(currentTime);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_ENTER:     //确定键enter
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.d(TAG, "enter--->");
                toast("确定键enter--->");
                mLlMenuContainer.setVisibility(View.VISIBLE);

                break;

            case KeyEvent.KEYCODE_BACK:    //返回键
                Log.d(TAG, "back--->");
                toast("返回键--->");
                //弹窗推荐内容
                DialogUtils.getInstance(this).show();
                return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层


            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键，快退
                toast("向左键");

                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键，快进
                toast("向右键");


                break;


            default:
                break;
        }

        return super.onKeyDown(keyCode, event);


    }

    private void test() {

            int seekBarProgress = mSeekBar.getProgress();
            int totalTimeDuration = (int)mJzvdStd.getDuration();
            String seekTime = JZUtils.stringForTime(seekBarProgress);
            String totalTime = JZUtils.stringForTime(totalTimeDuration);

            mJzvdStd.showProgressDialog(1, seekTime, seekBarProgress, totalTime, totalTimeDuration);

//        if (mChangeVolume) {
//            deltaY = -deltaY;
//            int max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//            int deltaV = (int) (max * deltaY * 3 / mScreenHeight);
//            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mGestureDownVolume + deltaV, 0);
//            //dialog中显示百分比
//            int volumePercent = (int) (mGestureDownVolume * 100 / max + deltaY * 3 * 100 / mScreenHeight);
//            showVolumeDialog(-deltaY, volumePercent);
//        }

//        if (mChangeBrightness) {
//            deltaY = -deltaY;
//            int deltaV = (int) (255 * deltaY * 3 / mScreenHeight);
//            WindowManager.LayoutParams params = JZUtils.getWindow(getContext()).getAttributes();
//            if (((mGestureDownBrightness + deltaV) / 255) >= 1) {//这和声音有区别，必须自己过滤一下负值
//                params.screenBrightness = 1;
//            } else if (((mGestureDownBrightness + deltaV) / 255) <= 0) {
//                params.screenBrightness = 0.01f;
//            } else {
//                params.screenBrightness = (mGestureDownBrightness + deltaV) / 255;
//            }
//            JZUtils.getWindow(getContext()).setAttributes(params);
//            //dialog中显示百分比
//            int brightnessPercent = (int) (mGestureDownBrightness * 100 / 255 + deltaY * 3 * 100 / mScreenHeight);
//            showBrightnessDialog(brightnessPercent);
////                        mDownY = y;
//        }
    }


}
