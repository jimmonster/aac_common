package com.jinhong.jhtv.ui.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.ui.views.CustomJzvdStd;
import com.jinhong.jhtv.ui.widgets.DialogUtils;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import me.jessyan.autosize.internal.CancelAdapt;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :视频播放界面
 */
public class VideoActivity extends BaseActivity implements CancelAdapt, View.OnClickListener, ViewTreeObserver.OnGlobalFocusChangeListener {

    private static final String TAG = "VideoActivity";
    private CustomJzvdStd myJzvdStd;

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
    /**
     * 按确定键选集
     */
    private RelativeLayout mTvVideoTip;

    private ArrayList mTvCounts;


    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                default:
                    break;
                case 0x1:
                    mTvVideoTip.setVisibility(View.INVISIBLE);
                    break;


            }
        }
    };
    private AlertDialog mAlertDialog;
    private SeekBar mSeekBar;
    private ImageView mStart;
    private int mProgress = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initData();
        initView();
        View decorView = getWindow().getDecorView();
        View focus = decorView.findFocus();
        mRecyclerViewMenu.requestFocus();//让控件得到焦点
        Log.d("VideoActivity", "focus:" + focus);
//        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(myJzvdStd.thumbImageView);


    }

    private void initData() {
        mTvCounts = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            mTvCounts.add("" + i);
        }
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

    private void initView() {
        myJzvdStd = (CustomJzvdStd) findViewById(R.id.jz_video);
        //视频控件抢占焦点问题处理
        myJzvdStd.findViewById(R.id.surface_container).setFocusable(false);//整个videoView
        mSeekBar = myJzvdStd.findViewById(R.id.bottom_seek_progress);//进度条
        mProgress = mSeekBar.getProgress();//当前位置
        mStart = myJzvdStd.findViewById(R.id.start);//开始

        //加载视频链接
        myJzvdStd.setUp(url, null);
        // myJzvdStd.setOnKeyListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
        //必须在子类的根布局添加监听
        ViewTreeObserver viewTreeObserver = relativeLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalFocusChangeListener(this);

        mRecyclerViewMenu = (TvRecyclerView) findViewById(R.id.recyclerView_menu);
        mTvUpPage = (TextView) findViewById(R.id.tv_up_page);
        mTvUpPage.setOnClickListener(this);
        mTvNextPage = (TextView) findViewById(R.id.tv_next_page);
        mTvNextPage.setOnClickListener(this);
        //集数提示，确认时显示，确定集数时隐藏，并且重新加载新的视频链接
        mLlMenuContainer = (LinearLayout) findViewById(R.id.ll_menu_container);
        mLlMenuContainer.setVisibility(View.INVISIBLE);
        mTvVideoTip = (RelativeLayout) findViewById(R.id.tv_video_tip);
        mTvVideoTip.setVisibility(View.VISIBLE);
        mTvVideoTip.setOnClickListener(this);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x1;
                mHandler.sendMessage(message);
            }
        }, 5000);
        JzMenuAdapter jzMenuAdapter = new JzMenuAdapter(R.layout.widget_player_menu_item, mTvCounts);
        mRecyclerViewMenu.setAdapter(jzMenuAdapter);
        mLlMenuContainer.setVisibility(View.VISIBLE);
        jzMenuAdapter.bindToRecyclerView(mRecyclerViewMenu);
        jzMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast(position + "");
                //跳转到当前集数，并且关闭菜单
                mLlMenuContainer.setVisibility(View.INVISIBLE);
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_up_page:
                toast("上一页");
                DialogUtils.getInstance(this).show();
                break;
            case R.id.tv_next_page:
                toast("下一页");
                DialogUtils.getInstance(this).show().dismiss();
                break;

        }
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_ENTER:     //确定键enter
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.d(TAG, "enter--->");
                toast("确定键enter--->");

                break;
            case 0x0119://收藏
                Log.d(TAG, "收藏--->");
                toast("收藏--->");
                break;

            case KeyEvent.KEYCODE_BACK:    //返回键
                Log.d(TAG, "back--->");
                toast("返回键--->");
                return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层

            case KeyEvent.KEYCODE_SETTINGS: //设置键
                Log.d(TAG, "setting--->");
                toast("设置键--->");
                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键

                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
                 *    exp:KeyEvent.ACTION_UP
                 */
                if (event.getAction() == KeyEvent.ACTION_DOWN) {

                    Log.d(TAG, "down--->");
                    toast("向下键");
                }
                break;

            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
                Log.d(TAG, "up--->");
                toast("向上键");
                break;

            case KeyEvent.KEYCODE_0:   //数字键0
                Log.d(TAG, "0--->");
                toast("数字键0");
                break;
            case KeyEvent.KEYCODE_1:   //数字键1
                Log.d(TAG, "0--->");
                toast("数字键1");
                break;
            case KeyEvent.KEYCODE_2:   //数字键2
                Log.d(TAG, "0--->");
                toast("数字键2");
                break;
            case KeyEvent.KEYCODE_3:   //数字键3
                Log.d(TAG, "0--->");
                toast("数字键3");
                break;
            case KeyEvent.KEYCODE_4:   //数字键4
                Log.d(TAG, "0--->");
                toast("数字键4");
                break;
            case KeyEvent.KEYCODE_5:   //数字键5
                Log.d(TAG, "0--->");
                toast("数字键5");
                break;
            case KeyEvent.KEYCODE_6:   //数字键6
                Log.d(TAG, "0--->");
                toast("数字键6");
                break;
            case KeyEvent.KEYCODE_7:   //数字键7
                Log.d(TAG, "0--->");
                toast("数字键7");
                break;
            case KeyEvent.KEYCODE_8:   //数字键8
                Log.d(TAG, "0--->");
                toast("数字键8");
                break;
            case KeyEvent.KEYCODE_9:   //数字键9
                Log.d(TAG, "0--->");
                toast("数字键9");
                break;


            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键，快退


                toast("向左键");
                if (mProgress > 0) {
                    mProgress -= 10;
                }
                mSeekBar.setProgress(mProgress);
                Log.d(TAG, "left--->" + mProgress);
                myJzvdStd.seekToInAdvance = 100_000;
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键，快进

                toast("向右键");
                if (mProgress < 100) {
                    mProgress += 10;
                }

                mSeekBar.setProgress(mProgress);
                Log.d(TAG, "right--->" + mProgress);
                break;

            case KeyEvent.KEYCODE_INFO:    //info键
                Log.d(TAG, "info--->");
                toast("info键");
                break;

            case KeyEvent.KEYCODE_PAGE_DOWN:     //向上翻页键
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                Log.d(TAG, "page down--->");
                toast("向上翻页键");
                break;


            case KeyEvent.KEYCODE_PAGE_UP:     //向下翻页键
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                Log.d(TAG, "page up--->");
                toast("向下翻页键");
                break;

            case KeyEvent.KEYCODE_VOLUME_UP:   //调大声音键
                Log.d(TAG, "voice up--->");
                toast("调大声音键");
                break;

            case KeyEvent.KEYCODE_VOLUME_DOWN: //降低声音键
                Log.d(TAG, "voice down--->");
                toast("降低声音键");
                break;
            case KeyEvent.KEYCODE_VOLUME_MUTE: //禁用声音
                Log.d(TAG, "voice mute--->");
                toast("禁用声音");
                break;


            default:
                break;
        }

        return super.onKeyDown(keyCode, event);


    }


    private class JzMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public JzMenuAdapter(int layoutResId, @Nullable List<String> data) {
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