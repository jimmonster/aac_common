package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

/**
 * @author :  Jim
 * @date :  2019-08-05
 * @description :
 */
public class SingleCollectBean extends BaseBean {


    /**
     * status : 0
     * msg : 上传成功
     */

    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
