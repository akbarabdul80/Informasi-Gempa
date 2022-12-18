package com.zero.informasigempa.response.current;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class Gempa implements Serializable {

    @SerializedName("Wilayah")
    @Nullable
    private String wilayah;

    @SerializedName("Kedalaman")
    @Nullable
    private String kedalaman;

    @SerializedName("Jam")
    @Nullable
    private String jam;

    @SerializedName("Coordinates")
    @Nullable
    private String coordinates;

    @SerializedName("Potensi")
    @Nullable
    private String potensi;

    @SerializedName("Tanggal")
    @Nullable
    private String tanggal;

    @SerializedName("Bujur")
    @Nullable
    private String bujur;

    @SerializedName("Magnitude")
    @Nullable
    private String magnitude;

    @SerializedName("Lintang")
    @Nullable
    private String lintang;

    @SerializedName("DateTime")
    @Nullable
    private String dateTime;

    @SerializedName("Dirasakan")
    @Nullable
    private String dirasakan;


    @SerializedName("Shakemap")
    @Nullable
    private String shakemap;

    public Gempa(@Nullable String wilayah, @Nullable String kedalaman, @Nullable String jam, @Nullable String coordinates, @Nullable String potensi, @Nullable String tanggal, @Nullable String bujur, @Nullable String magnitude, @Nullable String lintang, @Nullable String dateTime, @Nullable String dirasakan, @Nullable String shakemap) {
        this.wilayah = wilayah;
        this.kedalaman = kedalaman;
        this.jam = jam;
        this.coordinates = coordinates;
        this.potensi = potensi;
        this.tanggal = tanggal;
        this.bujur = bujur;
        this.magnitude = magnitude;
        this.lintang = lintang;
        this.dateTime = dateTime;
        this.dirasakan = dirasakan;
        this.shakemap = shakemap;
    }

    @Nullable
    public String getShakemap() {
        return shakemap;
    }

    public void setShakemap(@Nullable String shakemap) {
        this.shakemap = shakemap;
    }

    @Nullable
    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(@Nullable String wilayah) {
        this.wilayah = wilayah;
    }

    @Nullable
    public String getKedalaman() {
        return kedalaman;
    }

    public void setKedalaman(@Nullable String kedalaman) {
        this.kedalaman = kedalaman;
    }

    @Nullable
    public String getJam() {
        return jam;
    }

    public void setJam(@Nullable String jam) {
        this.jam = jam;
    }

    @Nullable
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(@Nullable String coordinates) {
        this.coordinates = coordinates;
    }

    @Nullable
    public String getPotensi() {
        return potensi;
    }

    public void setPotensi(@Nullable String potensi) {
        this.potensi = potensi;
    }

    @Nullable
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(@Nullable String tanggal) {
        this.tanggal = tanggal;
    }

    @Nullable
    public String getBujur() {
        return bujur;
    }

    public void setBujur(@Nullable String bujur) {
        this.bujur = bujur;
    }

    @Nullable
    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(@Nullable String magnitude) {
        this.magnitude = magnitude;
    }

    @Nullable
    public String getLintang() {
        return lintang;
    }

    public void setLintang(@Nullable String lintang) {
        this.lintang = lintang;
    }

    @Nullable
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(@Nullable String dateTime) {
        this.dateTime = dateTime;
    }

    @Nullable
    public String getDirasakan() {
        return dirasakan;
    }

    public void setDirasakan(@Nullable String dirasakan) {
        this.dirasakan = dirasakan;
    }
}
