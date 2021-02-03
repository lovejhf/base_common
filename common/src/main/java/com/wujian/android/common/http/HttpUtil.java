package com.wujian.android.common.http;


import com.hjq.toast.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.wujian.android.common.Constants;


public class HttpUtil {
    private static HttpUtil instance = null;
    private HttpUtil() {
    }

    public static synchronized HttpUtil getInstance() {
        if (instance == null) {
            synchronized (HttpUtil.class) {
                if (instance == null) {
                    instance = new HttpUtil();
                }
            }
        }
        return instance;
    }

    public void post(final String url, HttpParams map, final HttpHandler httpHandler) {
        OkGo.<String> post(Constants.SERVER_PATH+url).params(map).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                /**
                 * 进行登录  刷新数据
                 *   httpHandler.requestLoginSuccess();自动登录成功回调
                 */
                httpHandler.requestSuccess(response.body());


            }

            @Override
            public void onCacheSuccess(Response<String> response) {
                super.onCacheSuccess(response);
                httpHandler.requestSuccess(response.body());
            }


            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtils.show("似乎与服务器断开了,请检查网络环境.");
            }
        });

    }





    public void post(final String url, final HttpHandler httpHandler) {
        OkGo.<String>post(Constants.SERVER_PATH + url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //json解析判断是否需要登录如果已登录否则进行登录
                        //返回body
                        httpHandler.requestSuccess(response.body());
                    }

                    @Override
                    public void onCacheSuccess(Response<String> response) {
                        super.onCacheSuccess(response);
                        httpHandler.requestSuccess(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        ToastUtils.show("似乎与服务器断开了,请检查网络环境.");

                    }
                });


    }

}
