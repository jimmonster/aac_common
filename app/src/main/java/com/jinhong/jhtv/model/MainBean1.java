package com.jinhong.jhtv.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author :  Jim
 * @date :  2019-07-22
 * @description :
 */
public class MainBean1 implements MultiItemEntity {
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    private int spanSize;
    private int itemType;

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public MainBean1(int itemType, int pic) {
        this.itemType = itemType;
        this.pic = pic;
    }

    public MainBean1(int itemType) {
        this.itemType = itemType;
    }
    
    private int pic;

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
