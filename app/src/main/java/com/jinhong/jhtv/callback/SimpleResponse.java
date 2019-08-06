package com.jinhong.jhtv.callback;

import java.io.Serializable;

/**
 * @author :  Jim
 * @date :  2019-08-06
 * @description :
 */
public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public int status;
    public String msg;

    public LzyResponse toLzyResponse() {
        LzyResponse lzyResponse = new LzyResponse();
        lzyResponse.status = status;
        lzyResponse.msg = msg;
        return lzyResponse;
    }
}

