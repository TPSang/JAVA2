/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

public class bai3 extends Thread{

    @Override
    public void run() {
        for(int i=1; i<= 10; i++){
            if(i% 2 !=0){
                try{
                    Thread.sleep(500);
                }catch(Exception e){
                    System.out.println(e);
                }
                System.out.println("i");
            }
        }
    }  
}
