package com.jinhong.jhtv;

/**
 * @author :  Jim
 * @date :  2019-07-10
 * @description :
 */
public class Constants {
    public static String MAIN = "http://192.168.0.109/";
    //bugly ID and KEY
    public static String BUGLYID = "d9ec61125d";
    public static String BUGLYKEY = "fa91456f-9045-4a3f-b184-65ce46419b6b";

    //真实接口

    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）?columnId=10007
    public static String GET_COLUMN_AND_CONTENT_BY_ID = MAIN + "kdepg_server/subject/getColumnAndContentById.do";
    //根据栏目id返回栏目下绑定的节目(适用于普通专题页)
    public static String GET_CONTENTS_BY_ID = MAIN + "kdepg_server/subject/getContentsById.do";
    //返回当前栏目下绑定的子栏目数量（适用于 列表页 获取左侧分类）
    public static String GET_COLUMNS_BY_ID = MAIN + "kdepg_server/subject/getColumnsById.do";
    //根据剧集id查询剧集详情，及子集列表和推荐位海报?fatherId=100006
    public static String GET_DETAIL_BY_ID = MAIN + "kdepg_server/drama/getDetailById.do";
    //搜索接口
    // keyword - 搜索关键字
    //pageNum - 当前第几页，默认为1
    //pageSize - 每页的数量，默认为6
    public static String POST_BY_KEYWORD = MAIN + "kdepg_server/drama/getBykeyWord.do";
    //观影记录相关接口
    //获取观影记录列表：
    // “userId”:”testott11”,
    //“pageNum”:1,
    //“pageSize”:6
    public static String POST_RECORD_LIST = MAIN + "kdepg_server/playRecord/getlist.do";

    // 查询书签（查询用户当前观影记录）
    // {
    //“userId”:”testott11”,
    //“fatherId”:1,
    //“contentId”:6
    //}
    public static String POST_RECORD_BOOK = MAIN + "kdepg_server/playRecord/getbook.do";

    //上传埋点
    //{
    //“userId”:”testott11”,
    //“fatherId”:1,
    //“contentId”:6,
    //“mainName”:”小猪佩奇”,
    // “contentName”:”小猪佩奇第一集”,
    //“dramaType”:”玩具”,
    //“sort”:”1”,
    //“duration”:”69”,
    //}
    public static String POST_BURIED_POINT = MAIN + "kdepg_server/playRecord/submit.do";
    //收藏相关接口
    //查询收藏列表
    // {
    //“userId”:”testott11”,
    //“pageNum”:1,
    //“pageSize”:6
    //}
    public static String POST_COLLECT_LIST = MAIN + "kdepg_server/collect/getlist.do";
    //删除单条收藏记录
    // {
    //"fatherId":”xx”,
    //    "userId":"testott11"
    //}
    public static String POST_COLLECT_DELETE = MAIN + "kdepg_server/collect/delete.do";
    //查询是否收藏
    public static String POST_COLLECT_IS_COLLECT = MAIN + "kdepg_server/collect/findByCollect.do";
    //上传收藏记录
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11",
    //    "mainName":"奥特曼玩玩具",
    //    "dramaType":"玩具"
    //}
    public static String POST_COLLECT_SUBMIT = MAIN + "kdepg_server/collect/submit.do";
    //单条日志上传接口
    //{
    //"clickTime":”20190303101010”,
    //    "clientIp":"1.1.1.1",
    //    "productName":"qhz",
    //"productPage":"category",
    //"area":”1”,
    //    "sort":"3",
    //    "options":"0",
    //"contentId":"100010",
    //“contentName”:”小猪佩奇”
    //
    //}
    public static String POST_SINGLE_LOG_INSERT = MAIN + "kdepg_server/log/insert.do";
    //多条日志上传接口
    //[
    //{
    //"clickTime":”20190303101010”,
    //    "clientIp":"1.1.1.1",
    //    "productName":"qhz",
    //"productPage":"category",
    //"area":”1”,
    //    "sort":"3",
    //    "options":"0",
    //"contentId":"100010",
    //“contentName”:”小猪佩奇"
    //}
    //]
    public static String POST_MULTIPLE_LOG_INSERT = MAIN + "kdepg_server/log/batchInsert.do";


    //测试接口
    public static String TEST_URL = "http://api.live.bilibili.com/AppIndex/tags?_device=android&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&ts=1495438990&sign=27e923afa5c522c9c8c42f6e56f4bf99";
    public static String TEST_URL1 = "http://api.live.bilibili.com//mobile/rooms?platform=android";

}