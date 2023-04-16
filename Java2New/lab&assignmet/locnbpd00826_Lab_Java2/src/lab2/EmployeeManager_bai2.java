/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;


public class EmployeeManager_bai2 {
    public static void main(String[] args) {
       NhanVien_bai2 e1 = new NhanVien_bai2(""){
           @Override
           public double getSalary() {
               return 70000;
           }
           
       };
       e1.print();
       NhanVien_bai2 e2 = new NhanVien_bai2("") {
           @Override
           public double getSalary() {
               return 200000;
           }
       };
       e2.print();
    }
   
    
}
