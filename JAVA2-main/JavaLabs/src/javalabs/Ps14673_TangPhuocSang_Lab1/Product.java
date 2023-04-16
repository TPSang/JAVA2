/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Lab1;

/**
 *
 * @author Admin
 */
public class Product implements DAO {
    String name;
    double price;
    public double getImportTax(){
        return 0.1*this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public void insert() {
      System.out.println("insert thành công!");
    }

    @Override
    public void update() {
       System.out.println("update thành công!");
    }

    @Override
    public void delete() {
       System.out.println("delete thành công!");
    }

    @Override
    public void select() {
       System.out.println("select thành công!");
    }
    
    
    
    
}
