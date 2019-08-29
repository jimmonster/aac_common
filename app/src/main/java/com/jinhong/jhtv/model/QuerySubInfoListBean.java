package com.jinhong.jhtv.model;

/**
 * @author :  Jim
 * @date :  2019-08-29
 * @description :
 */
public class QuerySubInfoListBean {

    /**
     * code : 0
     * description : ok
     * subInfoList : {"productID":"111111","productName":"好莱坞20元包月","productType":"1","startTime":"20161220211919","endTime":"20170119235959","buyMode":"1","fee":"2000"}
     */

    private String code;
    private String description;
    private SubInfoListBean subInfoList;

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

    public SubInfoListBean getSubInfoList() {
        return subInfoList;
    }

    public void setSubInfoList(SubInfoListBean subInfoList) {
        this.subInfoList = subInfoList;
    }

    public static class SubInfoListBean {
        /**
         * productID : 111111
         * productName : 好莱坞20元包月
         * productType : 1
         * startTime : 20161220211919
         * endTime : 20170119235959
         * buyMode : 1
         * fee : 2000
         */

        private String productID;
        private String productName;
        private String productType;
        private String startTime;
        private String endTime;
        private String buyMode;
        private String fee;

        public String getProductID() {
            return productID;
        }

        public void setProductID(String productID) {
            this.productID = productID;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getBuyMode() {
            return buyMode;
        }

        public void setBuyMode(String buyMode) {
            this.buyMode = buyMode;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }
    }
}
