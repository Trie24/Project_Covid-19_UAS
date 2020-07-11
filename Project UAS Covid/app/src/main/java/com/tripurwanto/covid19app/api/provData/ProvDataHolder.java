package com.tripurwanto.covid19app.api.provData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProvDataHolder {

    @GET("public/api/prov.json")
    Call<ProvData> getProvData();

}
