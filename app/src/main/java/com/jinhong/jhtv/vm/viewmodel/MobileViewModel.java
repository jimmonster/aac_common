package com.jinhong.jhtv.vm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.blankj.utilcode.util.TimeUtils;
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
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpHeaders;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-28
 * @description :
 */
public class MobileViewModel extends ViewModel {
    private MobileRepository mRepository;

    public MobileViewModel() {
        mRepository = new MobileRepository();
    }

    //统一订购退订(serviceOrder)
    public MutableLiveData<ServiceOrderBean> getServiceOrderBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getServiceOrderBean(MobileConstants.POST_SERVICE_ORDER, headers, params);
    }

    //查询产品详情接口(queryProduct)
    public MutableLiveData<QueryProductBean> getQueryProductBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getQueryProductBean(MobileConstants.POST_QUERY_PRODUCT, headers, params);
    }

    //取消订单接口(cancleOrder)
    public MutableLiveData<CancleOrderBean> getCancleOrderBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getCancleOrderBean(MobileConstants.POST_CANCLE_ORDER, headers, params);
    }

    //切换订单支付方式接口(payOrderByNewChannel) (暂未实现)
    public MutableLiveData<PayOrderByNewChannelBean> getPayOrderByNewChannelBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getPayOrderByNewChannelBean(MobileConstants.POST_CANCLE_ORDER, headers, params);
    }

    //订单信息查询接口(queryOrder)
    public MutableLiveData<QueryOrderBean> getQueryOrderBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getQueryOrderBean(MobileConstants.POST_QUERY_ORDER, headers, params);
    }

    //周期资费批价接口(calculateSingle)
    public MutableLiveData<CalculateSingleBean> getCalculateSingleBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getCalculateSingleBean(MobileConstants.POST_CALCULATE_SINGLE, headers, params);
    }


    //按次事件类资费批价接口(calculatePrice)
    public MutableLiveData<CalculatePriceBean> getCalculatePriceBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getCalculatePriceBean(MobileConstants.POST_CALCULATE_PRICE, headers, params);
    }

    // 查询用户可参加的营销活动列表(queryPromotions)
    public MutableLiveData<QueryPromotionsBean> getQueryPromotionsBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getQueryPromotionsBean(MobileConstants.POST_QUERY_PROMOTIONS, headers, params);
    }

    //查询订购记录(querySubInfoList)
    public MutableLiveData<QuerySubInfoListBean> getQuerySubInfoListBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getQuerySubInfoListBean(MobileConstants.POST_QUERY_SUBINFO_LIST, headers, params);
    }

    // 第三方支付结果通知记录 (notifyThirdPaymentResult)
    public MutableLiveData<NotifyThirdPaymentResultBean> getNotifyThirdPaymentResultBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getNotifyThirdPaymentResultBean(MobileConstants.POST_NOTIFY_THIRD_PAYMENT_RESULT, headers, params);
    }

    //用户领取优惠券资源(drawVouhcers)
    public MutableLiveData<DrawVouhcersBean> getDrawVouhcersBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getDrawVouhcersBean(MobileConstants.POST_NOTIFY_THIRD_PAYMENT_RESULT, headers, params);
    }

    //查询用户优惠券资源(queryUserResources)
    public MutableLiveData<QueryUserResourcesBean> getQueryUserResourcesBean(String url) {
        HttpHeaders headers = OkGo.getInstance().getCommonHeaders();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"");
        headers.put("X-WSSE", "UsernameToken Username=\"bob\", PasswordDigest=\"weYI3nXd8LjMNVksCKFV8t3rgHh3Rw==\",Nonce=\"WScqanjCEAC4mQoBE07sAQ==\", Created=\"2009-03-24T12:30:04Z\"");

        HashMap<String, String> params = new HashMap<>();
        params.put("userID", "CSD000012345678");
        params.put("contentID", "zh5063462349");
        params.put("productID", "hw0012515133");
        params.put("action", "1");
        params.put("continueflag", "1");
        params.put("orderMode", "1");
        long nowMills = TimeUtils.getNowMills();
        params.put("serStartTime", String.valueOf(nowMills));
        return mRepository.getQueryUserResourcesBean(MobileConstants.POST_QUERY_USER_RESOURCES, headers, params);
    }


}
