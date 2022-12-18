package com.zero.informasigempa.response.current;

import com.google.gson.annotations.SerializedName;

public class InfoCurrentGempa {
    @SerializedName("gempa")
    private Gempa gempa;

    public InfoCurrentGempa(Gempa gempa) {
        this.gempa = gempa;
    }

    public Gempa getGempa() {
        return gempa;
    }

    public void setGempa(Gempa gempa) {
        this.gempa = gempa;
    }
}
