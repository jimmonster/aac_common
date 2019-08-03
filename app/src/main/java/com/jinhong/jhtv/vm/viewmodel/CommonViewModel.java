package com.jinhong.jhtv.vm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.model.Test1Bean;
import com.jinhong.jhtv.vm.repository.CommonRepository;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class CommonViewModel extends ViewModel {
    CommonRepository mRepository;

    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）
    public MutableLiveData<MainListBean> getMainListBean(String url, HashMap<String,String>params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        mRepository.requestMainListData(url,params);
        return mRepository.getMainListBean();
    }




    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）
    public MutableLiveData<Test1Bean> getTest1Bean(String url) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        mRepository.requestgetTest1Data(url);
        return mRepository.getTest1Bean();
    }
}
