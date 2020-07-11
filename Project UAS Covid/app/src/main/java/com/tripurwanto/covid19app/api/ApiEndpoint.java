package com.tripurwanto.covid19app.api;

import java.util.List;

import com.tripurwanto.covid19app.HistoryModel;
import com.tripurwanto.covid19app.WorldSummaryModel;
import com.tripurwanto.covid19app.utilities.AppUtils;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpoint {
    //Endpoint riwayat
    @GET(AppUtils.END_POINT_WORLD_HISTORY)
    Call<List<HistoryModel>> getHistoryList(@Path("date") String date);

    //Endpointt Ringkasan Dunia
    @GET(AppUtils.END_POINT_SUMMARY_WORLD)
    Call<WorldSummaryModel> getSummaryWorld();

}
