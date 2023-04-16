/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS14885_NguyenDoDuyAn_Lab6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main_ex3 {
    public static void main(String[] args) {
        OddThread th1 = new OddThread();
        EvenThread th2 = new EvenThread();
        
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException ex) {
           
        }
        
        th2.start();
        System.out.println("Complete");
    }
 
}
