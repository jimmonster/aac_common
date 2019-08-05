package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

/**
 * @author :  Jim
 * @date :  2019-08-05
 * @description :
 */
public class RecordLocalBean  extends BaseBean {

    /**
     * id : 2
     * userId : testott11
     * fatherId : 23
     * contentId : 222
     * mainName :
     * contentName : 唱儿歌系列
     * sort : 1
     * dramaType : 少儿
     * dration : 50
     * createtime : 1563528762000
     * updatetime : 1563528762000
     */

    private int id;
    private String userId;
    private int fatherId;
    private int contentId;
    private String mainName;
    private String contentName;
    private String sort;
    private String dramaType;
    private String dration;
    private long createtime;
    private long updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDramaType() {
        return dramaType;
    }

    public void setDramaType(String dramaType) {
        this.dramaType = dramaType;
    }

    public String getDration() {
        return dration;
    }

    public void setDration(String dration) {
        this.dration = dration;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }
}
