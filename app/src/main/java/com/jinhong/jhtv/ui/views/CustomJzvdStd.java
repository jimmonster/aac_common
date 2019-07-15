package com.jinhong.jhtv.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jinhong.jhtv.CustomMedia.JZMediaExo;
import com.jinhong.jhtv.R;

import cn.jzvd.JzvdStd;

/**
 * @author :  Jim
 * @date :  2019-07-15
 * @description :通用的视频播放器自定义界面，默认切换成exo播放器
 */
public class CustomJzvdStd extends JzvdStd {
    public OCompleteListener mCompleteListener;
    private RelativeLayout mLlTip;


    public CustomJzvdStd(Context context) {
        super(context);
        this.setMediaInterface(JZMediaExo.class);
    }

    public CustomJzvdStd(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setMediaInterface(JZMediaExo.class);
    }

    public static boolean SAVE_PROGRESS = false;

    public CustomJzvdStd(Context context, AttributeSet attributeSet, OCompleteListener onCompleterListener) {
        super(context, attributeSet);
        this.setMediaInterface(JZMediaExo.class);
        mCompleteListener = onCompleterListener;
    }

    @Override
    public void init(Context context) {
        super.init(context);
//        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR;
        mLlTip = (RelativeLayout) findViewById(R.id.ll_tip);
        mLlTip.setVisibility(INVISIBLE);
        mLlTip.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ll_tip:
                Toast.makeText(getContext(), "显示选集列表", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }


    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        if (mCompleteListener != null) {
            mCompleteListener.onComplete();
        }

    }


    @Override
    public int getLayoutId() {

        return R.layout.activity_video_player;
    }


    @Override
    public void startVideo() {
        super.startVideo();
    }

    @Override
    public void setAllControlsVisiblity(int topCon, int bottomCon, int startBtn, int loadingPro, int thumbImg, int bottomPro, int retryLayout) {
//        super.setAllControlsVisiblity(topCon, bottomCon, startBtn, loadingPro, thumbImg, bottomPro, retryLayout);
        topContainer.setVisibility(topCon);
        bottomContainer.setVisibility(bottomCon);
        startButton.setVisibility(startBtn);
        loadingProgressBar.setVisibility(loadingPro);
        thumbImageView.setVisibility(thumbImg);
//        bottomProgressBar.setVisibility(bottomPro);
        mRetryLayout.setVisibility(retryLayout);
    }

    public boolean isPlay() {
        return state == STATE_PLAYING || state == STATE_PREPARING || state == -1;

    }


    public interface OCompleteListener {
        void onComplete();

        void onError(int what, int extra);

    }

    //    @Override
    //    public void setUp(String url, String title) {
    //        super.setUp(url, title);
    //        HttpProxyCacheServer proxyCacheServer = MyApplication.getProxy();
    //        String proxyUrl = proxyCacheServer.getProxyUrl(url);
    //        super.setUp(proxyUrl, title);
    //    }


    @Override
    public void onError(int what, int extra) {
        super.onError(what, extra);
    }


    public void setOnCompleterListener(OCompleteListener onCompleterListener) {
        mCompleteListener = onCompleterListener;
    }

    @Override
    public void onVideoSizeChanged(int width, int height) {
        super.onVideoSizeChanged(width, height);
        if (textureView != null) {

            textureView.setVideoSize(textureViewContainer.getWidth(), textureViewContainer.getHeight());//视频大小与控件大小一致

        }
    }

    /**
     * public ImageView backButton;
     * public ProgressBar bottomProgressBar, loadingProgressBar;
     * public TextView titleTextView;
     * public ImageView thumbImageView;
     * public ImageView tinyBackImageView;
     * public LinearLayout batteryTimeLayout;
     * public ImageView batteryLevel;
     * public TextView videoCurrentTime;
     * public TextView replayTextView;
     * public TextView clarity;
     * public PopupWindow clarityPopWindow;
     * public TextView mRetryBtn;
     * public LinearLayout mRetryLayout;
     * protected DismissControlViewTimerTask mDismissControlViewTimerTask;
     * protected Dialog mProgressDialog;
     * protected ProgressBar mDialogProgressBar;
     * protected TextView mDialogSeekTime;
     * protected TextView mDialogTotalTime;
     * protected ImageView mDialogIcon;
     * protected Dialog mVolumeDialog;
     * protected ProgressBar mDialogVolumeProgressBar;
     * protected TextView mDialogVolumeTextView;
     * protected ImageView mDialogVolumeImageView;
     * protected Dialog mBrightnessDialog;
     * protected ProgressBar mDialogBrightnessProgressBar;
     * protected TextView mDialogBrightnessTextView;
     */

    @Override
    public void changeUiToNormal() {
        super.changeUiToNormal();
        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.INVISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.INVISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }

    }


    @Override
    public void changeUiToPreparing() {
        super.changeUiToPreparing();

        switch (screen) {
            case SCREEN_NORMAL:
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE,
                        View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }
    }

    private void changeVisiblityUI(int visible) {
        mLlTip.setVisibility(visible);
    }

    @Override
    public void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
        //播放时显示界面

        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(VISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.VISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(VISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.VISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }
    }

    @Override
    public void changeUiToPlayingClear() {
        super.changeUiToPlayingClear();

        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }
    }

    @Override
    public void changeUiToPauseShow() {
        super.changeUiToPauseShow();
        //暂停时显示界面
        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(VISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.VISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(VISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.VISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }
    }

    @Override
    public void changeUiToPauseClear() {
        super.changeUiToPauseClear();

        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }
    }

    @Override
    public void changeUiToComplete() {
        super.changeUiToComplete();

        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.INVISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.INVISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }

    }

    @Override
    public void changeUiToError() {

        switch (screen) {
            case SCREEN_NORMAL:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.INVISIBLE, View.INVISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_FULLSCREEN:
                changeVisiblityUI(INVISIBLE);
                setAllControlsVisiblity(View.VISIBLE, View.INVISIBLE, View.VISIBLE,
                        View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
                updateStartImageImp();
                break;
            case SCREEN_TINY:
                break;
            default:
                changeVisiblityUI(INVISIBLE);
                break;
        }

    }

    //更改UI界面
    public void updateStartImageImp() {
        if (state == STATE_PLAYING) {
            //暂停
            startButton.setVisibility(VISIBLE);
            startButton.setImageResource(R.drawable.ic_video_play);
            replayTextView.setVisibility(GONE);
        } else if (state == STATE_ERROR) {
            //出错
            startButton.setVisibility(INVISIBLE);
            replayTextView.setVisibility(GONE);
        } else if (state == STATE_AUTO_COMPLETE) {
            //重试
            startButton.setVisibility(VISIBLE);
            startButton.setImageResource(R.drawable.ic_autorenew_black_24dp);
            replayTextView.setVisibility(VISIBLE);
        } else {
            //播放

            startButton.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
            replayTextView.setVisibility(GONE);
        }
    }
}
