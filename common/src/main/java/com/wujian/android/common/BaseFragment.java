package com.wujian.android.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.wujian.android.common.livedata.BaseViewModel;


public abstract class BaseFragment<VM extends BaseViewModel,DB extends ViewDataBinding> extends BasicFragment<DB> {
    protected VM viewModel;

    @Override
    protected DB initDataBinding(LayoutInflater inflater, int layoutId, ViewGroup container) {
        DB db = super.initDataBinding(inflater, layoutId, container);
        /**
         * 将这两个初始化函数插在{@link com.wujian.android.common.BaseFragment#initDataBinding}
         */
        viewModel = initViewModel();
        initObserve();
        return db;
    }
    @Override
    protected void onUserHidden() {

    }

    @Override
    protected void onUserShow() {

    }
    /**
     * 初始化ViewModel
     */
    protected abstract VM initViewModel();

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private void initObserve() {
        if (viewModel == null) return;
        viewModel.getShowDialog(this, bean -> {
            if (bean.isShow()) {
                showDialog(bean.getMsg());
            } else {
                dismissDialog();
            }
        });
    }

}
