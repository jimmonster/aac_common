package com.jinhong.jhtv.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :亲子游戏页面
 */
public class GameFragment extends BaseFragment {
    private static volatile GameFragment mInstance;
    private String dataType;//activity传递过来的分类数据



    public static GameFragment getInstance(String s) {
        if (mInstance == null) {
            synchronized (GameFragment.class) {
                if (mInstance == null) {
                    mInstance = new GameFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("DATA", s);
                    mInstance.setArguments(bundle);
                }
            }
        }
        return mInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        initData();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {

    }

    private void initData() {
        //获取到activity传递过来的数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            String data = bundle.getString("DATA");
        }

    }


}