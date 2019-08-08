package com.jinhong.jhtv.test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jinhong.jhtv.Constants;
import com.jinhong.jhtv.R;
import com.jinhong.jhtv.base.BaseActivity;
import com.jinhong.jhtv.model.Test1Bean;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class ViewModelActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 发送请求
     */
    private Button mBtnSend;
    /**
     * test_info
     */
    private TextView mTvInfo;
    private MutableLiveData<Test1Bean> mTest1Bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);
        initView();
        //CommonViewModel commonViewModel = ViewModelProviders.of(this).get(CommonViewModel.class);

        mTest1Bean = mCommonViewModel.getTest1Bean(Constants.TEST_URL1);



    }


    private void initView() {
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_send:

                if (1<=4){

                    mTest1Bean.observe(this, new Observer<Test1Bean>() {
                        @Override
                        public void onChanged(@Nullable Test1Bean test1Bean) {
                            log( test1Bean.getData().get(3).getTitle());
                            mTvInfo.setText(test1Bean.getData().get(4).getTitle());
                        }
                    });

                }


                break;
        }
    }
}

