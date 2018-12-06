package com.example.thanhkhoa.savemoney;

public class CharItem {
    public Float getTongtien() {
        return tongtien;
    }

    public void setTongtien(Float tongtien) {
        this.tongtien = tongtien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public CharItem(Float tongtien, String ten) {

        this.tongtien = tongtien;
        this.ten = ten;
    }

    Float tongtien;
    String ten;
}
