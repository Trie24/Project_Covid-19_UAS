package com.tripurwanto.covid19app.api.newsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsDataHolder {

    @GET("v2/top-headlines?country=id&q=covid-19")
    Call<NewsData> getNews(@Query("apiKey") String apiKey);

    @GET("v2/top-headlines?q=covid-19&sortBy=popularity")
    Call<NewsData> getNewsEn(@Query("apiKey") String apiKey);

}
