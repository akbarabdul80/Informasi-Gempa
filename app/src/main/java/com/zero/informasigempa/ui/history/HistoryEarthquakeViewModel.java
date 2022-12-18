package com.zero.informasigempa.ui.history;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zero.informasigempa.network.ApiConfig;
import com.zero.informasigempa.response.history.GempaItem;
import com.zero.informasigempa.response.history.HistoryEarthquakeResponse;

import java.util.List;

import retrofit2.Call;

public class HistoryEarthquakeViewModel extends ViewModel {
    private MutableLiveData<List<GempaItem>> gempaMutableLiveData = new MutableLiveData<>();

    public LiveData<List<GempaItem>> observeHistoryGempa() {
        return gempaMutableLiveData;
    }

    void findGempaInfo() {
        Call<HistoryEarthquakeResponse> client = ApiConfig.retrofit.getHistoryEarthquake();
        client.enqueue(new retrofit2.Callback<HistoryEarthquakeResponse>() {
            @Override
            public void onResponse(Call<HistoryEarthquakeResponse> call, retrofit2.Response<HistoryEarthquakeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    gempaMutableLiveData.postValue(response.body().getGempa().getGempaItems());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("History", "onFailure: ${t.message}");
            }
        });
    }
}
