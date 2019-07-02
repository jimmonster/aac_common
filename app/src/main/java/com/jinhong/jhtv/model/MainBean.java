package com.jinhong.jhtv.model;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-01
 * @description :
 */
public class MainBean {
    private List<String> tabsTitles;
    private List<String> images;
    private String notice;
    private String date;

    public List<String> getTabsTitles() {
        return tabsTitles;
    }

    public void setTabsTitles(List<String> tabsTitles) {
        this.tabsTitles = tabsTitles;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
