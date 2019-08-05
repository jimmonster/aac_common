package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

/**
 * @author :  Jim
 * @date :  2019-08-05
 * @description :
 */
public class DeleteRecordBean extends BaseBean {

    /**
     * status : 0
     * msg : 删除成功
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
