package com.jinhong.jhtv.ui.views;

import android.content.Context;
import android.util.AttributeSet;

import com.jinhong.jhtv.CustomMedia.JZMediaExo;
import com.jinhong.jhtv.R;

import cn.jzvd.JzvdStd;


/**
 * @author :  Jim
 * @date :  2019-07-15
 * @description :通用的视频播放器自定义界面，默认切换成exo播放器
 */
public class TvVideoPlayerView extends JzvdStd {

    private JZMediaExo mJzMediaExo;

    public TvVideoPlayerView(Context context) {
        super(context);
        mJzMediaExo = new JZMediaExo(this);
        this.setMediaInterface(mJzMediaExo.getClass());
    }

    public TvVideoPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mJzMediaExo = new JZMediaExo(this);
        this.setMediaInterface(mJzMediaExo.getClass());
    }

    @Override
    public void init(Context context) {
        super.init(context);

    }




    @Override
    public int getLayoutId() {

        return R.layout.activity_video_player;
    }

    public void seekTo(long time){
        mJzMediaExo.seekTo(time);
    }




    @Override
    public void startVideo() {
        super.startVideo();
    }

    @Override
    public void setAllControlsVisiblity(int topCon, int bottomCon, int startBtn, int loadingPro, int thumbImg, int bottomPro, int retryLayout) {
        topContainer.setVisibility(topCon);
        bottomContainer.setVisibility(bottomCon);
        startButton.setVisibility(startBtn);
        loadingProgressBar.setVisibility(loadingPro);
        thumbImageView.setVisibility(thumbImg);
        bottomProgressBar.setVisibility(bottomPro);
        mRetryLayout.setVisibility(retryLayout);
    }


    @Override
    public void onVideoSizeChanged(int width, int height) {
        super.onVideoSizeChanged(width, height);
        if (textureView != null) {
            textureView.setVideoSize(textureViewContainer.getWidth(), textureViewContainer.getHeight());//视频大小与控件大小一致

        }
    }

    @Override
    public void changeUiToNormal() {
        super.changeUiToNormal();
    }

    @Override
    public void changeUiToPreparing() {
        super.changeUiToPreparing();
    }

    @Override
    public void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
    }

    @Override
    public void changeUiToPlayingClear() {
        super.changeUiToPlayingClear();
    }

    @Override
    public void changeUiToPauseShow() {
        super.changeUiToPauseShow();
    }

    @Override
    public void changeUiToPauseClear() {
        super.changeUiToPauseClear();
    }

    @Override
    public void changeUiToComplete() {
        super.changeUiToComplete();
    }

    @Override
    public void changeUiToError() {
        super.changeUiToError();
    }
}