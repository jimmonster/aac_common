package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class DetailBean  extends BaseBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : {"fatherId":100006,"mainName":"奥特曼玩玩具","columnId":null,"releaseTime":"2019","mainDesc":"奥特曼玩玩具呀11","sitnums":3,"contentType":"1","dramaType":"玩具","posterPath":"http://127.0.0.1:8080/ms/upload/20190729110803077953.png","posterVoList":[{"fatherId":100008,"mainName":"超级飞侠酷跑游戏解说","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261642260057566.png","posterId":"poster_0"},{"fatherId":100010,"mainName":"漫威英雄玩具屋","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261645340960732.png","posterId":"poster_0"},{"fatherId":100012,"mainName":"芭比的玩具城堡","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261647230595493.png","posterId":"poster_0"},{"fatherId":100013,"mainName":"植物大战僵尸2国际版彩泥秀","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261648090359154.png","posterId":"poster_0"}],"childVos":[{"contentId":100014,"sort":1,"contentName":"奥特曼1","playUrl":"http://192.168.0.1"},{"contentId":100015,"sort":2,"contentName":"奥特曼2","playUrl":"http://192.168.0.1"}]}
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
         * fatherId : 100006
         * mainName : 奥特曼玩玩具
         * columnId : null
         * releaseTime : 2019
         * mainDesc : 奥特曼玩玩具呀11
         * sitnums : 3
         * contentType : 1
         * dramaType : 玩具
         * posterPath : http://127.0.0.1:8080/ms/upload/20190729110803077953.png
         * posterVoList : [{"fatherId":100008,"mainName":"超级飞侠酷跑游戏解说","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261642260057566.png","posterId":"poster_0"},{"fatherId":100010,"mainName":"漫威英雄玩具屋","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261645340960732.png","posterId":"poster_0"},{"fatherId":100012,"mainName":"芭比的玩具城堡","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261647230595493.png","posterId":"poster_0"},{"fatherId":100013,"mainName":"植物大战僵尸2国际版彩泥秀","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261648090359154.png","posterId":"poster_0"}]
         * childVos : [{"contentId":100014,"sort":1,"contentName":"奥特曼1","playUrl":"http://192.168.0.1"},{"contentId":100015,"sort":2,"contentName":"奥特曼2","playUrl":"http://192.168.0.1"}]
         */

        private int fatherId;
        private String mainName;
        private Object columnId;
        private String releaseTime;
        private String mainDesc;
        private int sitnums;
        private String contentType;
        private String dramaType;
        private String posterPath;
        private List<PosterVoListBean> posterVoList;
        private List<ChildVosBean> childVos;

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

        public Object getColumnId() {
            return columnId;
        }

        public void setColumnId(Object columnId) {
            this.columnId = columnId;
        }

        public String getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(String releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getMainDesc() {
            return mainDesc;
        }

        public void setMainDesc(String mainDesc) {
            this.mainDesc = mainDesc;
        }

        public int getSitnums() {
            return sitnums;
        }

        public void setSitnums(int sitnums) {
            this.sitnums = sitnums;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getDramaType() {
            return dramaType;
        }

        public void setDramaType(String dramaType) {
            this.dramaType = dramaType;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public List<PosterVoListBean> getPosterVoList() {
            return posterVoList;
        }

        public void setPosterVoList(List<PosterVoListBean> posterVoList) {
            this.posterVoList = posterVoList;
        }

        public List<ChildVosBean> getChildVos() {
            return childVos;
        }

        public void setChildVos(List<ChildVosBean> childVos) {
            this.childVos = childVos;
        }

        public static class PosterVoListBean {
            /**
             * fatherId : 100008
             * mainName : 超级飞侠酷跑游戏解说
             * type : 1
             * contentType : 1
             * posterPath :
             * homePosterPath : http://127.0.0.1:8080/ms/upload/201907261642260057566.png
             * posterId : poster_0
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

        public static class ChildVosBean {
            /**
             * contentId : 100014
             * sort : 1
             * contentName : 奥特曼1
             * playUrl : http://192.168.0.1
             */

            private int contentId;
            private int sort;
            private String contentName;
            private String playUrl;

            public int getContentId() {
                return contentId;
            }

            public void setContentId(int contentId) {
                this.contentId = contentId;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getContentName() {
                return contentName;
            }

            public void setContentName(String contentName) {
                this.contentName = contentName;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }
        }
    }
}
