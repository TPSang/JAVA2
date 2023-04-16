/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;


public class Vuong_bai3 extends ChuNhat_bai3{
    private double canh;

    public Vuong_bai3() {
    }

    public Vuong_bai3(double dai, double rong) {
        super(dai, rong);
    }

    public double getCanh() {
        return canh;
    }

    public void setCanh(double canh) {
        this.canh = canh;
    }
    public double getChuVi(){
        return (canh*4);
    }
    public double getDienTich(){
        return (canh*canh);
    }
    //xuat
    public void Xuat(){
        System.out.println("Hinh Vuong");
        System.out.println("Canh = "+canh+"Chu vi = "+getChuVi()+"Dien tich = "+getDienTich());
    }
    
}
