package com.jinhong.jhtv.vm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

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
 * @description :共同的viewModel
 */
public class CommonViewModel extends ViewModel {
    CommonRepository mRepository;

    //测试接口1
    public MutableLiveData<Test1Bean> getTest1Bean(String url) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestgetTest1Data(url);
    }

    //测试接口
    public MutableLiveData<TestBean> getTestBean(String url) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestgetTestData(url);
    }

    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）
    public MutableLiveData<MainListBean> getMainListBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestMainListData(url, params);
    }

    //根据栏目id返回栏目下绑定的节目(适用于普通专题页)
    //columnId - 栏目id
    //pageNum - 当前第几页 默认1
    //pageSize - 每页的数量，默认为6
    public MutableLiveData<ProgrammeBean> getProgrammeBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestProgrammeListData(url, params);
    }

    //返回当前栏目下绑定的子栏目数量（适用于 列表页 获取左侧分类）
    public MutableLiveData<CategoryLeftBean> getCategoryLeftListBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestCategoryLeftData(url, params);
    }

    //根据剧集id查询剧集详情，及子集列表和推荐位海报
    //fatherId - 主集id
    public MutableLiveData<DetailBean> getDetailBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestDetailData(url, params);
    }


    //搜索接口
    //keyword - 搜索关键字
    //pageNum - 当前第几页，默认为1
    //pageSize - 每页的数量，默认为6

    public MutableLiveData<SearchBean> getSearchBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestSearchData(url, params);
    }

    //获取观影记录列表
    //{
    //“userId”:”testott11”,
    //“pageNum”:1,
    //“pageSize”:6
    //}

    public MutableLiveData<RecordListBean> getRecordListBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestRecordListData(url, params);
    }

    //查询书签（查询用户当前观影记录）
    //{
    //“userId”:”testott11”,
    //“fatherId”:1,
    //“contentId”:6
    //}
    public MutableLiveData<RecordLocalBean> getRecordLocalBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestRecordLocalData(url, params);
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
    public MutableLiveData<UpdateBookmarkBean> getUpdateBookmarkBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestUpdateBookmarkData(url, params);
    }

    //查询收藏列表
    // {
    //“userId”:”testott11”,
    //“pageNum”:1,
    //“pageSize”:6
    //}
    public MutableLiveData<CollectListBean> getCollectListBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestCollectListData(url, params);
    }
    //删除单条收藏记录
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11"
    //}

    public MutableLiveData<DeleteRecordBean> getDeleteRecordBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestDeleteRecordData(url, params);
    }


    //查询是否收藏
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11"
    //}
    public MutableLiveData<IsCollectBean> getIsCollectBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestIsCollectData(url, params);
    }

    //上传收藏记录
    //{
    //"fatherId":”xx”,
    //    "userId":"testott11",
    //    "mainName":"奥特曼玩玩具",
    //    "dramaType":"玩具"
    //}
    public MutableLiveData<UpdateCollectBean> updateCollectBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestUpdateCollectData(url, params);
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
    public MutableLiveData<SingleCollectBean> updateSingleCollectBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestSingleCollectData(url, params);
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
    public MutableLiveData<MultipleCollectBean> updateMultipleCollectBean(String url, HashMap<String, String> params) {
        if (mRepository == null) {
            mRepository = new CommonRepository();
        }
        //数据请求建议放在Repository，viewModel主攻业务
        return mRepository.requestMultipleCollectData(url, params);
    }

}
