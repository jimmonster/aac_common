package com.jinhong.jhtv.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.CustomMedia.BaseGSYVideoPlayer;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.UpdateBookmarkBean;
import com.jinhong.jhtv.ui.widgets.GSYPlayView;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :视频播放界面
 */
public class VideoActivity1 extends BaseActivity {

    private BaseGSYVideoPlayer mGsyPlayer;

    //        String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
//    String url = "http://ivi.bupt.edu.cn/hls/hunantv.m3u8";
    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
    String url1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
    String url2 = "http://202.99.114.93/88888891/16/20190905/270840647/270840647.ts";
    private GSYVideoViewBridge mGsyVideoManager;//视频管理
    private GSYVideoOptionBuilder mGsyVideoOption;//配置工具
    private RelativeLayout mRlVideoTip;
    private TvRecyclerView mRecyclerViewMenu;
    private ArrayList mTvCounts;

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
    private SeekBar mSeekBar;
    private MutableLiveData<UpdateBookmarkBean> mUpdateBookmarkBean;
    private String mUserId;
    private String mFatherId;
    private String mContentId;
    private String mMainName;
    private String mContemainNamentName;
    private String mDramaType;
    private String mSort;

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


        Bundle bundleExtra = getIntent().getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            url = bundleExtra.getString("playUrl", "");
            mUserId = bundleExtra.getString("userId", "");
            mFatherId = bundleExtra.getString("fatherId", "");
            mContentId = bundleExtra.getString("contentId", "");
            mMainName = bundleExtra.getString("mainName", "");
            mContemainNamentName = bundleExtra.getString("contemainNamentName", "");
            mDramaType = bundleExtra.getString("dramaType", "");
            mSort = bundleExtra.getString("sort", "");

        }

    }


    private void initView() {

        mRlVideoTip = (RelativeLayout) findViewById(R.id.rl_video_tip);
        mRlVideoTip.setVisibility(View.VISIBLE);
        mRecyclerViewMenu = (TvRecyclerView) findViewById(R.id.recyclerView_menu);

        mLlMenuContainer = (LinearLayout) findViewById(R.id.ll_menu_container);

        mGsyPlayer = (BaseGSYVideoPlayer) findViewById(R.id.gsy_player);


        mStart = (GSYPlayView) mGsyPlayer.findViewById(R.id.start);
        mSeekBar = mGsyPlayer.findViewById(R.id.progress);
        Drawable thumb = getResources().getDrawable(R.drawable.ic_video_volume_button);
        Drawable progressDrawable = getResources().getDrawable(R.drawable.seek_player_progress);
        mGsyVideoManager = mGsyPlayer.getGSYVideoManager();
        mGsyPlayer.setBottomShowProgressBarDrawable(progressDrawable, thumb);
        mGsyPlayer.setUp(url, true, null);
        //上传观影记录
        upDateRecord(mUserId, mFatherId, mContentId, mMainName, mContemainNamentName, mDramaType, mSort);

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

        mGsyPlayer.setVideoAllCallBack(new VideoAllCallBack() {
            @Override
            public void onStartPrepared(String url, Object... objects) {

            }

            @Override
            public void onPrepared(String url, Object... objects) {

            }

            @Override
            public void onClickStartIcon(String url, Object... objects) {

            }

            @Override
            public void onClickStartError(String url, Object... objects) {

            }

            @Override
            public void onClickStop(String url, Object... objects) {

            }

            @Override
            public void onClickStopFullscreen(String url, Object... objects) {

            }

            @Override
            public void onClickResume(String url, Object... objects) {

            }

            @Override
            public void onClickResumeFullscreen(String url, Object... objects) {

            }

            @Override
            public void onClickSeekbar(String url, Object... objects) {

            }

            @Override
            public void onClickSeekbarFullscreen(String url, Object... objects) {

            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                //播放完毕
                showDialogForExit("播放结束，自动为您播放下一集...", true);
            }

            @Override
            public void onEnterFullscreen(String url, Object... objects) {

            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {

            }

            @Override
            public void onQuitSmallWidget(String url, Object... objects) {

            }

            @Override
            public void onEnterSmallWidget(String url, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekVolume(String url, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekPosition(String url, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekLight(String url, Object... objects) {

            }

            @Override
            public void onPlayError(String url, Object... objects) {
                //播放错误


            }

            @Override
            public void onClickStartThumb(String url, Object... objects) {

            }

            @Override
            public void onClickBlank(String url, Object... objects) {

            }

            @Override
            public void onClickBlankFullscreen(String url, Object... objects) {

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
        int visibility = mLlMenuContainer.getVisibility();
        if (visibility == View.VISIBLE) {
            mLlMenuContainer.setVisibility(View.INVISIBLE);
        } else {
            showDialogForExit("确定退出当前影片？", false);
        }

//        //释放所有
//        mGsyPlayer.setVideoAllCallBack(null);
//        GSYVideoManager.releaseAllVideos();
        //弹出对话框

        // super.onBackPressed();

    }

    private void upDateRecord(String userId, String fatherId, String contentId, String mainName, String contemainNamentName, String dramaType, String sort) {
        long seekOnStart = mGsyPlayer.getSeekOnStart();
        //上传观影记录
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("fatherId", fatherId);
        params.put("contentId", contentId);
        params.put("mainName", mainName);
        params.put("contemainNamentName", contemainNamentName);
        params.put("dramaType", dramaType);
        params.put("sort", sort);
        params.put("duration", Long.toString(seekOnStart));
        mUpdateBookmarkBean = mCommonViewModel.getUpdateBookmarkBean(params);
//                mGsyVideoManager.he
    }

    /**
     * 弹窗
     *
     * @param messages
     * @param isNext   是否可以直接播放下一集
     */
    private void showDialogForExit(String messages, Boolean isNext) {

        Dialog mDialog = new Dialog(this, R.style.video_style_dialog_progress);
        mDialog.setContentView(R.layout.dialog_video_toast);
        TextView mTvMessage = mDialog.findViewById(R.id.tv_message);
        mTvMessage.setText(messages);
        Button mBtnExit = mDialog.findViewById(R.id.btn_exit);
        Button mBtnWatching = mDialog.findViewById(R.id.btn_watching);

        Button mBtnNext = mDialog.findViewById(R.id.btn_next);
        mBtnNext.requestFocus();
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出当前页面
                endWatch();

            }
        });
        mBtnWatching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //继续观看
                mDialog.dismiss();
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 加载下一集
                mGsyPlayer.setUp(url1, true, null);
                mGsyPlayer.startPlayLogic();

                mDialog.dismiss();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDialog.create();
        }
        mDialog.show();

        //可以自动播放下一集
        if (isNext) {
//            RunnableUtil.Companion.start(mBtnNext);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBtnNext.performClick();
                    mDialog.dismiss();
                }
            }, 2000);


        }


    }


    /**
     * 结束播放
     */
    private void endWatch() {
        //释放所有
        mGsyPlayer.setVideoAllCallBack(null);
        GSYVideoManager.releaseAllVideos();
        finish();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键，快退
            case 0x0025:
                int visibility = mLlMenuContainer.getVisibility();
                seekControl(false, visibility);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键，快进
            case 0x0027:
                visibility = mLlMenuContainer.getVisibility();
                seekControl(true, visibility);
                break;
            case KeyEvent.KEYCODE_DPAD_UP://向上键，上一集
            case 0x0021:
                //todo 上一集
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN://向下键，下一集
            case 0x0022:
                //todo 下一集

                break;

            case KeyEvent.KEYCODE_ENTER:     //确定键，暂停播放
            case KeyEvent.KEYCODE_DPAD_CENTER:
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
                visibility = mLlMenuContainer.getVisibility();
                if (visibility == View.VISIBLE) {
                    mLlMenuContainer.setVisibility(View.INVISIBLE);
                } else {
                    mLlMenuContainer.setVisibility(View.VISIBLE);
                }
                break;

            case KeyEvent.KEYCODE_0:
                //todo 模拟菜单
                //获取到焦点
                mRecyclerViewMenu.requestFocus(R.id.gsy_player);
                visibility = mLlMenuContainer.getVisibility();
                if (visibility == View.VISIBLE) {
                    mLlMenuContainer.setVisibility(View.INVISIBLE);
                } else {
                    mLlMenuContainer.setVisibility(View.VISIBLE);
                }
                break;


            case KeyEvent.KEYCODE_9:
                //todo 模拟确认键
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
                if (duration > currentPosition) {
                    mGsyVideoManager.seekTo(currentPosition + 5_000);
                }
            } else {
                currentPosition -= 5_000;//快退5S
                if (duration > currentPosition) {
                    mGsyVideoManager.seekTo(currentPosition);
                }
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
            FocusUtils.onFocusChange(helper.itemView, R.drawable.selector_video_menu);
            helper.setText(R.id.tv_tvcount, item);

        }
    }
}