package lab8;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class bai1 {
    public static void main(String[] args) {
        ArrayList mylist = new ArrayList();
        mylist.add(10);
        mylist.add("Toai");
        mylist.add(true);
        mylist.add(69.69);
        int a = (Integer)mylist.get(0);
        String str = (String)mylist.get(1);
        Boolean bl = (Boolean)mylist.get(2);
        Double db = (Double)mylist.get(3);
        
        System.out.println(a);
        System.out.println(str);
        System.out.println(bl);
        System.out.println(db);
    }
}
