package com.jinhong.jhtv.test;

import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.utils.FocusUtils;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-09
 * @description :
 */
public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TestAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        FocusUtils.onFocusChange(helper.itemView);
        helper.setText(R.id.tv_test, item);

    }
}
