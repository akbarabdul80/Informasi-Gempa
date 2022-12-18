package com.zero.informasigempa.network;

import com.zero.informasigempa.response.current.CurrentEarthquakeResponse;
import com.zero.informasigempa.response.history.HistoryEarthquakeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("gempadirasakan.json")
    Call<HistoryEarthquakeResponse> getHistoryEarthquake();

    @GET("autogempa.json")
    Call<CurrentEarthquakeResponse> getCurrentEarthquake();
}
