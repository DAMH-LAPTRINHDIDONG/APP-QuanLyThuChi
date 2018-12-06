package com.example.thanhkhoa.savemoney;

import java.io.Serializable;

public class TaiKhoanItem implements Serializable{
    int ID,idtiente,idloaitk;
    String tentk;
    int sodubd;
    int soduht;

    public TaiKhoanItem(int ID, int idtiente, int idloaitk, String tentk, int sodubd, int soduht, int img) {
        this.ID = ID;
        this.idtiente = idtiente;
        this.idloaitk = idloaitk;
        this.tentk = tentk;
        this.sodubd = sodubd;
        this.soduht = soduht;
        this.img = img;
    }

    public int getImg() {

        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    int img;

    public TaiKhoanItem(int ID, int idtiente, int idloaitk, String tentk, int sodubd, int soduht) {
        this.ID = ID;
        this.idtiente = idtiente;
        this.idloaitk = idloaitk;
        this.tentk = tentk;
        this.sodubd = sodubd;
        this.soduht = soduht;
    }

    public TaiKhoanItem(String tentk, int sodubd, int soduht) {
        this.tentk = tentk;
        this.sodubd = sodubd;
        this.soduht = soduht;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdtiente() {
        return idtiente;
    }

    public void setIdtiente(int idtiente) {
        this.idtiente = idtiente;
    }

    public int getIdloaitk() {
        return idloaitk;
    }

    public void setIdloaitk(int idloaitk) {
        this.idloaitk = idloaitk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public int getSodubd() {
        return sodubd;
    }

    public void setSodubd(int sodubd) {
        this.sodubd = sodubd;
    }

    public int getSoduht() {
        return soduht;
    }

    public void setSoduht(int soduht) {
        this.soduht = soduht;
    }
}
