package com.jinhong.jhtv.utils;

/**
 * @author :  Jim
 * @date :  2019-07-31
 * @description :单例请求网络框架封装
 */
public class ApiUtils<T> {
    private static volatile ApiUtils mInstance;

    private ApiUtils() {

    }

    public static ApiUtils getInstance() {
        if (mInstance == null) {
            synchronized (ApiUtils.class) {
                if (mInstance == null) {
                    mInstance = new ApiUtils();
                }
            }
        }
        return mInstance;
    }


}
