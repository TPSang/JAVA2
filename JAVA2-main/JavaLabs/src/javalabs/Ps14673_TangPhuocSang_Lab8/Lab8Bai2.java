/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Lab8;

import java.util.ArrayList;

/**
 *
 * @author duyan
 */
public class Lab8Bai2 {

    public static void main(String[] args) {
        ArrayList<Integer> myarrr = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            myarrr.add(i);
        }
        System.out.println("Các số từ 0 - 10 từ mảng myarrr");
        for (int i = 0; i < 10; i++) {
            System.out.println("" + myarrr.get(i));
        }
    }
}
