package com.jinhong.jhtv.model;

/**
 * @author :  Jim
 * @date :  2019-08-28
 * @description :统一订购退订(serviceOrder)
 */
public class ServiceOrderBean {

    /**
     * code : 0
     * description : ok
     * fee : 1000
     * orderID : 1001241295
     * serEndTime : 20161130120312
     */

    private String code;
    private String description;
    private String fee;
    private String orderID;
    private String serEndTime;

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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSerEndTime() {
        return serEndTime;
    }

    public void setSerEndTime(String serEndTime) {
        this.serEndTime = serEndTime;
    }
}
