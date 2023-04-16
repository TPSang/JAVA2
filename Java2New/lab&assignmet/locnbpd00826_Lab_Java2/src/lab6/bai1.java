/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;


public class bai1 extends Thread{
    public void run(){
        System.out.println("running thread neme is:"+ Thread.currentThread().getName());
        System.out.println("running thread neme is:"+ Thread.currentThread().getPriority());
    }
    public static void main(String[] args) {
        bai1 m1 = new bai1();
        bai1 m2 = new bai1();
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();
    }
}
