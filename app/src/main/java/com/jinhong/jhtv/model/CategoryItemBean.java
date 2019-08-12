package com.jinhong.jhtv.model;

import java.util.List;

public class  CategoryItemBean{

    /**
     * status : 0
     * msg : 查询成功
     * data : {"pageNum":1,"pageSize":6,"size":6,"orderBy":null,"startRow":1,"endRow":6,"total":14,"pages":3,"list":[{"fatherId":100006,"mainName":"奥特曼玩玩具","type":"1","contentType":"1","posterPath":"http://127.0.0.1:8080/ms/upload/20190729110803077953.png","homePosterPath":"http://127.0.0.1:8080/ms/upload/20190726163606036421.png","posterId":"poster_img_0"},{"fatherId":100007,"mainName":"x小猪佩奇玩玩具","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261639230658823.png","posterId":"poster_img_1"}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]}
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
         * size : 6
         * orderBy : null
         * startRow : 1
         * endRow : 6
         * total : 14
         * pages : 3
         * list : [{"fatherId":100006,"mainName":"奥特曼玩玩具","type":"1","contentType":"1","posterPath":"http://127.0.0.1:8080/ms/upload/20190729110803077953.png","homePosterPath":"http://127.0.0.1:8080/ms/upload/20190726163606036421.png","posterId":"poster_img_0"},{"fatherId":100007,"mainName":"x小猪佩奇玩玩具","type":"1","contentType":"1","posterPath":"","homePosterPath":"http://127.0.0.1:8080/ms/upload/201907261639230658823.png","posterId":"poster_img_1"}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 3
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3]
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
    }
}
