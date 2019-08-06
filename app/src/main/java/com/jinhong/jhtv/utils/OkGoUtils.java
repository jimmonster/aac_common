package com.jinhong.jhtv.utils;

import com.jinhong.jhtv.callback.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * OkGo二次封装网络工具
 * Created by jim on 2017/9/16.
 */

public class OkGoUtils {
    /**
     * javaBean对象必须实现Serializable接口
     * cacheMode
     * 目前默认提供了五种CacheMode缓存模式，不同的模式会有不同的Callback回调顺序，详细见下方的回调顺序
     * <p>
     * NO_CACHE：不使用缓存，该模式下cacheKey、cacheTime 参数均无效
     * DEFAULT：按照HTTP协议的默认缓存规则，例如有304响应头时缓存。
     * REQUEST_FAILED_READ_CACHE：先请求网络，如果请求网络失败，则读取缓存，如果读取缓存失败，本次请求失败。
     * IF_NONE_CACHE_REQUEST：如果缓存不存在才请求网络，否则使用缓存。
     * FIRST_CACHE_THEN_REQUEST：先使用缓存，不管是否存在，仍然请求网络。
     */


    //GET方法，不需要TAG
    public static void get(String url, Map<String, String> paramMap, StringCallback callback) {
        OkGo.<String>get(url).params(paramMap).execute(callback);
    }

    //GET方法，需要传递TAG
    public static void get(String url, Map<String, String> paramMap, Object tag, StringCallback callback) {
        OkGo.<String>get(url).params(paramMap).tag(tag).execute(callback);
    }

    //GET方法
    public static void get(String url, StringCallback callback) {
        OkGo.<String>get(url).execute(callback);
    }




    //post，需要传递TAG
    public static void post(String url, Map<String, String> paramMap, Object tag, StringCallback callback) {
        OkGo.<String>post(url).params(paramMap).tag(tag).execute(callback);
    }

    //post，不需要传递TAG
    public static void post(String url, Map<String, String> paramMap, StringCallback callback) {
        OkGo.<String>post(url).headers("Content-Type","application/x-www-form-urlencoded").params(paramMap).execute(callback);
    }


    //post，不需要传递TAG
    public static void post(String url, Map<String, String> paramMap, JsonCallback callback) {
        OkGo.<String>post(url).headers("Content-Type","application/x-www-form-urlencoded").params(paramMap).execute(callback);
    }


    //post,不需要传参
    public static void post(String url, StringCallback callback) {
        OkGo.<String>post(url).execute(callback);
    }


    //post,需要传递表头(token)
    public static void post(String url, Map<String, String> paramMap, String token, StringCallback callback) {
        OkGo.<String>post(url).headers("token", token).params(paramMap).execute(callback);
    }

    //post,需要传递表头(token)以及对象
    public static void post(String url, String json, String token, StringCallback callback) {
        OkGo.<String>post(url).headers("token", token).upJson(json).execute(callback);
    }

    //post，文件传参数下载
    public static void download( String url,  HashMap<String, String> paramMap,  FileCallback callback) {
        OkGo.<File>post(url)
                .params(paramMap)
                .execute(callback);
    }

    //post，文件下载
    public static void download( String url,  FileCallback callback) {
        OkGo.<File>post(url)
                .execute(callback);
    }

    //上传多个文件
    public static void updateFiles( String url,  String fileName, ArrayList<File> files, StringCallback callback) {
        OkGo.<String>post(url)
                .addFileParams(fileName, files)
                .execute(callback);
    }

    //上传单个文件
    public static void updateFiles( String url,  String key,  File file, String fileName, StringCallback callback) {
        OkGo.<String>post(url)
                .isMultipart(true)
                .params(key, file, fileName)
                .execute(callback);
    }

    //上传单个文件
    public static void updateFiles( String url,  String key,  File file, StringCallback callback) {
        OkGo.<String>post(url)
                .isMultipart(true)
                .params(key, file)
                .execute(callback);
    }

    //携带参数上传单个文件
    public static void updateFiles( String url, HashMap<String, String> params,  String key,  File file, StringCallback callback) {
        OkGo.<String>post(url)
                .isMultipart(true)
                .params(params)
                .params(key, file)
                .execute(callback);
    }


    //上传单个文件,无需任何操作
    public static void updateFiles( String url,  File file, StringCallback callback) {
        OkGo.<String>post(url)
                .isMultipart(true)
                .upFile(file)
                .execute(callback);
    }


}
