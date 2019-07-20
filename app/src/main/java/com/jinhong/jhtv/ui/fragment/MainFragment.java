package com.jinhong.jhtv.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseFragment;
import com.jinhong.jhtv.utils.FocusUtils;
import com.owen.focus.FocusBorder;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-20
 * @description :
 */
public class MainFragment extends BaseFragment  {

    private TvRecyclerView mRecyclerView;
    private ArrayList<String> mContents;
    private FocusBorder mFocusBorder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);

        initData();
        initView(inflate);
        return inflate;

    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mContents = (ArrayList<String>)arguments.get("mainData");
            Log.d("MainFragment", "mContents:" + mContents.get(0));

        }
    }

    private void initView(View inflate) {
        mRecyclerView = (TvRecyclerView)inflate.findViewById(R.id.recyclerView);
        GSYMenuAdapter gsyMenuAdapter = new GSYMenuAdapter(R.layout.widget_player_menu_item, mContents);
        mRecyclerView.setAdapter(gsyMenuAdapter);
        gsyMenuAdapter.bindToRecyclerView(mRecyclerView);


    }



    private class GSYMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public GSYMenuAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            TextView textView = (TextView) helper.getView(R.id.tv_tvcount);
            helper.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        textView.setTextColor(Color.WHITE);
                        FocusUtils.selected(textView, R.drawable.iv_player_circle_f);
                    } else {
                        textView.setTextColor(Color.BLACK);
                        FocusUtils.unselected(textView, R.drawable.iv_player_circle);
                    }
                }
            });
            helper.setText(R.id.tv_tvcount, item);

        }
    }
}
