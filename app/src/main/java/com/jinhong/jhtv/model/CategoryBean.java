package com.jinhong.jhtv.model;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class CategoryBean {
    private List<String> tabsName;
    private List<CategoryItemBean> items;

    public List<String> getTabsName() {
        return tabsName;
    }

    public void setTabsName(List<String> tabsName) {
        this.tabsName = tabsName;
    }

    public List<CategoryItemBean> getItems() {
        return items;
    }

    public void setItems(List<CategoryItemBean> items) {
        this.items = items;
    }
}
