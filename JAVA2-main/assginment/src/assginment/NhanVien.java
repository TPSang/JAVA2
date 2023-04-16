/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assginment;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class NhanVien implements Serializable{

    String maNhanVien;
    String hoVaTen;
    int tuoi;
    String gmail;
    int luong;
    String pb;

    public NhanVien() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getGmail() {
        return gmail;
    }

    public int getLuong() {
        return luong;
    }

    public String getPb() {
        return pb;
    }

    public NhanVien(String maNhanVien, String hoVaTen, int tuoi, String gmail, int luong, String pb) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.gmail = gmail;
        this.luong = luong;
        this.pb = pb;
       
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }
 
}
