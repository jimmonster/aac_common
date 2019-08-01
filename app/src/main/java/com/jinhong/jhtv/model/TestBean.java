package com.jinhong.jhtv.model;

import com.google.gson.annotations.SerializedName;
import com.jinhong.jhtv.base.BaseBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-01
 * @description :
 */
public class TestBean extends BaseBean {

    /**
     * code : 0
     * message : ok
     * data : {"11":["户外旅行","海外留学","才艺表演","个人自拍"],"10":["唱见","舞见","奏见"],"6":["日常","学习","萌宠","厨艺","手机直播"],"9":["原创","同人","临摹","其他绘画"],"2":["手工","声优","ASMR"],"1":["以撒","minecraft","饥荒","彩虹六号","东方"],"3":["守望先锋","炉石传说","剑网3","dnf","最终幻想14","坦克世界"],"4":["英雄联盟","DOTA2","星际争霸2","CSGO","风暴英雄"],"12":["王者荣耀","碧蓝航线","崩坏3","阴阳师","Fate/GO","少女前线","ICHU","狼人杀","荒野行动","决战！平安京"],"7":["映评馆","音乐台"],"8":["聊天","音乐"],"99":["投稿"]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("11")
        private List<String> _$11;
        @SerializedName("10")
        private List<String> _$10;
        @SerializedName("6")
        private List<String> _$6;
        @SerializedName("9")
        private List<String> _$9;
        @SerializedName("2")
        private List<String> _$2;
        @SerializedName("1")
        private List<String> _$1;
        @SerializedName("3")
        private List<String> _$3;
        @SerializedName("4")
        private List<String> _$4;
        @SerializedName("12")
        private List<String> _$12;
        @SerializedName("7")
        private List<String> _$7;
        @SerializedName("8")
        private List<String> _$8;
        @SerializedName("99")
        private List<String> _$99;

        public List<String> get_$11() {
            return _$11;
        }

        public void set_$11(List<String> _$11) {
            this._$11 = _$11;
        }

        public List<String> get_$10() {
            return _$10;
        }

        public void set_$10(List<String> _$10) {
            this._$10 = _$10;
        }

        public List<String> get_$6() {
            return _$6;
        }

        public void set_$6(List<String> _$6) {
            this._$6 = _$6;
        }

        public List<String> get_$9() {
            return _$9;
        }

        public void set_$9(List<String> _$9) {
            this._$9 = _$9;
        }

        public List<String> get_$2() {
            return _$2;
        }

        public void set_$2(List<String> _$2) {
            this._$2 = _$2;
        }

        public List<String> get_$1() {
            return _$1;
        }

        public void set_$1(List<String> _$1) {
            this._$1 = _$1;
        }

        public List<String> get_$3() {
            return _$3;
        }

        public void set_$3(List<String> _$3) {
            this._$3 = _$3;
        }

        public List<String> get_$4() {
            return _$4;
        }

        public void set_$4(List<String> _$4) {
            this._$4 = _$4;
        }

        public List<String> get_$12() {
            return _$12;
        }

        public void set_$12(List<String> _$12) {
            this._$12 = _$12;
        }

        public List<String> get_$7() {
            return _$7;
        }

        public void set_$7(List<String> _$7) {
            this._$7 = _$7;
        }

        public List<String> get_$8() {
            return _$8;
        }

        public void set_$8(List<String> _$8) {
            this._$8 = _$8;
        }

        public List<String> get_$99() {
            return _$99;
        }

        public void set_$99(List<String> _$99) {
            this._$99 = _$99;
        }
    }
}
