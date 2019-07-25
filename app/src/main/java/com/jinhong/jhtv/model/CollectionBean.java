package com.jinhong.jhtv.model;

import java.io.Serializable;

/**
 * @author :  Jim
 * @date :  2019-07-25
 * @description :
 */
public class CollectionBean implements Serializable {
    private String name;
    private String type;
    private String isCollect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }
}
