package com.example.thanhkhoa.savemoney;

public class KetNoi {
    public String getChuoikn() {
        return "http://172.20.10.6:8080/androidwebservice/";
    }

    public void setChuoikn(String chuoikn) {
        this.chuoikn = chuoikn;
    }

    public KetNoi() {
    }

    public KetNoi(String chuoikn) {

        this.chuoikn = chuoikn;
    }

    String chuoikn;
}
