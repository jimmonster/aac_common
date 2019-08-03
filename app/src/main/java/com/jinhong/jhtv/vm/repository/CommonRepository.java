package com.jinhong.jhtv.vm.repository;

import android.arch.lifecycle.MutableLiveData;

import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.model.Test1Bean;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.OkGoUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class CommonRepository {

    MutableLiveData<MainListBean> mainListData = new MutableLiveData<>();
    MutableLiveData<Test1Bean> mTest1BeanMutableLiveData = new MutableLiveData<>();

    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）
    public void requestMainListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {

                if (response != null) {
                    MainListBean mainListBean = GsonUtil.GsonToBean(response.body(), MainListBean.class);
                    mainListData.setValue(mainListBean);
                }
            }
        });
    }

    public MutableLiveData<MainListBean> getMainListBean() {
        return mainListData;
    }


    public void requestgetTest1Data(String url) {
        OkGoUtils.get(url, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    Test1Bean test1Bean = GsonUtil.GsonToBean(response.body(), Test1Bean.class);
                    mTest1BeanMutableLiveData.setValue(test1Bean);
                }
            }
        });
    }

    public MutableLiveData<Test1Bean> getTest1Bean() {

        return mTest1BeanMutableLiveData;
    }
}
