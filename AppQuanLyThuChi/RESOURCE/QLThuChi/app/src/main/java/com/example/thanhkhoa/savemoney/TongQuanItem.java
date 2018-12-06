package com.example.thanhkhoa.savemoney;

public class TongQuanItem {
    int id;
    int tien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getTenhm() {
        return tenhm;
    }

    public void setTenhm(String tenhm) {
        this.tenhm = tenhm;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public TongQuanItem(int id, int tien, String tentk, String tenhm, String ngay, String hinh) {

        this.id = id;
        this.tien = tien;
        this.tentk = tentk;
        this.tenhm = tenhm;
        this.ngay = ngay;
        this.hinh = hinh;
    }

    String tentk,tenhm,ngay,hinh;
}
