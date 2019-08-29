package com.jinhong.jhtv.model;

/**
 * @author :  Jim
 * @date :  2019-08-28
 * @description :统一订购退订(serviceOrder)
 */
public class PayOrderByNewChannelBean {


    /**
     * code : 0
     * description : ok
     * orderID : zh100214125
     * orderMode : 0
     */

    private String code;
    private String description;
    private String orderID;
    private String orderMode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(String orderMode) {
        this.orderMode = orderMode;
    }
}
