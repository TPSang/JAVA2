/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Lab1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TaikhoanNganhang {
    String maTaikhoan, hoten;
    int sodutaikhoan;

    public TaikhoanNganhang() {
    }

    public TaikhoanNganhang(String maTaikhoan, String hoten, int sodutaikhoan) {
        this.maTaikhoan = maTaikhoan;
        this.hoten = hoten;
        this.sodutaikhoan = sodutaikhoan;
    }

    

    

    public String getMaTaikhoan() {
        return maTaikhoan;
    }

    public void setMaTaikhoan(String maTaikhoan) {
        this.maTaikhoan = maTaikhoan;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSodutaikhoan() {
        return sodutaikhoan;
    }

    public void setSodutaikhoan(int sodutaikhoan) {
        this.sodutaikhoan = sodutaikhoan;
    }
    
    public void nhapTaikhoan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma tai khoan: ");
        maTaikhoan = sc.nextLine();
        
        System.out.println("Nhap ho va ten: ");
        hoten = sc.nextLine();
        
        
        System.out.println("Nhap so du tai khoan: ");
        sodutaikhoan = sc.nextInt();
    }
    public void xuatTaikhoan() {
        System.out.printf("\nMa tai khoan: %s\n", maTaikhoan);
        System.out.printf("Ho va Ten: %s\n", hoten);
        System.out.printf("So du tai khoan: %d\n", sodutaikhoan);
    }
    public void rutTien(){
         Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tien can rut: ");
        int rut = sc.nextInt();
       
        
        if(sodutaikhoan >= rut){
            int kq;
            kq = sodutaikhoan - rut;
            
            System.out.println("\nGiao dich thanh cong");
            System.out.printf("So du con lai la: %d\n",kq);
            System.out.println("");
            setSodutaikhoan(kq);
        } else{
            System.out.println("\nGiao dich that bai do so du khong du\n");
        }
    }
    public void guiTien(){
         Scanner sc = new Scanner(System.in);
       System.out.println("Nhap so tien can gui: ");
       int gui = sc.nextInt();
       int kq = sodutaikhoan + gui;
        System.out.println("\nGiao dich thanh cong");
        System.out.printf("So du la: %d\n",kq);
        System.out.println("");
        setSodutaikhoan(kq);
       
}
    
}
