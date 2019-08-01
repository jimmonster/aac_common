package com.jinhong.jhtv.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-08-01
 * @description :
 */
public class CommonDialog {

    private static volatile CommonDialog mInstance;
    private Dialog mDialog;
    private final TextView mTvMessage;
    private final Button mBtnSure;
    private final Button mBtnCancel;


    private CommonDialog(Context activity) {
        mDialog = new Dialog(activity, R.style.video_style_dialog_progress);
        mDialog.setContentView(R.layout.dialog_common);
        mTvMessage = mDialog.findViewById(R.id.tv_message);
        mBtnSure = mDialog.findViewById(R.id.btn_sure);
        mBtnCancel = mDialog.findViewById(R.id.btn_cancel);
        mBtnCancel.requestFocus();
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 请求取消收藏接口

                mDialog.dismiss();

            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDialog.dismiss();
            }
        });
        mDialog.create();

    }

    public static CommonDialog getInstance(Context activity) {
        if (mInstance == null) {
            synchronized (CommonDialog.class) {
                if (mInstance == null) {
                    mInstance = new CommonDialog(activity);
                }
            }
        }
        return mInstance;
    }

    public Dialog show() {
        if (!mDialog.isShowing()) {
            mDialog.show(); //显示出来
        }

        return mDialog;
    }

}