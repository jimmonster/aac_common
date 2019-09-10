package com.jinhong.jhtv.test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jinhong.jhtv.MobileConstants;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.ServiceOrderBean;
import com.jinhong.jhtv.vm.viewmodel.MobileViewModel;

/**
 * @author :  Jim
 * @date :  2019-09-07
 * @description :
 */
public class SDTestActivity extends BaseActivity implements View.OnClickListener {
    /**
     * 请求数据
     */
    private TextView mTvRequest;
    /**
     * 请求的数据结果
     */
    private TextView mTvInfo;
    private MobileViewModel mMobileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd_test);
        mMobileViewModel = ViewModelProviders.of(this).get(MobileViewModel.class);
        initView();
    }

    private void initView() {
        mTvRequest = (TextView) findViewById(R.id.tv_request);
        mTvRequest.setOnClickListener(this);
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_request:
                toast("tv_request");
                MutableLiveData<ServiceOrderBean> serviceOrderBean = mMobileViewModel.getServiceOrderBean(MobileConstants.POST_SERVICE_ORDER);
                serviceOrderBean.observe(this, new Observer<ServiceOrderBean>() {
                    @Override
                    public void onChanged(@Nullable ServiceOrderBean serviceOrderBean) {
                        log(serviceOrderBean);
                        mTvInfo.setText(serviceOrderBean.getDescription());
                    }
                });
                break;
        }
    }
}
