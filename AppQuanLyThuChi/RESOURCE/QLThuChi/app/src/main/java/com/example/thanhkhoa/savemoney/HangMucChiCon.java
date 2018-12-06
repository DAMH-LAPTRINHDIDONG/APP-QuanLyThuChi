package com.example.thanhkhoa.savemoney;

import java.io.Serializable;

public class HangMucChiCon implements Serializable{
    int ID;
    String TenMucChiCon;
    String IconCon;


    public HangMucChiCon(String tenMucChiCon) {
        TenMucChiCon = tenMucChiCon;
    }

    public HangMucChiCon(int ID, String tenMucChiCon, String iconCon, int IDMucChiCha) {
        this.ID = ID;

        TenMucChiCon = tenMucChiCon;
        IconCon = iconCon;
        this.IDMucChiCha = IDMucChiCha;
    }

    public String getIconCon() {

        return IconCon;
    }

    public void setIconCon(String iconCon) {
        IconCon = iconCon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenMucChiCon() {
        return TenMucChiCon;
    }

    public void setTenMucChiCon(String tenMucChiCon) {
        TenMucChiCon = tenMucChiCon;
    }

    public int getIDMucChiCha() {
        return IDMucChiCha;
    }

    public void setIDMucChiCha(int IDMucChiCha) {
        this.IDMucChiCha = IDMucChiCha;
    }

    public HangMucChiCon(int ID, String tenMucChiCon, int IDMucChiCha) {

        this.ID = ID;
        TenMucChiCon = tenMucChiCon;
        this.IDMucChiCha = IDMucChiCha;
    }

    int IDMucChiCha;
}
