package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :
 */
public class CollectListBean extends BaseBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : {"startRow":1,"pageSize":10,"total":3,"pages":1,"endRow":3,"isFirstPage":true,"firstPage":1,"prePage":0,"lastPage":1,"hasPreviousPage":false,"size":3,"navigatePages":8,"list":[{"id":1,"fatherId":111,"mainName":"小组佩奇儿歌","userId":"testott11","dramaType":"儿歌","createtime":1563528749000},{"id":2,"fatherId":112,"mainName":"小组佩奇儿歌","userId":"testott11","dramaType":"儿歌","createtime":1563528749000},{"id":22,"fatherId":100006,"mainName":"奥特曼玩玩具","userId":"testott11","dramaType":"玩具","createtime":null}],"pageNum":1,"orderBy":null,"isLastPage":true,"nextPage":0,"hasNextPage":false,"navigatepageNums":[1]}
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
         * startRow : 1
         * pageSize : 10
         * total : 3
         * pages : 1
         * endRow : 3
         * isFirstPage : true
         * firstPage : 1
         * prePage : 0
         * lastPage : 1
         * hasPreviousPage : false
         * size : 3
         * navigatePages : 8
         * list : [{"id":1,"fatherId":111,"mainName":"小组佩奇儿歌","userId":"testott11","dramaType":"儿歌","createtime":1563528749000},{"id":2,"fatherId":112,"mainName":"小组佩奇儿歌","userId":"testott11","dramaType":"儿歌","createtime":1563528749000},{"id":22,"fatherId":100006,"mainName":"奥特曼玩玩具","userId":"testott11","dramaType":"玩具","createtime":null}]
         * pageNum : 1
         * orderBy : null
         * isLastPage : true
         * nextPage : 0
         * hasNextPage : false
         * navigatepageNums : [1]
         */

        private int startRow;
        private int pageSize;
        private int total;
        private int pages;
        private int endRow;
        private boolean isFirstPage;
        private int firstPage;
        private int prePage;
        private int lastPage;
        private boolean hasPreviousPage;
        private int size;
        private int navigatePages;
        private int pageNum;
        private Object orderBy;
        private boolean isLastPage;
        private int nextPage;
        private boolean hasNextPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
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

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
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

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
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
             * id : 1
             * fatherId : 111
             * mainName : 小组佩奇儿歌
             * userId : testott11
             * dramaType : 儿歌
             * createtime : 1563528749000
             */

            private int id;
            private int fatherId;
            private String mainName;
            private String userId;
            private String dramaType;
            private long createtime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

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

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getDramaType() {
                return dramaType;
            }

            public void setDramaType(String dramaType) {
                this.dramaType = dramaType;
            }

            public long getCreatetime() {
                return createtime;
            }

            public void setCreatetime(long createtime) {
                this.createtime = createtime;
            }
        }
    }
}
