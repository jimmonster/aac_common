package com.jinhong.jhtv.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class VideoFragment extends BaseFragment {

    private View mInflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mInflate = inflater.inflate(R.layout.fragment_video, null, false);
        initView();

        return mInflate;
    }

    private void initView() {


    }



    private View findViewById(int id) {
        return mInflate.findViewById(id);
    }
}
