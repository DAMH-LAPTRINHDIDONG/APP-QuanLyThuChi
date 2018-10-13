package com.example.thuyduong.setmymoney;

import java.util.ArrayList;

public class IconTK {
    int id;
    String name;

    public IconTK(int id, String name)
    {
        this.id=id;
        this.name=name;

    }

    public int getId()
    {
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

    public static ArrayList initIconTK()
    {
        ArrayList<IconTK> arrayList = new ArrayList<>();
        arrayList.add(new IconTK(R.drawable.wallet,"Tiền mặt"));
        arrayList.add(new IconTK(R.drawable.bank,"Tài khoản ngân hàng"));
        arrayList.add(new IconTK(R.drawable.thetindung,"Thẻ tín dụng"));
        arrayList.add(new IconTK(R.drawable.dautu,"Tài khoản đầu tư"));
        arrayList.add(new IconTK(R.drawable.tien,"Khác"));
        return arrayList;
    }
}
