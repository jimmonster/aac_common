package com.jinhong.jhtv.base;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.owen.focus.FocusBorder;

/**
 * Base Fragment
 */
public abstract class BaseFragment extends Fragment {
    protected FocusBorder mFocusBorder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FocusBorderHelper) {
            mFocusBorder = ((FocusBorderHelper) getActivity()).getFocusBorder();
        }
    }

    /**
     * 移动边框
     *
     * @param focusedView
     * @param scale
     */
    public void onMoveFocusBorder(View focusedView, float scale) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale));
        }
    }

    /**
     * 移动边框
     *
     * @param focusedView
     * @param scale
     * @param roundRadius
     */
    public void onMoveFocusBorder(View focusedView, float scale, float roundRadius) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale, roundRadius));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 需要实现此接口才能拿到边框
     */
    public interface FocusBorderHelper {
        FocusBorder getFocusBorder();
    }
}

