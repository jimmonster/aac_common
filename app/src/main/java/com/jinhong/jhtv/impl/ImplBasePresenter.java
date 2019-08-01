package com.jinhong.jhtv.impl;

import com.jinhong.jhtv.base.BaseBean;

/**
 * @author :  Jim
 * @date :  2019-07-31
 * @description :
 */
public interface ImplBasePresenter {

    void responseLoading();

    void responseSuccess(BaseBean baseBean);

    void responseFailed();
}
