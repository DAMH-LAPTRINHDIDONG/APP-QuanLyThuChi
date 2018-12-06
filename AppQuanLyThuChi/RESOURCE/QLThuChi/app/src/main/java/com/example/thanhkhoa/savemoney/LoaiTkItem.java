package com.example.thanhkhoa.savemoney;

import java.io.Serializable;

public class LoaiTkItem implements Serializable{
    int id ;
    String name;
    String img;

    public int getId() {
        return id;
    }

    public LoaiTkItem(String name, String img) {
        this.name = name;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LoaiTkItem(int id, String name, String img) {

        this.id = id;
        this.name = name;
        this.img = img;
    }
}
