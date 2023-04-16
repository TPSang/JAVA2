package javalabs.Ps14673_TangPhuocSang_Lab8;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Lab8Bai1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(5);
        list.add(6.7);
        list.add(true);
        list.add("Hello world");
        int a = (Integer)list.get(0);
        Double b = (Double)list.get(1);
        Boolean c = (Boolean)list.get(2);
        String d = (String)list.get(3);
        System.out.println("Số nguyên: "+a);
        System.out.println("Số thực: "+b);
        System.out.println("Boolean: "+c);
        System.out.println("Chuỗi kí tự: "+d);
    }
}
