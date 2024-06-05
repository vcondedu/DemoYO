package com.example.demoyo.ui.proximascitas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProximascitasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProximascitasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is proximascitas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}