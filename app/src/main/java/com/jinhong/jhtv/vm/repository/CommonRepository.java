package com.jinhong.jhtv.vm.repository;

import android.arch.lifecycle.MutableLiveData;

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
import com.jinhong.jhtv.utils.GsonUtil;
import com.jinhong.jhtv.utils.OkGoUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * @author :  Jim
 * @date :  2019-08-03
 * @description :共同的处理数据请求的仓库
 */
public class CommonRepository {
    MutableLiveData<Test1Bean> mTest1BeanMutableLiveData = new MutableLiveData<>();
    MutableLiveData<TestBean> mTestBeanMutableLiveData = new MutableLiveData<>();

    MutableLiveData<MainListBean> mainListLiveData = new MutableLiveData<>();
    MutableLiveData<CollectListBean> collectLiveData = new MutableLiveData<>();
    MutableLiveData<CategoryLeftBean> categoryLeftLiveData = new MutableLiveData<>();
    MutableLiveData<DetailBean> detailBeanLiveData = new MutableLiveData<>();
    MutableLiveData<IsCollectBean> isCollectBeanLiveData = new MutableLiveData<>();
    MutableLiveData<UpdateCollectBean> updateCollectBeanLiveData = new MutableLiveData<>();
    MutableLiveData<ProgrammeBean> programmeBeanLiveData = new MutableLiveData<>();
    MutableLiveData<SearchBean> searchBeanLiveData = new MutableLiveData<>();
    MutableLiveData<RecordListBean> recordListBeanLiveData = new MutableLiveData<>();
    MutableLiveData<RecordLocalBean> recordLocalBeanLiveData = new MutableLiveData<>();
    MutableLiveData<UpdateBookmarkBean> updateBookmarkBeanLiveData = new MutableLiveData<>();
    MutableLiveData<DeleteRecordBean> deleteRecordBeanLiveData = new MutableLiveData<>();
    MutableLiveData<SingleCollectBean> singleCollectBeanLiveData = new MutableLiveData<>();
    MutableLiveData<MultipleCollectBean> multipleCollectBeanLiveData = new MutableLiveData<>();


    public MutableLiveData<Test1Bean> requestgetTest1Data(String url) {
        OkGoUtils.get(url, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    Test1Bean test1Bean = GsonUtil.GsonToBean(response.body(), Test1Bean.class);
                    mTest1BeanMutableLiveData.setValue(test1Bean);
                }
            }
        });
        return mTest1BeanMutableLiveData;
    }


    public MutableLiveData<TestBean> requestgetTestData(String url) {

        OkGoUtils.get(url, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response != null) {
                    TestBean testBean = GsonUtil.GsonToBean(response.body(), TestBean.class);
                    mTestBeanMutableLiveData.setValue(testBean);
                }
            }
        });
        return mTestBeanMutableLiveData;
    }


    //根据栏目id查询栏目下绑定的内容列表与子栏目列表（适用于首页）
    public MutableLiveData<MainListBean> requestMainListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            MainListBean mainListBean = GsonUtil.GsonToBean(response.body(), MainListBean.class);
                            mainListLiveData.setValue(mainListBean);
                        }
                    }
                }

        );
        return mainListLiveData;
    }


    //查询收藏列表
    public MutableLiveData<CollectListBean> requestCollectListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            CollectListBean collectLiveData = GsonUtil.GsonToBean(response.body(), CollectListBean.class);
                            CommonRepository.this.collectLiveData.setValue(collectLiveData);
                        }
                    }
                }

        );
        return collectLiveData;
    }

    //获取分类界面左边标题的数据
    public MutableLiveData<CategoryLeftBean> requestCategoryLeftData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            CategoryLeftBean categoryLeftBean = GsonUtil.GsonToBean(response.body(), CategoryLeftBean.class);
                            categoryLeftLiveData.setValue(categoryLeftBean);
                        }
                    }
                }

        );
        return categoryLeftLiveData;
    }


    //根据剧集id查询剧集详情，及子集列表和推荐位海报
    public MutableLiveData<DetailBean> requestDetailData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            DetailBean detailBean = GsonUtil.GsonToBean(response.body(), DetailBean.class);
                            detailBeanLiveData.setValue(detailBean);
                        }
                    }
                }

        );
        return detailBeanLiveData;
    }


    public MutableLiveData<IsCollectBean> requestIsCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            IsCollectBean isCollectBean = GsonUtil.GsonToBean(response.body(), IsCollectBean.class);
                            isCollectBeanLiveData.setValue(isCollectBean);
                        }
                    }
                }
        );
        return isCollectBeanLiveData;
    }

    public MutableLiveData<UpdateCollectBean> requestUpdateCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            UpdateCollectBean updateCollectBean = GsonUtil.GsonToBean(response.body(), UpdateCollectBean.class);
                            updateCollectBeanLiveData.setValue(updateCollectBean);
                        }
                    }
                }
        );
        return updateCollectBeanLiveData;
    }

    public MutableLiveData<ProgrammeBean> requestProgrammeListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            ProgrammeBean programmeBean = GsonUtil.GsonToBean(response.body(), ProgrammeBean.class);
                            programmeBeanLiveData.setValue(programmeBean);
                        }
                    }
                }
        );
        return programmeBeanLiveData;
    }


    public MutableLiveData<SearchBean> requestSearchData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            SearchBean searchBean = GsonUtil.GsonToBean(response.body(), SearchBean.class);
                            searchBeanLiveData.setValue(searchBean);
                        }
                    }
                }
        );
        return searchBeanLiveData;
    }

    public MutableLiveData<RecordListBean> requestRecordListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            RecordListBean recordListBean = GsonUtil.GsonToBean(response.body(), RecordListBean.class);
                            recordListBeanLiveData.setValue(recordListBean);
                        }
                    }
                }
        );
        return recordListBeanLiveData;
    }

    public MutableLiveData<RecordLocalBean> requestRecordLocalData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            RecordLocalBean recordLocalBean = GsonUtil.GsonToBean(response.body(), RecordLocalBean.class);
                            recordLocalBeanLiveData.setValue(recordLocalBean);
                        }
                    }
                }
        );
        return recordLocalBeanLiveData;
    }

    public MutableLiveData<UpdateBookmarkBean> requestUpdateBookmarkData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            UpdateBookmarkBean recordLocalBean = GsonUtil.GsonToBean(response.body(), UpdateBookmarkBean.class);
                            updateBookmarkBeanLiveData.setValue(recordLocalBean);
                        }
                    }
                }
        );
        return updateBookmarkBeanLiveData;
    }

    public MutableLiveData<DeleteRecordBean> requestDeleteRecordData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            DeleteRecordBean deleteRecordBean = GsonUtil.GsonToBean(response.body(), DeleteRecordBean.class);
                            deleteRecordBeanLiveData.setValue(deleteRecordBean);
                        }
                    }
                }
        );
        return deleteRecordBeanLiveData;
    }

    public MutableLiveData<SingleCollectBean> requestSingleCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            SingleCollectBean singleCollectBean = GsonUtil.GsonToBean(response.body(), SingleCollectBean.class);
                            singleCollectBeanLiveData.setValue(singleCollectBean);
                        }
                    }
                }
        );
        return singleCollectBeanLiveData;
    }

    public MutableLiveData<MultipleCollectBean> requestMultipleCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            MultipleCollectBean multipleCollectBean = GsonUtil.GsonToBean(response.body(), MultipleCollectBean.class);
                            multipleCollectBeanLiveData.setValue(multipleCollectBean);
                        }
                    }
                }
        );
        return multipleCollectBeanLiveData;
    }
}
