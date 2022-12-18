package com.zero.informasigempa.ui.current;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zero.informasigempa.network.ApiConfig;
import com.zero.informasigempa.response.current.CurrentEarthquakeResponse;
import com.zero.informasigempa.response.current.Gempa;

import retrofit2.Call;

public class CurrentEarthquakeViewModel extends ViewModel {
    private MutableLiveData<Gempa> gempaMutableLiveData = new MutableLiveData<>();

    public LiveData<Gempa> getGempaMutableLiveData() {
        return gempaMutableLiveData;
    }

    void findCurrentEarthquake() {
        Call<CurrentEarthquakeResponse> client = ApiConfig.retrofit.getCurrentEarthquake();
        client.enqueue(new retrofit2.Callback<CurrentEarthquakeResponse>() {
            @Override
            public void onResponse(Call<CurrentEarthquakeResponse> call, retrofit2.Response<CurrentEarthquakeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    gempaMutableLiveData.postValue(response.body().infogempa.getGempa());
                    Log.e("Gempa", response.body().infogempa.toString());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Current", "onFailure: ${t.message}");
            }
        });
    }
}
