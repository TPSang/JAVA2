/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;


public abstract class SinhVienPoly {
    public String hoTen;
    public String nganh;

    public SinhVienPoly(String hoTen, String nganh){
        this.hoTen = hoTen;
        this.nganh = nganh;
    }
    
    public abstract double getDiem();
    
    public String getHocLuc(){
        if(getDiem()<5) return"yeu";
        else if(getDiem()<6.5 && getDiem()>=5) return"trung binh";
        else if(getDiem()<8 && getDiem()>=6.5) return"kha";
        else if(getDiem()<9 && getDiem()>=8) return"gioi";
        else return"xuat sac";
    }
    
    public void xuat(){
        System.out.println("Ho ten :"+hoTen+ " Nganh :"+nganh+ " Diem = " +getDiem()+ " Hoc luu :" +getHocLuc());
        //System.out.printf("Ho ten:%s - Nganh:%s-Diem :%f - Hoc Luc =%s",hoTen, nganh, getDiem(), getHocLuc());
    }
    
}
