package com.jinhong.jhtv.ui.widgets;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-18
 * @description :
 */
public class DialogUtils {


    private static volatile DialogUtils mInstance;
    private AlertDialog mDlg;
    private Activity activity;

    public DialogUtils(Activity a) {
        activity = a;
    }

    public static DialogUtils getInstance(Activity activity) {
        if (mInstance == null) {
            synchronized (DialogUtils.class) {
                if (mInstance == null) {
                    mInstance = new DialogUtils(activity);
                }
            }
        }
        return mInstance;
    }

    public AlertDialog show() {
        mDlg = new AlertDialog.Builder(activity).create();


        mDlg.setView(LayoutInflater.from(activity).inflate(
                R.layout.dialog_video_toast, null)); // 设置view

        mDlg.show(); //显示出来

        TextView tvEnd = (TextView) mDlg.findViewById(R.id.tv_end);
        tvEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //结束播放
                Toast.makeText(activity, "结束播放", Toast.LENGTH_SHORT).show();
                mDlg.dismiss();
                activity.finish();
            }
        });

        TextView tvWatching = (TextView) mDlg.findViewById(R.id.tv_watching);
        tvWatching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //继续观看
                Toast.makeText(activity, "继续观看", Toast.LENGTH_SHORT).show();
                mDlg.dismiss();
            }
        });

        TextView tvNextCount = (TextView) mDlg.findViewById(R.id.tv_next_count);
        tvNextCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下一集
                Toast.makeText(activity, "下一集", Toast.LENGTH_SHORT).show();
                mDlg.dismiss();
                activity.finish();

            }
        });

        return mDlg;
    }


}
