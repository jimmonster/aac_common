package com.jinhong.jhtv.model.event;

/**
 * @author :  Jim
 * @date :  2019-07-17
 * @description :
 */
public class IsTipVisibleEvent {
    int isVisible;

    public IsTipVisibleEvent(int isVisible) {
        this.isVisible = isVisible;
    }

    public int isVisible() {
        return isVisible;
    }

    public void setVisible(int visible) {
        isVisible = visible;
    }
}
