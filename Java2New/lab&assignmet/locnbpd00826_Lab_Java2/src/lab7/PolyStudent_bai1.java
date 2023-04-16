/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;


public class PolyStudent_bai1 {
    public String fullname;     public Career_bai1 career; 
 
    public void print() {         
        System.out.println(">Fullname: " + this.fullname);
    switch (this.career) {             
    case UDPM:                 
        System.out.println(">Career: Ứng dụng phần mềm");
 break;             
    case TKTW:                 
    System.out.println(">Career: Thiết kế trang web");                 
    break;             
    case LTDĐ: 
      System.out.println(">Career: Lập trình di động");                 
      break;             
      case TKĐH:                 
      System.out.println(">Career: Thiết kế đồ họa");                 
      break;         
    }   
}
     public static void main(String[] args) {         
         PolyStudent_bai1 sv = new PolyStudent_bai1();
         sv.fullname = "Đào Bá Lộc";         
        //sv.career = Career.UDPM;         
        sv.career = Career_bai1.valueOf("UDPM");                  
        sv.print();     
} 
 
}
