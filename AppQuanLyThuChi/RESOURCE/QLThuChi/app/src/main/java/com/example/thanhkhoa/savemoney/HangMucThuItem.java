package com.example.thanhkhoa.savemoney;

import java.io.Serializable;

public class HangMucThuItem implements Serializable{
    String ID;
    String Tenmucthu;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenmucthu() {
        return Tenmucthu;
    }

    public void setTenmucthu(String tenmucthu) {
        Tenmucthu = tenmucthu;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public HangMucThuItem(String ID, String tenmucthu, String hinh) {

        this.ID = ID;
        Tenmucthu = tenmucthu;
        this.hinh = hinh;
    }

    String hinh;

}
