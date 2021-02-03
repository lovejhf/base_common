package com.wujian.android.common.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.wujian.android.common.entity.DialogEntity;


public class BaseViewModel extends ViewModel {
    protected DialogLiveData<DialogEntity> showDialog = new DialogLiveData<>();

    public void getShowDialog(LifecycleOwner owner, Observer<DialogEntity> observer) {
        showDialog.observe(owner, observer);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        showDialog = null;
    }
}
