package com.example.thuyduong.setmymoney;


import java.util.ArrayList;

public class Images {
    int img;
    String nameimg;
    public Images(int img, String nameimg){
        this.img=img;
        this.nameimg=nameimg;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNameimg() {
        return nameimg;
    }

    public void setNameimg(String nameimg) {
        this.nameimg = nameimg;
    }
    public static ArrayList<Images> intit(){
        ArrayList<Images> arrayList=new ArrayList<>();
        arrayList.add(new Images(R.drawable.arrowsicon,"Image01"));
        arrayList.add(new Images(R.drawable.box,"Image01"));
        arrayList.add(new Images(R.drawable.purse,"Image01"));
        arrayList.add(new Images(R.drawable.payment,"Image01"));
        arrayList.add(new Images(R.drawable.simpline,"Image01"));
        arrayList.add(new Images(R.drawable.lock,"Image01"));
        arrayList.add(new Images(R.drawable.email,"Image01"));
        arrayList.add(new Images(R.drawable.facebook,"Image01"));
        arrayList.add(new Images(R.drawable.gg,"Image01"));
        arrayList.add(new Images(R.drawable.arrowsicon,"Image01"));
        arrayList.add(new Images(R.drawable.arrowsicon,"Image01"));
        arrayList.add(new Images(R.drawable.arrowsicon,"Image01"));

        return arrayList;
    }


}
