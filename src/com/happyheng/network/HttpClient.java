package com.happyheng.network;

import java.util.Map;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 基于"Okhttp"的网络访问工具类
 * 注意在所有的请求中，都会有请求对应的路径名，和对应的键值对，需要把键值对序列化成json，然后请求时让s对应此json。这样是为了
 * 将数据加密
 */
public class HttpClient {

    private static final String DEFAULT_NULL_RESULT = "";  //默认的空返回值


    private static OkHttpClient mOkHttpClient =  new OkHttpClient.Builder().build();

    /**
     * 同步从网络上获取数据
     *
     * @param url   请求的url
     * @param bodys 此为请求的键值对数组
     * @return 返回请求的json字符串，如果失败，返回""
     */
    public static String doSyncRequest(String url,  Map<String, String> requestMap) {

       return doSyncRequest(url, requestMap, true);
    }
    
    public static String doSyncRequest(String url,  Map<String, String> requestMap,boolean isPost) {

        Request request;
        Response response;
        try {
        	if (isPost) {
        		request = HttpClientRequestHelper.getPostRequest(url, requestMap);
			}
        	else {
        		request = HttpClientRequestHelper.getGetRequest(url, requestMap);
			}
        	response = mOkHttpClient.newCall(request).execute();
            

            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DEFAULT_NULL_RESULT;
    }


    /**
     * 异步去网络上请求数据的方法
     *
     * @param url          请求的url
     * @param bodys  此为请求的键值对数组
     * @param requestListener 请求回调的接口  两种情况:
     *                        请求完全成功后，才会调用onSuccess()方法，其它调用onFail()方法
     */
//    public static void doAsyncPost(String url, PostRequestBody[] bodys, final OnRequestListener<String> requestListener) {
//        final Request request;
//        try {
//            request = HttpClientRequestHelper.getRequest(url, bodys, okhttp3.CacheControl.FORCE_NETWORK);
//
//            mOkHttpClient.newCall(request).enqueue(new Callback() {
//
//                @Override
//                public void onResponse(Call call, final Response response) throws IOException {
//
//
//                    try {
//                        if (response.isSuccessful()) {
//
//                            final String result = response.body().string();
//                            ThreadUtils.runOnMainThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    requestListener.onSuccess(result);
//                                }
//                            });
//
//                        }
//                        //在这里失败，即为返回的code不在200-300之间，意思即为服务器出现的错误，这种情况很少出现，但视为网络错误
//                        else {
//                            ThreadUtils.runOnMainThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    requestListener.onFail();
//                                }
//                            });
//                        }
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        ThreadUtils.runOnMainThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                requestListener.onFail();
//                            }
//                        });
//                    }
//                }
//
//                //一般来说，如果是失败的话，一般都为网络异常，比如手机未联网等
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    ThreadUtils.runOnMainThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            requestListener.onFail();
//                        }
//                    });
//                }
//            });
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            requestListener.onFail();
//        }
//
//    }

}
