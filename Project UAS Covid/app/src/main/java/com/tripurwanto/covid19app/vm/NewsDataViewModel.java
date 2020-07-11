package com.tripurwanto.covid19app.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tripurwanto.covid19app.api.newsData.NewsData;
import com.tripurwanto.covid19app.repo.NewsDataRepository;

public class NewsDataViewModel extends ViewModel {
    private MutableLiveData<NewsData> newsData;
    private MutableLiveData<Boolean> isLoading;
    private NewsDataRepository newsDataRepository;

    public void init() {
        if (newsData != null){
            return;
        }
        newsDataRepository = NewsDataRepository.getInstance();
        isLoading = newsDataRepository.getLoading();

    }

    public LiveData<NewsData> getNewsData() {
        return newsDataRepository.getNewsData();
    }

    public LiveData<NewsData> getNewsDataEn() {
        return newsDataRepository.getNewsDataEn();
    }

    public LiveData<Boolean> getLoading() {
        return isLoading;
    }

}
