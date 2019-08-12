package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

/**
 * @author :  Jim
 * @date :  2019-08-10
 * @description :
 */
public class MainIdBean  extends BaseBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : {"main":"10007","toy":"10037","game":"10044","manual":"10046","education":"10048","draw":"10048"}
     */

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * main : 10007
         * toy : 10037
         * game : 10044
         * manual : 10046
         * education : 10048
         * draw : 10048
         */

        private String main;
        private String toy;
        private String game;
        private String manual;
        private String education;
        private String draw;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getToy() {
            return toy;
        }

        public void setToy(String toy) {
            this.toy = toy;
        }

        public String getGame() {
            return game;
        }

        public void setGame(String game) {
            this.game = game;
        }

        public String getManual() {
            return manual;
        }

        public void setManual(String manual) {
            this.manual = manual;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getDraw() {
            return draw;
        }

        public void setDraw(String draw) {
            this.draw = draw;
        }
    }
}
