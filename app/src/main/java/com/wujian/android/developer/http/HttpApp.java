package com.wujian.android.developer.http;
public class HttpApp  implements IHttp {
    private static HttpApp instance = null;
    private HttpApp() {
    }

    public static synchronized HttpApp getInstance() {
        if (instance == null) {
            synchronized (HttpApp.class) {
                if (instance == null) {
                    instance = new HttpApp();
                }
            }
        }
        return instance;
    }

}
