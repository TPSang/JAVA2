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
public class main_NganHang {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         TaikhoanNganhang tk1 = new TaikhoanNganhang();
         while(true){
       int chon;
   
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                  Ho va Ten: Tăng Phước Sang              |");
            System.out.println("|                       MSSV: PS14885                        |");
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                        Menu Ngan Hang                      |");
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                    0.Thoat ung dung                        |");
            System.out.println("|                    1. Nhap thong tin tai khoan             |");
            System.out.println("|                    2. rut tien                             |");
            System.out.println("|                    3. Gui Tien                             |");
            System.out.println("*------------------------------------------------------------*");
            System.out.println("Moi ban chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            if (chon == 0 ) {
                System.exit(0);
            }
            switch(chon){
            case 1:
                System.out.println("Chuc nang 1:  Nhap thong tin tai khoan  ");
                tk1.nhapTaikhoan(); 
                tk1.xuatTaikhoan();
                break;
            case 2:
                System.out.println("Chuc nang 2: rut tien  ");
               tk1.rutTien();
               tk1.xuatTaikhoan();
                break;
            case 3:
                System.out.println("Chuc nang 3: Gui Tien ");
                tk1.guiTien();
                tk1.xuatTaikhoan();
                break;
             
    }
             System.out.println("Nhan Enter de tiep tuc");
            sc.nextLine();
}
         
    }
    
}
