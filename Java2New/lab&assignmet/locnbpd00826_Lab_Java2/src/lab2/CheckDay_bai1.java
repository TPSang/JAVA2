/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

public class CheckDay_bai1 {
    public static void main(String[] args) {
        int day;
        // tạo hàm nhập
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ 0 đến 6 : ");
        day = sc.nextInt();
        //điều kiện xuất
        if(day == Weekday_bai1.Sunday || day == Weekday_bai1.Saturday){
            System.out.println("Ngày cuối tuần !");
        }else{
            System.out.println("Ngày trong tuần");
        }
    }
    
}
