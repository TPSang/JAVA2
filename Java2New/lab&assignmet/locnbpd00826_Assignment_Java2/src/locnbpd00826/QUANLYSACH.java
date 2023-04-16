/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locnbpd00826;

/**
 *
 * @author SAMPC
 */
public class QUANLYSACH {
    public String maSach;
    public String tenSach;
    public String loaiSach;
    public int dongia;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public QUANLYSACH(String maSach, String tenSach, String loaiSach, int dongia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.dongia = dongia;
    }

    public QUANLYSACH() {
    }

 
    @Override
    public String toString() {
        return maSach +";" + tenSach +";" + loaiSach +";" + dongia + "\n";
    }
    
}
