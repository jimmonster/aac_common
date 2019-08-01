package com.jinhong.jhtv.base;

import com.jinhong.jhtv.impl.ImplBasePresenter;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.OkGoUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-07-31
 * @description :
 */
public abstract class BasePresenter implements ImplBasePresenter {


    protected void requestData(String url, HashMap<String, String> params) {
        OkGoUtils.get(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            BaseBean baseBean = GsonUtil.GsonToBean(response.body(), BaseBean.class);
                            loadData(baseBean);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        onStartLoading();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        onErrorLoading();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        onFinishLoading();
                    }
                }


        );

    }

    public void onFinishLoading() {
    }


    public void onErrorLoading() {
    }


    public void onStartLoading() {
    }


    protected abstract <T> T loadData( T baseBean);

}
