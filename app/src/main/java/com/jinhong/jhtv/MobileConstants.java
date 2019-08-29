package com.jinhong.jhtv;

/**
 * @author :  Jim
 * @date :  2019-08-28
 * @description :
 */
public class MobileConstants {

    //山东移动
    public final static String MOBILE_MAIN = "http://";
    //统一订购退订(serviceOrder)
    public final static String POST_SERVICE_ORDER = MOBILE_MAIN + "/aep/serviceOrder/v1";
    //查询产品详情接口(queryProduct)
    public final static String POST_QUERY_PRODUCT = MOBILE_MAIN + "/aep/queryProduct/v1";
    //取消订单接口(cancleOrder)
    public final static String POST_CANCLE_ORDER = MOBILE_MAIN + "/service/cancleOrder/v1";
    //切换订单支付方式接口(payOrderByNewChannel) (暂未实现)
    public final static String POST_PAY_ORDER_BY_NEW_CHANNEL = MOBILE_MAIN + "/service/payOrderByNewChannel/v1";
    //订单信息查询接口(queryOrder)
    public final static String POST_QUERY_ORDER = MOBILE_MAIN + "/service/queryOrder/v1";
    //周期资费批价接口(calculateSingle)
    public final static String POST_CALCULATE_SINGLE = MOBILE_MAIN + "/service/calculateSingle/v1";
    //按次事件类资费批价接口(calculatePrice)
    public final static String POST_CALCULATE_PRICE = MOBILE_MAIN + "/service/calculatePrice/v1";
    //查询用户可参加的营销活动列表(queryPromotions)
    public final static String POST_QUERY_PROMOTIONS = MOBILE_MAIN + "/service/queryPromotions/v1";
    //查询订购记录(querySubInfoList)
    public final static String POST_QUERY_SUBINFO_LIST = MOBILE_MAIN + "/service/querySubInfoList/v1";
    //第三方支付结果通知记录 (notifyThirdPaymentResult)
    public final static String POST_NOTIFY_THIRD_PAYMENT_RESULT = MOBILE_MAIN + "/service/notifyThirdPaymentResult/v1";
    //用户领取优惠券资源(drawVouhcers) 接口功能
    public final static String POST_DRAW_VOUHCERS = MOBILE_MAIN + "/service/drawVouhcers/v1";
    //查询用户优惠券资源(queryUserResources)
    public final static String POST_QUERY_USER_RESOURCES = MOBILE_MAIN + "/service/queryUserResources/v1";

}
