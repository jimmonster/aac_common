package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-05
 * @description :
 */
public class SearchBean extends BaseBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : {"pageNum":1,"pageSize":5,"size":5,"orderBy":null,"startRow":1,"endRow":5,"total":9,"pages":2,"list":[{"fatherId":100007,"mainName":"x小猪佩奇玩玩具","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"小猪佩奇玩玩具","sitnums":0,"contentType":"1","dramaType":"玩具","posterPath":null,"homePosterPath":"201907261639230658823.png","state":"1","posterId":"poster_0","keyword":"xzpqwwj","createtime":null,"updatetime":null},{"fatherId":100011,"mainName":"小马宝莉之友谊学校游戏解说","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"小马宝莉之友谊学校游戏解说","sitnums":0,"contentType":"1","dramaType":"游戏","posterPath":null,"homePosterPath":"201907261646290926367.png","state":"1","posterId":"poster_0","keyword":"xmblzyyxxyxjs","createtime":null,"updatetime":null},{"fatherId":100014,"mainName":"小猪佩奇系列专题","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"小猪佩奇系列专题","sitnums":0,"contentType":"1","dramaType":"游戏","posterPath":null,"homePosterPath":"201907261738440986940.png","state":"1","posterId":"poster_0","keyword":"xzpqxlzt","createtime":null,"updatetime":null},{"fatherId":100220,"mainName":"小猪佩奇艺术感知培养","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"运用小猪佩奇卡通形象动态鲜活的在情境中带领小朋友认颜色，让学习变得生动有趣。快来一起认颜色吧！","sitnums":0,"contentType":"1","dramaType":"绘画","posterPath":null,"homePosterPath":null,"state":"0","posterId":null,"keyword":"xzpqysgzpy","createtime":null,"updatetime":null},{"fatherId":100225,"mainName":"形状大课堂","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"运用众多小朋友们喜爱卡通形象动态鲜活的在情境中带领小朋友认各种各样的形状，让学习变得生动有趣。快来一起认识形状吧！","sitnums":0,"contentType":"1","dramaType":"绘画","posterPath":null,"homePosterPath":null,"state":"0","posterId":null,"keyword":"xzdkt","createtime":null,"updatetime":null}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}
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
         * pageNum : 1
         * pageSize : 5
         * size : 5
         * orderBy : null
         * startRow : 1
         * endRow : 5
         * total : 9
         * pages : 2
         * list : [{"fatherId":100007,"mainName":"x小猪佩奇玩玩具","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"小猪佩奇玩玩具","sitnums":0,"contentType":"1","dramaType":"玩具","posterPath":null,"homePosterPath":"201907261639230658823.png","state":"1","posterId":"poster_0","keyword":"xzpqwwj","createtime":null,"updatetime":null},{"fatherId":100011,"mainName":"小马宝莉之友谊学校游戏解说","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"小马宝莉之友谊学校游戏解说","sitnums":0,"contentType":"1","dramaType":"游戏","posterPath":null,"homePosterPath":"201907261646290926367.png","state":"1","posterId":"poster_0","keyword":"xmblzyyxxyxjs","createtime":null,"updatetime":null},{"fatherId":100014,"mainName":"小猪佩奇系列专题","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"小猪佩奇系列专题","sitnums":0,"contentType":"1","dramaType":"游戏","posterPath":null,"homePosterPath":"201907261738440986940.png","state":"1","posterId":"poster_0","keyword":"xzpqxlzt","createtime":null,"updatetime":null},{"fatherId":100220,"mainName":"小猪佩奇艺术感知培养","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"运用小猪佩奇卡通形象动态鲜活的在情境中带领小朋友认颜色，让学习变得生动有趣。快来一起认颜色吧！","sitnums":0,"contentType":"1","dramaType":"绘画","posterPath":null,"homePosterPath":null,"state":"0","posterId":null,"keyword":"xzpqysgzpy","createtime":null,"updatetime":null},{"fatherId":100225,"mainName":"形状大课堂","columnId":-1,"type":"1","releaseTime":"2019","mainDesc":"运用众多小朋友们喜爱卡通形象动态鲜活的在情境中带领小朋友认各种各样的形状，让学习变得生动有趣。快来一起认识形状吧！","sitnums":0,"contentType":"1","dramaType":"绘画","posterPath":null,"homePosterPath":null,"state":"0","posterId":null,"keyword":"xzdkt","createtime":null,"updatetime":null}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private Object orderBy;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int firstPage;
        private int prePage;
        private int nextPage;
        private int lastPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * fatherId : 100007
             * mainName : x小猪佩奇玩玩具
             * columnId : -1
             * type : 1
             * releaseTime : 2019
             * mainDesc : 小猪佩奇玩玩具
             * sitnums : 0
             * contentType : 1
             * dramaType : 玩具
             * posterPath : null
             * homePosterPath : 201907261639230658823.png
             * state : 1
             * posterId : poster_0
             * keyword : xzpqwwj
             * createtime : null
             * updatetime : null
             */

            private int fatherId;
            private String mainName;
            private int columnId;
            private String type;
            private String releaseTime;
            private String mainDesc;
            private int sitnums;
            private String contentType;
            private String dramaType;
            private Object posterPath;
            private String homePosterPath;
            private String state;
            private String posterId;
            private String keyword;
            private Object createtime;
            private Object updatetime;

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

            public int getColumnId() {
                return columnId;
            }

            public void setColumnId(int columnId) {
                this.columnId = columnId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

            public Object getPosterPath() {
                return posterPath;
            }

            public void setPosterPath(Object posterPath) {
                this.posterPath = posterPath;
            }

            public String getHomePosterPath() {
                return homePosterPath;
            }

            public void setHomePosterPath(String homePosterPath) {
                this.homePosterPath = homePosterPath;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getPosterId() {
                return posterId;
            }

            public void setPosterId(String posterId) {
                this.posterId = posterId;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public Object getCreatetime() {
                return createtime;
            }

            public void setCreatetime(Object createtime) {
                this.createtime = createtime;
            }

            public Object getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Object updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
