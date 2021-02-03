package com.wujian.android.common;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;

//import com.alibaba.android.arouter.launcher.ARouter;

import com.alibaba.android.arouter.launcher.ARouter;

import me.yokeyword.fragmentation.SupportActivity;


public abstract class BaseActivity extends SupportActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ARouter.getInstance().inject(this);   //注入
        setContentView(getLayout());
        initView();
    }

    public abstract int  getLayout();

    public abstract  void  initView();


}
