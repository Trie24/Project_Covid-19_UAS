/*
 * Made With Love
 * Author @Moh Husni Mubaraq
 * Not for Commercial Purpose
 */

package com.tripurwanto.covid19app.api;

import java.util.concurrent.TimeUnit;

import com .tripurwanto.covid19app.utilities.AppUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceApi {
    private static final GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build();
    public static Retrofit getRetrofitService(){
        return new Retrofit.Builder()
                .baseUrl(AppUtils.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }

}
