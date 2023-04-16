/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS14885_NguyenDoDuyAn_Lab6;

/**
 *
 * @author Admin
 */
public class OddThread extends Thread {
    public void run(){
        for (int i = 1; i < 20; i+=2) {
            System.out.print(" " + i);
            
            try{
                Thread.sleep(10);
            }catch(InterruptedException ex){}
            
        }
        System.out.println();
    }
    
}
