package com.jinhong.jhtv.base;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.vm.viewmodel.CommonViewModel;
import com.owen.focus.FocusBorder;

/**
 * Base Fragment
 */
public abstract class BaseFragment extends Fragment {

    public String extraBundle = "ExtraBundle";
    public CommonViewModel mCommonViewModel;
    protected FocusBorder mFocusBorder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(getLayoutId(), container, false);
    }

    public abstract int getLayoutId();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initData();
        initView(view);
        initEvent();
        initBorder(view);

    }

    private void initBorder(View view) {
        mFocusBorder = new FocusBorder.Builder()
                .asColor()
                .borderColor(getResources().getColor(R.color.common_orange_dark))
                .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 3.2f)
                .shadowColor(getResources().getColor(R.color.common_orange))
                .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 12)

                .build((ViewGroup) view);
    }

    protected void onMoveFocusBorder(View focusedView, float scale) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale));
        }
    }

    protected void onMoveFocusBorder(View focusedView, float scale, float roundRadius) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale, roundRadius));
        }
    }
    /**
     * dp2px
     *
     * @param dp
     * @return px
     */
    public float dp2px(int dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FocusBorderHelper) {
            mFocusBorder = ((FocusBorderHelper) getActivity()).getFocusBorder();
        }
    }


    protected void initEvent() {

    }

    protected abstract void initView(View view);

    protected void initData() {
    }

    protected void initViewModel() {
        mCommonViewModel = ViewModelProviders.of(this).get(CommonViewModel.class);
    }


    public void toast(Object s) {
        Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
    }

    public void log(Object s) {
        Log.d("jim:" + getClass().getSimpleName(), "\n     " + s + "     ");
    }


    /**
     * 统一界面跳转,携带参数
     *
     * @param activity
     */
    public void startActivity(Class activity, Bundle bundle) {
        Intent intent = new Intent(getActivity(), activity);
        intent.putExtra(extraBundle, bundle);
        startActivity(intent);
//        ActivityUtils.startActivity(intent);

    }


    /**
     * 统一界面跳转
     *
     * @param activity
     */
    public void startActivity(Class activity) {
        Intent intent = new Intent(getActivity(), activity);

        startActivity(intent);
//        ActivityUtils.startActivity(intent);

    }

    public interface FocusBorderHelper {
        FocusBorder getFocusBorder();
    }

}

