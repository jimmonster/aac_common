package com.jinhong.jhtv.model;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-07-02
 * @description :
 */
public class CategoryBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : [{"id":10009,"name":"动画殿堂","type":"0","posterPath":"","posterId":"poster_0"},{"id":10010,"name":"亲子玩具","type":"0","posterPath":"","posterId":"poster_0"},{"id":10011,"name":"亲子游戏","type":"0","posterPath":"","posterId":"poster_0"},{"id":10012,"name":"亲子手工","type":"0","posterPath":"","posterId":"poster_0"}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 10009
         * name : 动画殿堂
         * type : 0
         * posterPath :
         * posterId : poster_0
         */

        private int id;
        private String name;
        private String type;
        private String posterPath;
        private String posterId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getPosterId() {
            return posterId;
        }

        public void setPosterId(String posterId) {
            this.posterId = posterId;
        }
    }
}
