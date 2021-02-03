package com.wujian.android.common.livedata;

import androidx.lifecycle.MutableLiveData;

import com.wujian.android.common.entity.DialogEntity;



public final class DialogLiveData<T> extends MutableLiveData<T> {

    private DialogEntity bean = new DialogEntity();

    public void setValue(boolean isShow) {
        bean.setShow(isShow);
        bean.setMsg("");
        setValue((T) bean);
    }

    public void setValue(boolean isShow, String msg) {
        bean.setShow(isShow);
        bean.setMsg(msg);
        setValue((T) bean);
    }
}