package com.jinhong.jhtv.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.jinhong.jhtv.utils.FocusUtils;

import static cn.jzvd.Jzvd.TAG;
import static com.jinhong.jhtv.base.JhBaseActivity.SYSTEM_DIALOG_REASON_HOME_KEY;
import static com.jinhong.jhtv.base.JhBaseActivity.SYSTEM_DIALOG_REASON_KEY;

/**
 * @author :  Jim
 * @date :  2019-07-17
 * @description :
 */
public class JhBaseActivity extends BaseActivity implements ViewTreeObserver.OnGlobalFocusChangeListener {

    private static final String TAG = "JhBaseActivity";
    public static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    public static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须在子类的根布局添加监听
//        ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
//        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        //监听全局的焦点问题
        Log.d("VideoActivity", "oldFocus:" + oldFocus + "\n----newFocus" + newFocus);
        if (newFocus == null) {
            return;
        }
        if (oldFocus != null) {
            FocusUtils.unselected(oldFocus);
        }
        FocusUtils.selected(newFocus);

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


            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键

                Log.d(TAG, "left--->");
                toast("向左键");
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                Log.d(TAG, "right--->");
                toast("向右键");
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


}

class HomeRecaiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {

            String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
            if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                Toast.makeText(ActivityUtils.getTopActivity(), "home键触发", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "home键触发");
            }
        }
    }

}
