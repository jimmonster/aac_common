package com.jinhong.jhtv.model;

import com.jinhong.jhtv.base.BaseBean;

import java.util.List;

/**
 * @author :  Jim
 * @date :  2019-08-05
 * @description :
 */
public class RecordListBean  extends BaseBean {

    /**
     * status : 0
     * msg : 查询成功
     * data : {"pageNum":1,"pageSize":6,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":1,"userId":"testott11","fatherId":222,"contentId":222,"mainName":"","contentName":"唱儿歌系列","sort":"1","dramaType":"玩具","dration":"40","createtime":1563528762000,"updatetime":1563528762000},{"id":2,"userId":"testott11","fatherId":23,"contentId":222,"mainName":"","contentName":"唱儿歌系列","sort":"1","dramaType":"少儿","dration":"50","createtime":1563528762000,"updatetime":1563528762000}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * pageSize : 6
         * size : 2
         * orderBy : null
         * startRow : 1
         * endRow : 2
         * total : 2
         * pages : 1
         * list : [{"id":1,"userId":"testott11","fatherId":222,"contentId":222,"mainName":"","contentName":"唱儿歌系列","sort":"1","dramaType":"玩具","dration":"40","createtime":1563528762000,"updatetime":1563528762000},{"id":2,"userId":"testott11","fatherId":23,"contentId":222,"mainName":"","contentName":"唱儿歌系列","sort":"1","dramaType":"少儿","dration":"50","createtime":1563528762000,"updatetime":1563528762000}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 0
         * lastPage : 1
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
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
             * id : 1
             * userId : testott11
             * fatherId : 222
             * contentId : 222
             * mainName :
             * contentName : 唱儿歌系列
             * sort : 1
             * dramaType : 玩具
             * dration : 40
             * createtime : 1563528762000
             * updatetime : 1563528762000
             */

            private int id;
            private String userId;
            private int fatherId;
            private int contentId;
            private String mainName;
            private String contentName;
            private String sort;
            private String dramaType;
            private String dration;
            private long createtime;
            private long updatetime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public int getFatherId() {
                return fatherId;
            }

            public void setFatherId(int fatherId) {
                this.fatherId = fatherId;
            }

            public int getContentId() {
                return contentId;
            }

            public void setContentId(int contentId) {
                this.contentId = contentId;
            }

            public String getMainName() {
                return mainName;
            }

            public void setMainName(String mainName) {
                this.mainName = mainName;
            }

            public String getContentName() {
                return contentName;
            }

            public void setContentName(String contentName) {
                this.contentName = contentName;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getDramaType() {
                return dramaType;
            }

            public void setDramaType(String dramaType) {
                this.dramaType = dramaType;
            }

            public String getDration() {
                return dration;
            }

            public void setDration(String dration) {
                this.dration = dration;
            }

            public long getCreatetime() {
                return createtime;
            }

            public void setCreatetime(long createtime) {
                this.createtime = createtime;
            }

            public long getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(long updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
