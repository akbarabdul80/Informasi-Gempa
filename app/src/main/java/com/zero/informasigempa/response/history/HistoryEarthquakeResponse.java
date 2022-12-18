package com.zero.informasigempa.response.history;

import com.google.gson.annotations.SerializedName;

public class HistoryEarthquakeResponse {
    @SerializedName("Infogempa")
    private InfoHistoryGempa gempa;

    public HistoryEarthquakeResponse(InfoHistoryGempa gempa) {
        this.gempa = gempa;
    }

    public InfoHistoryGempa getGempa() {
        return gempa;
    }
}

