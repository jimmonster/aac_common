package com.jinhong.jhtv.ui.widgets;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-18
 * @description :
 */
public class DialogUtils {


    private static volatile DialogUtils mInstance;
    private AlertDialog mDlg;

    Activity mActivity;


    public DialogUtils(Activity activity) {
        mActivity = activity;
        mDlg = new AlertDialog.Builder(activity).create();
        mDlg.setView(LayoutInflater.from(activity).inflate(
                R.layout.dialog_video_toast, null)); // 设置view

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

        if (!mDlg.isShowing()) {
            mDlg.show(); //显示出来
        }


        TextView tvEnd = (TextView) mDlg.findViewById(R.id.btn_exit);
        tvEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDlg.dismiss();
                mActivity.finish();
            }
        });

        TextView tvWatching = (TextView) mDlg.findViewById(R.id.btn_watching);
        tvWatching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDlg.dismiss();
            }
        });

        TextView tvNextCount = (TextView) mDlg.findViewById(R.id.btn_next);
        tvNextCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDlg.dismiss();
                mActivity.finish();

            }
        });

        return mDlg;
    }


}
