package com.example.findwork.perusahaan.model;

public class Lowongan {
    private String posisiLowongan;
    private String namaPerusahaan;
    private String alamatLowongan;
    private String minimalPendidikan;
    private String gaji;
    private String tenggatLowongan;

    public Lowongan(String posisiLowongan, String namaPerusahaan, String alamatLowongan, String minimalPendidikan, String gaji, String tenggatLowongan) {
        this.posisiLowongan = posisiLowongan;
        this.namaPerusahaan = namaPerusahaan;
        this.alamatLowongan = alamatLowongan;
        this.minimalPendidikan = minimalPendidikan;
        this.gaji = gaji;
        this.tenggatLowongan = tenggatLowongan;
    }

    public String getPosisiLowongan() {
        return posisiLowongan;
    }

    public void setPosisiLowongan(String posisiLowongan) {
        this.posisiLowongan = posisiLowongan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getAlamatLowongan() {
        return alamatLowongan;
    }

    public void setAlamatLowongan(String alamatLowongan) {
        this.alamatLowongan = alamatLowongan;
    }

    public String getMinimalPendidikan() {
        return minimalPendidikan;
    }

    public void setMinimalPendidikan(String minimalPendidikan) {
        this.minimalPendidikan = minimalPendidikan;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getTenggatLowongan() {
        return tenggatLowongan;
    }

    public void setTenggatLowongan(String tenggatLowongan) {
        this.tenggatLowongan = tenggatLowongan;
    }
}
