package com.jinhong.jhtv.vm.repository;

import android.arch.lifecycle.MutableLiveData;

import com.jinhong.jhtv.callback.JsonCallback;
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
    private MutableLiveData<Test1Bean> mTest1BeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<TestBean> mTestBeanMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<MainListBean> mainListLiveData = new MutableLiveData<>();
    private MutableLiveData<CollectListBean> collectLiveData = new MutableLiveData<>();
    private MutableLiveData<CategoryLeftBean> categoryLeftLiveData = new MutableLiveData<>();
    private MutableLiveData<DetailBean> detailBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<IsCollectBean> isCollectBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<UpdateCollectBean> updateCollectBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<ProgrammeBean> programmeBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<SearchBean> searchBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<RecordListBean> recordListBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<RecordLocalBean> recordLocalBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<UpdateBookmarkBean> updateBookmarkBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<DeleteRecordBean> deleteRecordBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<SingleCollectBean> singleCollectBeanLiveData = new MutableLiveData<>();
    private MutableLiveData<MultipleCollectBean> multipleCollectBeanLiveData = new MutableLiveData<>();


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
        OkGoUtils.post(url, params, new JsonCallback<MainListBean>() {
                    @Override
                    public void onSuccess(Response<MainListBean> response) {
                        if (response != null) {
                            mainListLiveData.setValue(response.body());
                        }
                    }
                }

        );
        return mainListLiveData;
    }


    //查询收藏列表
    public MutableLiveData<CollectListBean> requestCollectListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<CollectListBean>() {

                    @Override
                    public void onSuccess(Response<CollectListBean> response) {
                        if (response != null) {
                            collectLiveData.setValue(response.body());
                        }
                    }
                }

        );
        return collectLiveData;
    }

    //获取分类界面左边标题的数据
    public MutableLiveData<CategoryLeftBean> requestCategoryLeftData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<CategoryLeftBean>() {
            @Override
            public void onSuccess(Response<CategoryLeftBean> response) {
                if (response != null) {
                    categoryLeftLiveData.setValue(response.body());
                }

            }
        });
        return categoryLeftLiveData;
    }


    //根据剧集id查询剧集详情，及子集列表和推荐位海报
    public MutableLiveData<DetailBean> requestDetailData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<DetailBean>() {
                    @Override
                    public void onSuccess(Response<DetailBean> response) {
                        if (response != null) {
                            detailBeanLiveData.setValue(response.body());
                        }
                    }
                }

        );
        return detailBeanLiveData;
    }


    public MutableLiveData<IsCollectBean> requestIsCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<IsCollectBean>() {

                    @Override
                    public void onSuccess(Response<IsCollectBean> response) {
                        if (response != null) {
                            isCollectBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return isCollectBeanLiveData;
    }

    public MutableLiveData<UpdateCollectBean> requestUpdateCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<UpdateCollectBean>() {

                    @Override
                    public void onSuccess(Response<UpdateCollectBean> response) {
                        if (response != null) {

                            updateCollectBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return updateCollectBeanLiveData;
    }

    public MutableLiveData<ProgrammeBean> requestProgrammeListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<ProgrammeBean>() {

                    @Override
                    public void onSuccess(Response<ProgrammeBean> response) {
                        if (response != null) {

                            programmeBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return programmeBeanLiveData;
    }

    public MutableLiveData<SearchBean> requestSearchData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<SearchBean>() {

                    @Override
                    public void onSuccess(Response<SearchBean> response) {
                        if (response != null) {

                            searchBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return searchBeanLiveData;
    }

    public MutableLiveData<RecordListBean> requestRecordListData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<RecordListBean>() {
                    @Override
                    public void onSuccess(Response<RecordListBean> response) {

                        if (response != null) {
                            recordListBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return recordListBeanLiveData;
    }

    public MutableLiveData<RecordLocalBean> requestRecordLocalData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<RecordLocalBean>() {

                    @Override
                    public void onSuccess(Response<RecordLocalBean> response) {
                        recordLocalBeanLiveData.setValue(response.body());
                    }
                }
        );
        return recordLocalBeanLiveData;
    }

    public MutableLiveData<UpdateBookmarkBean> requestUpdateBookmarkData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<UpdateBookmarkBean>() {

                    @Override
                    public void onSuccess(Response<UpdateBookmarkBean> response) {
                        if (response != null) {

                            updateBookmarkBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return updateBookmarkBeanLiveData;
    }

    public MutableLiveData<DeleteRecordBean> requestDeleteRecordData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<DeleteRecordBean>() {

                    @Override
                    public void onSuccess(Response<DeleteRecordBean> response) {
                        if (response != null) {
                            deleteRecordBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return deleteRecordBeanLiveData;
    }

    public MutableLiveData<SingleCollectBean> requestSingleCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<SingleCollectBean>() {

                    @Override
                    public void onSuccess(Response<SingleCollectBean> response) {
                        if (response != null) {

                            singleCollectBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return singleCollectBeanLiveData;
    }

    public MutableLiveData<MultipleCollectBean> requestMultipleCollectData(String url, HashMap<String, String> params) {
        OkGoUtils.post(url, params, new JsonCallback<MultipleCollectBean>() {

                    @Override
                    public void onSuccess(Response<MultipleCollectBean> response) {
                        if (response != null) {
                            multipleCollectBeanLiveData.setValue(response.body());
                        }
                    }
                }
        );
        return multipleCollectBeanLiveData;
    }
}
