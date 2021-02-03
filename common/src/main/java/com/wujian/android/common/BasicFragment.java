package com.wujian.android.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;


import com.wujian.android.common.weight.LoadingDialog;

import me.yokeyword.fragmentation.SupportFragment;



public abstract class BasicFragment<DB extends ViewDataBinding> extends SupportFragment {

    protected DB dataBinding;
    protected Context context;
    protected FragmentActivity activity;
    private LoadingDialog loadingDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = initDataBinding(inflater, onCreate(), container);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        initView();
        initData();
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        onUserShow();
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        onUserHidden();
    }

    /**
     * 初始化要加载的布局资源ID
     */
    protected abstract int onCreate();


    /**
     * 初始化DataBinding
     */
    protected DB initDataBinding(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup container) {
        return DataBindingUtil.inflate(inflater, layoutId, container, false);
    }
    /**
     * fragment 隐藏
     */

    protected  abstract  void onUserHidden();
    /**
     * fragment 显示
     */
    protected  abstract  void onUserShow();
    /**
     * 初始化视图
     */
    protected abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 显示用户等待框
     *
     * @param msg 提示信息
     */
    protected void showDialog(String msg) {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.setLoadingMsg(msg);
        } else {
            loadingDialog = new LoadingDialog(context);
            loadingDialog.setLoadingMsg(msg);
            loadingDialog.show();
        }
    }

    /**
     * 隐藏等待框
     */
    protected void dismissDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dataBinding != null) {
            dataBinding.unbind();
        }
    }
}