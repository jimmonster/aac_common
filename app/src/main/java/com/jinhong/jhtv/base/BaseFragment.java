package com.jinhong.jhtv.base;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.owen.focus.AbsFocusBorder;
import com.owen.focus.FocusBorder;

/**
 * Base Fragment
 */
public abstract class BaseFragment extends Fragment {

    public FocusBorder mFocusBorder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBoader();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initBoader() {
        /** 颜色焦点框 */
        mFocusBorder = new FocusBorder.Builder().asColor()
                //阴影宽度(方法shadowWidth(18f)也可以设置阴影宽度)
                .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 20f)
                //阴影颜色
                .shadowColor(Color.parseColor("#3FBB66"))
                //边框宽度(方法borderWidth(2f)也可以设置边框宽度)
                .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 3.2f)
                //边框颜色
                .borderColor(Color.parseColor("#00FF00"))
                //padding值
                .padding(2f)
                //动画时长
                .animDuration(300)
                //不要闪光动画
                //.noShimmer()
                //闪光颜色
                .shimmerColor(Color.parseColor("#66FFFFFF"))
                //闪光动画时长
                .shimmerDuration(1000)
                //不要呼吸灯效果
                //.noBreathing()
                //呼吸灯效果时长
                .breathingDuration(3000)
                //边框动画模式
                .animMode(AbsFocusBorder.Mode.SEQUENTIALLY)
                .build(this);

    }

    public void toast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    public void log(String s) {
        Log.d("jim:" + getClass().getName(), "{ " + s + " }");
    }
}

