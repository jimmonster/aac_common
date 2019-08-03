package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class MainListBean extends BaseBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : {"posterVos":[{"fatherId":100006,"mainName":"奥特曼玩玩具","type":"1","contentType":"1","posterPath":"http://127.0.0.1:8080/ms/upload/20190729110803077953.png","homePosterPath":"http://127.0.0.1:8080/ms/upload/20190726163606036421.png","posterId":"poster_img_0"},{"fatherId":100007,"mainName":"x小猪佩奇玩玩具","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261639230658823.png","posterId":"poster_img_1"},{"fatherId":100008,"mainName":"超级飞侠酷跑游戏解说","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261642260057566.png","posterId":"poster_img_2"},{"fatherId":100009,"mainName":"汪汪队立大功艺术感知培养","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261644430325305.png","posterId":"poster_img_3"},{"fatherId":100010,"mainName":"漫威英雄玩具屋","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261645340960732.png","posterId":"poster_img_4"},{"fatherId":100011,"mainName":"小马宝莉之友谊学校游戏解说","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261646290926367.png","posterId":"poster_img_5"},{"fatherId":100012,"mainName":"芭比的玩具城堡","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261647230595493.png","posterId":"poster_img_6"},{"fatherId":100013,"mainName":"植物大战僵尸2国际版彩泥秀","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261648090359154.png","posterId":"poster_img_7"},{"fatherId":100014,"mainName":"小猪佩奇系列专题","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261738440986940.png","posterId":"role_img_0"},{"fatherId":100015,"mainName":"汪汪队系列专题","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261650290439643.png","posterId":"role_img_1"},{"fatherId":100016,"mainName":"超级飞侠系列专题","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261651150156838.png","posterId":"role_img_2"},{"fatherId":100017,"mainName":"芭比公主系列专题","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261651580746108.png","posterId":"role_img_3"},{"fatherId":100018,"mainName":"植物大战僵尸系列专题","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261652330255659.png","posterId":"role_img_4"},{"fatherId":100019,"mainName":"奥特曼系列专题","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261653010651918.png","posterId":"role_img_5"}],"columnVos":[{"id":10009,"name":"动画殿堂","type":"0","posterPath":"","posterId":"poster_0"},{"id":10010,"name":"亲子玩具","type":"0","posterPath":"","posterId":"poster_0"},{"id":10011,"name":"亲子游戏","type":"0","posterPath":"","posterId":"poster_0"},{"id":10012,"name":"亲子手工","type":"0","posterPath":"","posterId":"poster_0"},{"id":10013,"name":"亲子绘画","type":"0","posterPath":"","posterId":"poster_0"},{"id":10014,"name":"亲子教育","type":"0","posterPath":"","posterId":"poster_0"},{"id":10015,"name":"萌宝乐园","type":"0","posterPath":"","posterId":"poster_0"}]}
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
        private List<PosterVosBean> posterVos;
        private List<ColumnVosBean> columnVos;

        public List<PosterVosBean> getPosterVos() {
            return posterVos;
        }

        public void setPosterVos(List<PosterVosBean> posterVos) {
            this.posterVos = posterVos;
        }

        public List<ColumnVosBean> getColumnVos() {
            return columnVos;
        }

        public void setColumnVos(List<ColumnVosBean> columnVos) {
            this.columnVos = columnVos;
        }

        public static class PosterVosBean implements Serializable {
            /**
             * fatherId : 100006
             * mainName : 奥特曼玩玩具
             * type : 1
             * contentType : 1
             * posterPath : http://127.0.0.1:8080/ms/upload/20190729110803077953.png
             * homePosterPath : http://127.0.0.1:8080/ms/upload/20190726163606036421.png
             * posterId : poster_img_0
             */

            private int fatherId;
            private String mainName;
            private String type;
            private String contentType;
            private String posterPath;
            private String homePosterPath;
            private String posterId;

            public int getFatherId() {
                return fatherId;
            }

            public void setFatherId(int fatherId) {
                this.fatherId = fatherId;
            }

            public String getMainName() {
                return mainName;
            }

            public void setMainName(String mainName) {
                this.mainName = mainName;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public String getPosterPath() {
                return posterPath;
            }

            public void setPosterPath(String posterPath) {
                this.posterPath = posterPath;
            }

            public String getHomePosterPath() {
                return homePosterPath;
            }

            public void setHomePosterPath(String homePosterPath) {
                this.homePosterPath = homePosterPath;
            }

            public String getPosterId() {
                return posterId;
            }

            public void setPosterId(String posterId) {
                this.posterId = posterId;
            }
        }

        public static class ColumnVosBean {
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
}
