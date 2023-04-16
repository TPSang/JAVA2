/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS14885_NguyenDoDuyAn_Lab4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class luongException {
    private double luong;

    public luongException(double luong) {
        this.luong = luong;
    }

    

   void luongException(){
       if(luong < 5000000 || luong > 10000000){
           System.out.println("Luong nằm trong khoảng 5tr đến 10tr");
       }
       else{
           System.out.println("Luong của bạn là: " + luong);
       }
       }
   public void nhap(){
           Scanner sc = new Scanner(System.in);
            System.out.println("Nhập lương: ");
            luong = sc.nextDouble();
       }
}
