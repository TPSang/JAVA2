package lab8;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class bai3_1 implements Serializable{
    public String name;
    public Double price;
    public bai3_1(String name, Double price) {
    this.name = name;
    this.price = price;
    }
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    public Double getPrice() {
    return price;
    }
    public void setPrice(Double price) {
    this.price = price;
}

}
