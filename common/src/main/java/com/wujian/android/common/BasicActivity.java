package com.wujian.android.common;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;

import me.yokeyword.fragmentation.SupportActivity;

public abstract  class BasicActivity<DB extends ViewDataBinding> extends SupportActivity {
    protected DB dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ARouter.getInstance().inject(this);   //注入
        dataBinding = initDataBinding(onCreate());
        initView();
        initImmersionBar();
    }
    /**
     * 初始化要加载的布局资源ID
     */
    protected abstract int onCreate();

    protected abstract void initView();

    protected void initImmersionBar(){
        ImmersionBar.with(this).navigationBarColor(R.color.white).statusBarColor(R.color.white).autoDarkModeEnable(true).init();
    }
    /**
     * 初始化DataBinding
     */
    protected DB initDataBinding( @LayoutRes int layoutId) {
        return DataBindingUtil.setContentView(this,layoutId);
    }
}
