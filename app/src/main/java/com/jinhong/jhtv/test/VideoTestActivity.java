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

import me.jessyan.autosize.internal.CancelAdapt;

/**
 * @author :  Jim
 * @date :  2019-07-18
 * @description :
 */
public class VideoTestActivity extends BaseActivity implements CancelAdapt {

    private static final String TAG = "VideoTestActivity";

    //    String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";


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


            }
        }
    };
    private SeekBar mSeekBar;


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
        mSeekBar = (SeekBar) findViewById(R.id.bottom_seek_progress);
//        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                long time = seekBar.getProgress() * mJzvdStd.getDuration() / 100;
//                seekBar.getProgress();
//                mJzvdStd.mediaInterface.seekTo(time);
//
//            }
//        });
//        //当前播放位置的监听
//        mJzvdStd.seekToInAdvance = 60000;
//        //保存当前播放的进度
//        Jzvd.SAVE_PROGRESS = true;//把这些注释的代码放到按钮上，让它可操作可见。

    }

    long currentTime;

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
                int progress = mSeekBar.getProgress();
                progress-=10000;
                mJzvdStd.mediaInterface.seekTo(300000);
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键，快进
                toast("向右键");

                progress = mSeekBar.getProgress();
                progress+=10000;
                //todo 快进快退接口实现
                mJzvdStd.mediaInterface.seekTo(100000);

                break;


            default:
                break;
        }

        return super.onKeyDown(keyCode, event);


    }


}
