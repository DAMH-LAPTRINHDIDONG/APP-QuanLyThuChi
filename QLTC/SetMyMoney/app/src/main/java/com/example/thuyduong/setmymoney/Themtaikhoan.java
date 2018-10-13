package com.example.thuyduong.setmymoney;

import java.util.ArrayList;

public class Themtaikhoan {
    int id;
    String name;

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    int id2;

    public Themtaikhoan(int id, String name, int id2) {
        this.id = id;
        this.name = name;
        this.id2 = id2;
    }

    public Themtaikhoan(int id, String name)
    {
        this.id=id;

        this.name=name;
    }

    public Themtaikhoan(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList initThemtaikhoan()
    {
       ArrayList<Themtaikhoan> arrayList = new ArrayList<>();
        arrayList.add(new Themtaikhoan(R.drawable.simpline,"Tên Tài Khoản"));
        arrayList.add(new Themtaikhoan(R.drawable.purse,"Tiền mặt",R.drawable.arrowsicon));
        arrayList.add(new Themtaikhoan(R.drawable.payment,"VND",R.drawable.arrowsicon));
        arrayList.add(new Themtaikhoan(R.drawable.notesicon,"Diễn giải"));
        return arrayList;
    }
}

