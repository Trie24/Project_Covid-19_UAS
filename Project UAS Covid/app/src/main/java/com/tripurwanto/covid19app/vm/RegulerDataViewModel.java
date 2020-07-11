package com.tripurwanto.covid19app.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tripurwanto.covid19app.api.regulerData.RegulerData;
import com.tripurwanto.covid19app.repo.RegulerDataRepository;

public class RegulerDataViewModel extends ViewModel {
    private MutableLiveData<RegulerData> regulerData;
    private MutableLiveData<Boolean> isLoading;
    private RegulerDataRepository regulerDataRepository;

    public void init() {
        if (regulerData != null){
            return;
        }
        regulerDataRepository = RegulerDataRepository.getInstance();
        regulerData = regulerDataRepository.getRegulerData();
        isLoading = regulerDataRepository.getLoading();

    }

    public LiveData<RegulerData> getRegulerData() {
        return regulerData;
    }

    public LiveData<Boolean> getLoading() {
        return isLoading;
    }

}
