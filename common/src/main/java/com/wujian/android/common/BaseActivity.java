package com.wujian.android.common;


import androidx.databinding.ViewDataBinding;

import com.wujian.android.common.livedata.BaseViewModel;


public abstract class BaseActivity<VM extends BaseViewModel,DB extends ViewDataBinding> extends BasicActivity<DB> {
    protected VM viewModel;

    @Override
    protected DB initDataBinding(int layoutId) {
        DB db = super.initDataBinding( layoutId);
        viewModel = initViewModel();
        return db;
    }

    /**
     * 初始化ViewModel
     */
    protected abstract VM initViewModel();
}
