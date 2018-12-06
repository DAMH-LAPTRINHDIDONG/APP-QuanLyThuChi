package com.example.thanhkhoa.savemoney;

import java.io.Serializable;

public class TienTe implements Serializable {
    int id;
    String kyhieu;

    public TienTe(String kyhieu, String ten, String hinh) {
        this.kyhieu = kyhieu;
        this.ten = ten;
        this.hinh = hinh;
    }

    String ten;
    String hinh;
    String tigia;

    public TienTe(int id, String kyhieu, String ten, String hinh, String tigia) {
        this.id = id;
        this.kyhieu = kyhieu;
        this.ten = ten;
        this.hinh = hinh;
        this.tigia = tigia;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTigia() {
        return tigia;
    }

    public void setTigia(String tigia) {
        this.tigia = tigia;
    }
}

