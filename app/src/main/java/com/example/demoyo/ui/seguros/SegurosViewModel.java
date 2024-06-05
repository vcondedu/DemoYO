package com.example.demoyo.ui.seguros;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SegurosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SegurosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is seguros fragment");
        Log.d("SegurosViewModel", "ViewModel created, text set to: " + mText.getValue());
    }

    public LiveData<String> getText() {
        return mText;
    }
}