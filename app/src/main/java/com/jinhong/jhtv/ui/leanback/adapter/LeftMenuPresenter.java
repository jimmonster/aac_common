package com.jinhong.jhtv.ui.leanback.adapter;

import android.view.ViewGroup;
import android.widget.Button;

import com.jinhong.jhtv.ui.leanback.mode.OpenPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView demo 的左侧菜单.
 * Created by hailongqiu on 2016/8/24.
 */
public class LeftMenuPresenter extends OpenPresenter {

    private List<String> strList = new ArrayList<String>() {
        {
            add("全部");
            add("搞笑");
            add("益智");
            add("冒险");
            add("热血");
        }
    };

    @Override
    public int getItemCount() {
        return strList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button btn = new Button(parent.getContext());
        return new ViewHolder(btn);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Button btn = (Button) viewHolder.view;
        btn.setFocusableInTouchMode(true); // 只是测试鼠标效果.
        btn.setFocusable(true);
        String str = strList.get(position);
        btn.setText(str);
    }

}
