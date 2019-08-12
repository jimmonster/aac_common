package com.jinhong.jhtv.vm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jinhong.jhtv.Constants;
import com.jinhong.jhtv.model.CategoryLeftBean;
import com.jinhong.jhtv.model.CollectListBean;
import com.jinhong.jhtv.model.DeleteRecordBean;
import com.jinhong.jhtv.model.DetailBean;
import com.jinhong.jhtv.model.IsCollectBean;
import com.jinhong.jhtv.model.MainListBean;
import com.jinhong.jhtv.model.MultipleCollectBean;
import com.jinhong.jhtv.model.ProgrammeBean;
import com.jinhong.jhtv.model.RecordListBean;
import com.jinhong.jhtv.model.RecordLocalBean;
import com.jinhong.jhtv.model.SearchBean;
import com.jinhong.jhtv.model.SingleCollectBean;
import com.jinhong.jhtv.model.Test1Bean;
import com.jinhong.jhtv.model.TestBean;
import com.jinhong.jhtv.model.UpdateBookmarkBean;
import com.jinhong.jhtv.model.UpdateCollectBean;
import com.jinhong.jhtv.vm.repository.CommonRepository;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :共同的viewModel,用来处理视图和数据的交互
 */
public class CommonViewModel extends ViewModel {
    private CommonRepository mRepository;

    public CommonViewModel() {
        mRepository = new CommonRepository();
    }

    //测试接口1
    public MutableLiveData<Test1Bean> getTest1Bean(String url) {

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestgetTest1Data(url);
    }

    //测试接口
    public MutableLiveData<TestBean> getTestBean(String url) {

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestgetTestData(url);
    }

    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）
    public MutableLiveData<MainListBean> getMainListBean(String id) {

        HashMap<String, String> params = new HashMap<>();
        params.put("columnId", id);

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestMainListData(Constants.GET_COLUMN_AND_CONTENT_BY_ID, params);
    }

    //根据栏目id返回栏目下绑定的节目(适用于普通专题页)
    //columnId - 栏目id
    //pageNum - 当前第几页 默认1
    //pageSize - 每页的数量，默认为6
    public MutableLiveData<ProgrammeBean> getProgrammeBean(String columnId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("columnId", columnId);
        params.put("pageNum", "1");
        params.put("pageSize", "200");
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestProgrammeListData(Constants.GET_CONTENTS_BY_ID, params);
    }

    //返回当前栏目下绑定的子栏目数量（适用于 列表页 获取左侧分类）
    public MutableLiveData<CategoryLeftBean> getCategoryLeftListBean(String columnId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("columnId", columnId);
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestCategoryLeftData(Constants.GET_COLUMNS_BY_ID, params);
    }

    //根据剧集id查询剧集详情，及子集列表和推荐位海报
    //fatherId - 主集id
    public MutableLiveData<DetailBean> getDetailBean(String fatherId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("fatherId", fatherId);
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestDetailData(Constants.GET_DETAIL_BY_ID, params);
    }


    //搜索接口
    //keyword - 搜索关键字
    //pageNum - 当前第几页，默认为1
    //pageSize - 每页的数量，默认为6

    public MutableLiveData<SearchBean> getSearchBean(String keyword) {
        HashMap<String, String> params = new HashMap<>();
        params.put("keyword", keyword);
        params.put("pageNum", "1");
        params.put("pageSize", "100");


        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestSearchData(Constants.POST_BY_KEYWORD, params);
    }

    //获取观影记录列表
    //{
    //“userId”:”testott11”,
    //“pageNum”:1,
    //“pageSize”:6
    //}

    public MutableLiveData<RecordListBean> getRecordListBean(String userId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("pageNum", "1");
        params.put("pageSize", "6");

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestRecordListData(Constants.POST_RECORD_LIST, params);
    }

    //查询书签（查询用户当前观影记录）
    //{
    //“userId”:”testott11”,
    //“fatherId”:1,
    //“contentId”:6
    //}
    public MutableLiveData<RecordLocalBean> getRecordLocalBean(String userId, String fatherId, String contentId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("fatherId", fatherId);
        params.put("contentId", contentId);

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestRecordLocalData(Constants.POST_RECORD_BOOK, params);
    }

    //上传书签
    //{
    //“userId”:”testott11”,
    //“fatherId”:1,
    //“contentId”:6,
    //“mainName”:”小猪佩奇”,
    //“contentName”:”小猪佩奇第一集”,
    //“dramaType”:”玩具”,
    //“sort”:”1”,
    //“duration”:”69”,
    //
    //}
    public MutableLiveData<UpdateBookmarkBean> getUpdateBookmarkBean(HashMap<String, String> params) {

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestUpdateBookmarkData(Constants.POST_BURIED_POINT, params);
    }

    //查询收藏列表
    // {
    //“userId”:”testott11”,
    //“pageNum”:1,
    //“pageSize”:6
    //}
    public MutableLiveData<CollectListBean> getCollectListBean(String userId, String pageNum, String pageSize) {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestCollectListData(Constants.POST_COLLECT_LIST, params);
    }
    //删除单条收藏记录
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11"
    //}

    public MutableLiveData<DeleteRecordBean> getDeleteRecordBean(String fatherId, String userId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("fatherId", fatherId);
        params.put("userId", userId);
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestDeleteRecordData(Constants.POST_COLLECT_DELETE, params);
    }


    //查询是否收藏
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11"
    //}
    public MutableLiveData<IsCollectBean> getIsCollectBean(String fatherId, String userId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("fatherId", fatherId);
        params.put("userId", userId);

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestIsCollectData(Constants.POST_COLLECT_IS_COLLECT, params);
    }

    //上传收藏记录
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11",
    //    "mainName":"奥特曼玩玩具",
    //    "dramaType":"玩具"
    //}
    public MutableLiveData<UpdateCollectBean> updateCollectBean(String fatherId, String userId, String mainName, String dramaType) {
        HashMap<String, String> params = new HashMap<>();
        params.put("fatherId", fatherId);
        params.put("userId", userId);
        params.put("mainName", mainName);
        params.put("dramaType", dramaType);
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestUpdateCollectData(Constants.POST_COLLECT_SUBMIT, params);
    }

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
    public MutableLiveData<SingleCollectBean> updateSingleCollectBean(HashMap<String, String> params) {


        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestSingleCollectData(Constants.POST_SINGLE_LOG_INSERT, params);
    }

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
    //“contentName”:”小猪佩奇”
    //
    //}
    //]
    public MutableLiveData<MultipleCollectBean> updateMultipleCollectBean(HashMap<String, String> params) {

        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestMultipleCollectData(Constants.POST_MULTIPLE_LOG_INSERT, params);
    }

}
