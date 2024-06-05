package com.example.demoyo.ui.agendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgendarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AgendarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is agendar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}