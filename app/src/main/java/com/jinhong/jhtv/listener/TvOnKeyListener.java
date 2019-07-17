package com.jinhong.jhtv.listener;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.jinhong.jhtv.utils.RemoteControlKeyEvent;

/**
 * @author :  Jim
 * @date :  2019-07-17
 * @description :
 */
public abstract class TvOnKeyListener implements View.OnKeyListener {

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        RemoteControlKeyEvent instance = RemoteControlKeyEvent.getInstance();
        switch (event.getKeyCode()) {
            default:
                break;
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE://确认
                toast(" 确认");
                break;
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD://前进
                toast(" 前进");
                break;
            case KeyEvent.KEYCODE_MEDIA_REWIND://前退
                toast(" 前退");
                break;

            case 0x000D://进入
                toast(" 进入");
                break;

            case 0x0008://返回
                toast(" 返回");
                break;

            case 0x0021://上
                toast(" 上");
                break;

            case 0x0022://下
                toast(" 下");
                break;

            case 0x0025://左
                toast(" 左");
                break;

            case 0x0027://右
                toast(" 右");
                break;

            case KeyEvent.ACTION_DOWN://下
                toast(" ACTION_DOWN下");
                break;
            case KeyEvent.ACTION_UP://上
                toast(" ACTION_UP上");
                break;


        }
        return true;
    }

    private void toast(String s) {
        Toast.makeText(ActivityUtils.getTopActivity(), s, Toast.LENGTH_SHORT).show();
    }
}
