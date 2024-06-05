package com.example.demoyo.ui.miscitas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MiscitasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MiscitasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is miscitas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}