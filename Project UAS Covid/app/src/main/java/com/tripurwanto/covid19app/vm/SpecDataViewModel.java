package com.tripurwanto.covid19app.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tripurwanto.covid19app.api.specData.SpecData;
import com.tripurwanto.covid19app.repo.SpecDataRepository;

public class SpecDataViewModel extends ViewModel {

    private MutableLiveData<SpecData> specData;
    private MutableLiveData<Boolean> isLoading;
    private SpecDataRepository specDataRepository;

    public void init() {
        if (specData != null){
            return;
        }
        specDataRepository = SpecDataRepository.getInstance();
        specData = specDataRepository.getSpecData();
        isLoading = specDataRepository.getLoading();

    }

    public LiveData<SpecData> getSpecData() {
        return specData;
    }

    public LiveData<Boolean> getLoading() {
        return isLoading;
    }

}
