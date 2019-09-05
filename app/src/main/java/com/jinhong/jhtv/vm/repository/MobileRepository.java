package com.jinhong.jhtv.vm.repository;

import android.arch.lifecycle.MutableLiveData;

import com.jinhong.jhtv.model.CalculatePriceBean;
import com.jinhong.jhtv.model.CalculateSingleBean;
import com.jinhong.jhtv.model.CancleOrderBean;
import com.jinhong.jhtv.model.DrawVouhcersBean;
import com.jinhong.jhtv.model.NotifyThirdPaymentResultBean;
import com.jinhong.jhtv.model.PayOrderByNewChannelBean;
import com.jinhong.jhtv.model.QueryOrderBean;
import com.jinhong.jhtv.model.QueryProductBean;
import com.jinhong.jhtv.model.QueryPromotionsBean;
import com.jinhong.jhtv.model.QuerySubInfoListBean;
import com.jinhong.jhtv.model.QueryUserResourcesBean;
import com.jinhong.jhtv.model.ServiceOrderBean;
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.OkGoUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-28
 * @description :山东移动仓库
 */
public class MobileRepository {
    private MutableLiveData<ServiceOrderBean> mServiceOrderBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<QueryProductBean> mQueryProductBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CancleOrderBean> mCancleOrderBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<PayOrderByNewChannelBean> mPayOrderByNewChannelBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<QueryOrderBean> mQueryOrderBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CalculateSingleBean> mCalculateSingleBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CalculatePriceBean> mCalculatePriceBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<QueryPromotionsBean> mQueryPromotionsBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<QuerySubInfoListBean> mQuerySubInfoListBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<NotifyThirdPaymentResultBean> mNotifyThirdPaymentResultBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<DrawVouhcersBean> mDrawVouhcersBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<QueryUserResourcesBean> mQueryUserResourcesBeanMutableLiveData = new MutableLiveData<>();

    //统一订购退订(serviceOrder)
    public MutableLiveData<ServiceOrderBean> getServiceOrderBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    ServiceOrderBean serviceOrderBean = GsonUtil.GsonToBean(response.body(), ServiceOrderBean.class);
                    mServiceOrderBeanMutableLiveData.setValue(serviceOrderBean);
                }
            }
        });
        return mServiceOrderBeanMutableLiveData;
    }

    //查询产品详情接口(queryProduct)
    public MutableLiveData<QueryProductBean> getQueryProductBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    QueryProductBean queryProductBean = GsonUtil.GsonToBean(response.body(), QueryProductBean.class);
                    mQueryProductBeanMutableLiveData.setValue(queryProductBean);
                }
            }
        });
        return mQueryProductBeanMutableLiveData;
    }

    //取消订单接口(cancleOrder)
    public MutableLiveData<CancleOrderBean> getCancleOrderBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    CancleOrderBean cancleOrderBean = GsonUtil.GsonToBean(response.body(), CancleOrderBean.class);
                    mCancleOrderBeanMutableLiveData.setValue(cancleOrderBean);
                }
            }
        });
        return mCancleOrderBeanMutableLiveData;
    }


    //切换订单支付方式接口(payOrderByNewChannel) (暂未实现)
    public MutableLiveData<PayOrderByNewChannelBean> getPayOrderByNewChannelBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    PayOrderByNewChannelBean payOrderByNewChannelBean = GsonUtil.GsonToBean(response.body(), PayOrderByNewChannelBean.class);
                    mPayOrderByNewChannelBeanMutableLiveData.setValue(payOrderByNewChannelBean);
                }
            }
        });
        return mPayOrderByNewChannelBeanMutableLiveData;
    }

    //订单信息查询接口(queryOrder)
    public MutableLiveData<QueryOrderBean> getQueryOrderBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    QueryOrderBean queryOrderBean = GsonUtil.GsonToBean(response.body(), QueryOrderBean.class);
                    mQueryOrderBeanMutableLiveData.setValue(queryOrderBean);
                }
            }
        });
        return mQueryOrderBeanMutableLiveData;
    }

    //周期资费批价接口(calculateSingle)
    public MutableLiveData<CalculateSingleBean> getCalculateSingleBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    CalculateSingleBean calculateSingleBean = GsonUtil.GsonToBean(response.body(), CalculateSingleBean.class);
                    mCalculateSingleBeanMutableLiveData.setValue(calculateSingleBean);
                }
            }
        });
        return mCalculateSingleBeanMutableLiveData;
    }

    //按次事件类资费批价接口(calculatePrice)
    public MutableLiveData<CalculatePriceBean> getCalculatePriceBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    CalculatePriceBean calculateSingleBean = GsonUtil.GsonToBean(response.body(), CalculatePriceBean.class);
                    mCalculatePriceBeanMutableLiveData.setValue(calculateSingleBean);
                }
            }
        });
        return mCalculatePriceBeanMutableLiveData;
    }

    //查询用户可参加的营销活动列表(queryPromotions)
    public MutableLiveData<QueryPromotionsBean> getQueryPromotionsBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    QueryPromotionsBean queryPromotionsBean = GsonUtil.GsonToBean(response.body(), QueryPromotionsBean.class);
                    mQueryPromotionsBeanMutableLiveData.setValue(queryPromotionsBean);
                }
            }
        });
        return mQueryPromotionsBeanMutableLiveData;
    }

    //查询订购记录(querySubInfoList)
    public MutableLiveData<QuerySubInfoListBean> getQuerySubInfoListBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    QuerySubInfoListBean querySubInfoListBean = GsonUtil.GsonToBean(response.body(), QuerySubInfoListBean.class);
                    mQuerySubInfoListBeanMutableLiveData.setValue(querySubInfoListBean);
                }
            }
        });
        return mQuerySubInfoListBeanMutableLiveData;
    }

    // 第三方支付结果通知记录 (notifyThirdPaymentResult)
    public MutableLiveData<NotifyThirdPaymentResultBean> getNotifyThirdPaymentResultBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    NotifyThirdPaymentResultBean notifyThirdPaymentResultBean = GsonUtil.GsonToBean(response.body(), NotifyThirdPaymentResultBean.class);
                    mNotifyThirdPaymentResultBeanMutableLiveData.setValue(notifyThirdPaymentResultBean);
                }
            }
        });
        return mNotifyThirdPaymentResultBeanMutableLiveData;
    }

    //用户领取优惠券资源(drawVouhcers)
    public MutableLiveData<DrawVouhcersBean> getDrawVouhcersBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    DrawVouhcersBean drawVouhcersBean = GsonUtil.GsonToBean(response.body(), DrawVouhcersBean.class);
                    mDrawVouhcersBeanMutableLiveData.setValue(drawVouhcersBean);
                }
            }
        });
        return mDrawVouhcersBeanMutableLiveData;
    }

    //查询用户优惠券资源(queryUserResources)
    public MutableLiveData<QueryUserResourcesBean> getQueryUserResourcesBean(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    QueryUserResourcesBean queryUserResourcesBean = GsonUtil.GsonToBean(response.body(), QueryUserResourcesBean.class);
                    mQueryUserResourcesBeanMutableLiveData.setValue(queryUserResourcesBean);
                }
            }
        });
        return mQueryUserResourcesBeanMutableLiveData;
    }

}
