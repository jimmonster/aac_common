package com.jinhong.jhtv.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.views.BaseGSYVideoPlayer;
import com.jinhong.jhtv.ui.widgets.DialogUtils;
import com.jinhong.jhtv.ui.widgets.GSYPlayView;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :视频播放界面
 */
public class VideoActivity1 extends BaseActivity {

    private BaseGSYVideoPlayer mGsyPlayer;

    //    String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
//    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
    String url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
    private GSYVideoViewBridge mGsyVideoManager;//视频管理
    private GSYVideoOptionBuilder mGsyVideoOption;//配置工具
    private RelativeLayout mRlVideoTip;
    private TvRecyclerView mRecyclerViewMenu;
    private ArrayList mTvCounts;
    /**
     * 上一页
     */
    private TextView mTvUpPage;
    /**
     * 下一页
     */
    private TextView mTvNextPage;
    private LinearLayout mLlMenuContainer;
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                default:
                    break;
                case 0x1:
                    mRlVideoTip.setVisibility(View.INVISIBLE);
                    break;

            }
        }
    };
    private GSYPlayView mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video2);
        initData();

        initView();
    }

    private void initData() {
        mTvCounts = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            mTvCounts.add("" + i);
        }
    }

    private void initView() {

        mRlVideoTip = (RelativeLayout) findViewById(R.id.rl_video_tip);
        mRecyclerViewMenu = (TvRecyclerView) findViewById(R.id.recyclerView_menu);
        mTvUpPage = (TextView) findViewById(R.id.tv_up_page);
        mTvNextPage = (TextView) findViewById(R.id.tv_next_page);
        mLlMenuContainer = (LinearLayout) findViewById(R.id.ll_menu_container);

        mGsyPlayer = (BaseGSYVideoPlayer) findViewById(R.id.gsy_player);
        mStart = (GSYPlayView)mGsyPlayer.findViewById(R.id.start);
        Drawable thumb = getResources().getDrawable(R.drawable.ic_video_volume_button);
        Drawable progressDrawable = getResources().getDrawable(R.drawable.seek_player_progress);
        mGsyVideoManager = mGsyPlayer.getGSYVideoManager();
        mGsyVideoOption = new GSYVideoOptionBuilder();
        mGsyVideoOption
//                .setThumbImageView(imageView) //设置封面
                .setBottomShowProgressBarDrawable(progressDrawable, thumb)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(true)
                .setShowFullAnimation(true)
                .setNeedLockFull(false)
                .setUrl(url)
                .setPlayTag(url)
//                .setMapHeadData(header)
                .setCacheWithPlay(false)
                .setVideoTitle(null)
//                .setSeekOnStart(0)//从哪里开始播放
//                .setGSYVideoProgressListener(new GSYVideoProgressListener() {
//                    @Override
//                    public void onProgress(int progress, int secProgress, int currentPosition, int duration) {
//                      //进度条回调
//                        Debuger.printfLog(" progress " + progress + " secProgress " + secProgress + " currentPosition " + currentPosition + " duration " + duration);
//                    }
//                })

                .build(mGsyPlayer);
        //自动播放
        mGsyPlayer.startPlayLogic();

        //几秒后不显示提示
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x1;
                mHandler.sendMessage(message);
            }
        }, 5000);
        GSYMenuAdapter gsyMenuAdapter = new GSYMenuAdapter(R.layout.widget_player_menu_item, mTvCounts);
        mRecyclerViewMenu.setAdapter(gsyMenuAdapter);
        gsyMenuAdapter.bindToRecyclerView(mRecyclerViewMenu);
        gsyMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast(position + "");
                //跳转到当前集数，并且关闭菜单
                mLlMenuContainer.setVisibility(View.INVISIBLE);
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        mGsyPlayer.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGsyPlayer.onVideoResume();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {

        //释放所有
        mGsyPlayer.setVideoAllCallBack(null);
        GSYVideoManager.releaseAllVideos();
        //弹出对话框
        DialogUtils.getInstance(this).show();
        // super.onBackPressed();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键，快退
                int visibility = mLlMenuContainer.getVisibility();
                seekControl(false, visibility);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键，快进
                visibility = mLlMenuContainer.getVisibility();
                seekControl(true, visibility);

                break;

            case KeyEvent.KEYCODE_ENTER:     //确定键，暂停播放
            case KeyEvent.KEYCODE_DPAD_CENTER:
                toast("暂停播放");
                if (mGsyVideoManager.isPlaying()) {
                    mGsyVideoManager.pause();
                    mStart.pause();
                } else {
                    mGsyVideoManager.start();
                    mStart.play();
                }
                break;

            case KeyEvent.KEYCODE_MENU://菜单键
                mRecyclerViewMenu.requestFocus(R.id.gsy_player);
                toast("菜单键");

                visibility = mLlMenuContainer.getVisibility();
                if (visibility == View.VISIBLE) {
                    mLlMenuContainer.setVisibility(View.INVISIBLE);
                } else {
                    mLlMenuContainer.setVisibility(View.VISIBLE);
                }
                break;

            case KeyEvent.KEYCODE_0:
                //todo 模拟菜单键
                //获取到焦点
                mRecyclerViewMenu.requestFocus(R.id.gsy_player);
                toast("KEYCODE_NUMPAD_0");

                visibility = mLlMenuContainer.getVisibility();
                if (visibility == View.VISIBLE) {
                    mLlMenuContainer.setVisibility(View.INVISIBLE);
                } else {
                    mLlMenuContainer.setVisibility(View.VISIBLE);
                }
                break;


            case KeyEvent.KEYCODE_9:
                //模拟确认键
                toast("暂停播放");
                if (mGsyVideoManager.isPlaying()) {
                    mGsyVideoManager.pause();
                    mStart.pause();
                } else {
                    mGsyVideoManager.start();
                    mStart.play();
                }
                break;


            default:
                break;
        }

        return super.onKeyDown(keyCode, event);


    }

    /**
     * @param isAdd 是否是快进or快退
     */
    private void seekControl(boolean isAdd, int visibility) {
        if (visibility == View.INVISIBLE) {
            //全部时长
            long duration = mGsyVideoManager.getDuration();
            //当前时长
            long currentPosition = mGsyVideoManager.getCurrentPosition();
            if (isAdd) {
                currentPosition += 5_000;//快退5S
            } else {
                currentPosition -= 5_000;//快退5S
            }
            if (duration > currentPosition) {
                mGsyVideoManager.seekTo(currentPosition);
            }


        }

    }


    private class GSYMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public GSYMenuAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            TextView view = (TextView) helper.getView(R.id.tv_tvcount);
            helper.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        view.setTextColor(Color.WHITE);
                        FocusUtils.selected(v, R.drawable.iv_player_circle_f);
                    } else {
                        view.setTextColor(Color.BLACK);
                        FocusUtils.unselected(v, R.drawable.iv_player_circle);
                    }
                }
            });
            helper.setText(R.id.tv_tvcount, item);

        }
    }
}