package com.example.thanhkhoa.savemoney;

public class HangMucChiCha {
    int ID;
    String TenMucChiCha;
    String IconCha;

    public String getIconCha() {
        return IconCha;
    }

    public void setIconCha(String iconCha) {
        IconCha = iconCha;
    }

    public HangMucChiCha(String tenMucChiCha) {
        TenMucChiCha = tenMucChiCha;
    }

    public HangMucChiCha(int ID, String tenMucChiCha, String iconCha) {

        this.ID = ID;

        TenMucChiCha = tenMucChiCha;
        IconCha = iconCha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenMucChiCha() {
        return TenMucChiCha;
    }

    public void setTenMucChiCha(String tenMucChiCha) {
        TenMucChiCha = tenMucChiCha;
    }

    public HangMucChiCha(int ID, String tenMucChiCha) {

        this.ID = ID;
        TenMucChiCha = tenMucChiCha;
    }
}
