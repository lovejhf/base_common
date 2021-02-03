package com.wujian.android.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.blankj.utilcode.util.SpanUtils;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private String [] mTitles={"首页","踩点","我的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        CacheDiskUtils.getInstance().getCacheSize();
    }
    public void jump(View view) {
        ARouter.getInstance().build("/app/login").navigation();
    }
}