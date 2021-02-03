package com.wujian.android.developer;
import androidx.lifecycle.ViewModelProviders;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.wujian.android.common.BaseActivity;
import com.wujian.android.developer.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    private String [] mTitles={"首页","踩点","我的"};

    @Override
    protected int onCreate() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        //ui主线程
        CacheDiskUtils.getInstance().getCacheSize();
    }

    @Override
    protected MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }
}