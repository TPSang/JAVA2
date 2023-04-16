/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;


public abstract class NhanVien_bai2 {
    
        private String fullname;
        public NhanVien_bai2(String fullname){
            this.fullname = fullname;
        }
        public abstract double getSalary();
        public void print(){
            System.out.println("Fullname: Dao Ba Loc"+this.fullname);
            System.out.println("Salary: "+this.getSalary());
        }
    
    
}
