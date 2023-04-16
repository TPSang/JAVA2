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
public class bai3_Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
       
       for(int i = 0; i < 3; i++){ 
           Product sp1;
           if(i !=0 ){ 
               sp1 = new Product();
           } else {
               sp1 = new noTaxProduct();
           }
        
        System.out.println("Name: ");
        String tensp = sc.nextLine();
        sp1.setName(tensp);
        
        System.out.println("Price: ");
        double gia = sc.nextDouble();
        sc.nextLine();
        sp1.setPrice(gia);
        
        System.out.printf("Name: %s - Price: %.1f - Tax: %.1f \n", sp1.getName(), sp1.getPrice(), sp1.getImportTax() );
       }
       
    }
}
