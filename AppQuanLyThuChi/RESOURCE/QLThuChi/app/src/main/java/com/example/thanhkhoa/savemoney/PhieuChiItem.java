package com.example.thanhkhoa.savemoney;

public class PhieuChiItem {
    String id;
    int tien;
    String ngay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getTenmuccon() {
        return tenmuccon;
    }

    public void setTenmuccon(String tenmuccon) {
        this.tenmuccon = tenmuccon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PhieuChiItem(String id, int tien, String ngay, String tentk, String tenmuccon, String image) {

        this.id = id;
        this.tien = tien;
        this.ngay = ngay;
        this.tentk = tentk;
        this.tenmuccon = tenmuccon;
        this.image = image;
    }

    String tentk;
    String tenmuccon;
    String image;
}
