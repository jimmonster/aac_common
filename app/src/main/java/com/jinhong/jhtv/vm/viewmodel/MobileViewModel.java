package com.jinhong.jhtv.vm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jim.sdk_sdmobile.HeaderUtils;
import com.jim.sdk_sdmobile.ParamsUtils;
import com.jinhong.jhtv.MobileConstants;
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
import com.jinhong.jhtv.vm.repository.MobileRepository;
import com.lzy.okgo.model.HttpHeaders;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-28
 * @description :山东移动viewModel
 */

public class MobileViewModel extends ViewModel {
    private MobileRepository mRepository;

    public MobileViewModel() {
        mRepository = new MobileRepository();
    }

    //统一订购退订(serviceOrder)
    public MutableLiveData<ServiceOrderBean> getServiceOrderBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
//        params.put("userID", ParamsUtils.Companion.getUserID());
//        params.put("contentID", ParamsUtils.Companion.getContentID());
//        params.put("productID", ParamsUtils.Companion.getProductID());
//        params.put("action", ParamsUtils.Companion.getAction());
//        params.put("continueflag", ParamsUtils.Companion.getContinueflag());
//        params.put("orderMode", ParamsUtils.Companion.getOrderMode());
//        params.put("serStartTime", ParamsUtils.Companion.getTime());
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        params.put("serStartTime", "20161130210404");
        return mRepository.getServiceOrderBean(MobileConstants.POST_SERVICE_ORDER, params);
    }

    //查询产品详情接口(queryProduct)
    public MutableLiveData<QueryProductBean> getQueryProductBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("productID", ParamsUtils.Companion.getProductID());
        return mRepository.getQueryProductBean(MobileConstants.POST_QUERY_PRODUCT, params);
    }

    //取消订单接口(cancleOrder)
    public MutableLiveData<CancleOrderBean> getCancleOrderBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("orderID", ParamsUtils.Companion.getOrderID());
        return mRepository.getCancleOrderBean(MobileConstants.POST_CANCLE_ORDER, params);
    }

    //切换订单支付方式接口(payOrderByNewChannel) (暂未实现)
    public MutableLiveData<PayOrderByNewChannelBean> getPayOrderByNewChannelBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();

        return mRepository.getPayOrderByNewChannelBean(MobileConstants.POST_CANCLE_ORDER, params);
    }

    //订单信息查询接口(queryOrder)
    public MutableLiveData<QueryOrderBean> getQueryOrderBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("orderID", ParamsUtils.Companion.getOrderID());
        return mRepository.getQueryOrderBean(MobileConstants.POST_QUERY_ORDER, params);
    }

    //周期资费批价接口(calculateSingle)
    public MutableLiveData<CalculateSingleBean> getCalculateSingleBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("productID", ParamsUtils.Companion.getProductID());
        params.put("orderMode", ParamsUtils.Companion.getOrderMode());
        params.put("orderCycleCount", ParamsUtils.Companion.getOrderCycleCount());

        return mRepository.getCalculateSingleBean(MobileConstants.POST_CALCULATE_SINGLE, params);
    }


    //按次事件类资费批价接口(calculatePrice)
    public MutableLiveData<CalculatePriceBean> getCalculatePriceBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());

        return mRepository.getCalculatePriceBean(MobileConstants.POST_CALCULATE_PRICE, params);
    }

    // 查询用户可参加的营销活动列表(queryPromotions)
    public MutableLiveData<QueryPromotionsBean> getQueryPromotionsBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());

        return mRepository.getQueryPromotionsBean(MobileConstants.POST_QUERY_PROMOTIONS, params);
    }

    //查询订购记录(querySubInfoList)
    public MutableLiveData<QuerySubInfoListBean> getQuerySubInfoListBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("queryType", ParamsUtils.Companion.getQueryType());
        return mRepository.getQuerySubInfoListBean(MobileConstants.POST_QUERY_SUBINFO_LIST, params);
    }

    // 第三方支付结果通知记录 (notifyThirdPaymentResult)
    public MutableLiveData<NotifyThirdPaymentResultBean> getNotifyThirdPaymentResultBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("orderID", ParamsUtils.Companion.getOrderID());
        params.put("status", ParamsUtils.Companion.getStatus());

        return mRepository.getNotifyThirdPaymentResultBean(MobileConstants.POST_NOTIFY_THIRD_PAYMENT_RESULT, params);
    }

    //用户领取优惠券资源(drawVouhcers)
    public MutableLiveData<DrawVouhcersBean> getDrawVouhcersBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("userType", ParamsUtils.Companion.getUserType());
        params.put("productID", ParamsUtils.Companion.getProductID());
        params.put("catalog", ParamsUtils.Companion.getCatalog());
        params.put("resourceId", ParamsUtils.Companion.getResourceId());
        params.put("drawType", ParamsUtils.Companion.getDrawType());

        return mRepository.getDrawVouhcersBean(MobileConstants.POST_NOTIFY_THIRD_PAYMENT_RESULT, params);
    }

    //查询用户优惠券资源(queryUserResources)
    public MutableLiveData<QueryUserResourcesBean> getQueryUserResourcesBean(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"");
        headers.put("X-WSSE", HeaderUtils.Companion.getXWSSE());

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", ParamsUtils.Companion.getUserID());
        params.put("userType", ParamsUtils.Companion.getUserType());
        params.put("catalog", ParamsUtils.Companion.getCatalog());
        params.put("pageStart", ParamsUtils.Companion.getPageStart());
        params.put("pageOffset", ParamsUtils.Companion.getPageOffset());

        return mRepository.getQueryUserResourcesBean(MobileConstants.POST_QUERY_USER_RESOURCES, params);
    }
}

