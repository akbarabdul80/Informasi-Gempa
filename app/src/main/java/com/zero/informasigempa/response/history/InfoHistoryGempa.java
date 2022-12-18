package com.zero.informasigempa.response.history;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfoHistoryGempa {

    @SerializedName("gempa")
    private List<GempaItem> gempaItems;

    public InfoHistoryGempa(List<GempaItem> gempaItems) {
        this.gempaItems = gempaItems;
    }

    public List<GempaItem> getGempaItems() {
        return gempaItems;
    }

    public void setGempaItems(List<GempaItem> gempaItems) {
        this.gempaItems = gempaItems;
    }
}
