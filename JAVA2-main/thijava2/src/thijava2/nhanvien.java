/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thijava2;

/**
 *
 * @author SAMPC
 */
public class nhanvien {
    public String hoten;
    public int tuoi;
    public String gioitinh;
    public String trinhdo;

    public nhanvien() {
    }

    public nhanvien(String hoten, int tuoi, String gioitinh, String trinhdo) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.trinhdo = trinhdo;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
    
}
