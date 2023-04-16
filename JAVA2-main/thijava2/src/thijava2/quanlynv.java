/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thijava2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SAMPC
 */
public class quanlynv {
    public int Vitrihienhanh;    
     public ArrayList <nhanvien> danhsach;
    public quanlynv(){
        danhsach= new ArrayList<>();
        
    }

    public quanlynv(int Vitrihienhanh) {
        this.Vitrihienhanh = Vitrihienhanh;
    }

    public int getVitrihienhanh() {
        return Vitrihienhanh;
    }

    public void setVitrihienhanh(int Vitrihienhanh) {
        this.Vitrihienhanh = Vitrihienhanh;
    }

    public ArrayList<nhanvien> getDanhsach() {
        return danhsach;
    }

    public void setDanhsach(ArrayList<nhanvien> danhsach) {
        this.danhsach = danhsach;
    }
    
  public  nhanvien next(){
        if (Vitrihienhanh<danhsach.size()-1)
            Vitrihienhanh++;
        else
            Vitrihienhanh=0;
        return (nhanvien) danhsach.get(Vitrihienhanh);
    }
     
    public nhanvien previous(){
         
        if(Vitrihienhanh < 1)
            Vitrihienhanh = 0;
        else
            Vitrihienhanh--;
        return (nhanvien)danhsach.get(Vitrihienhanh);

     }
    public  nhanvien first(){
        Vitrihienhanh=0;
        return (nhanvien) danhsach.get(0);
    }
    public nhanvien last(){
        Vitrihienhanh=danhsach.size()-1;
        return(nhanvien) danhsach.get(danhsach.size()-1);
    }
    
    
    public  void themMoi(nhanvien obj){
        danhsach.add(obj);
    }

    public synchronized void ghiFile(File tenFile){
        try{
            FileWriter fw= new FileWriter(tenFile, true);
            for(int i=0;i<danhsach.size();i++){
                fw.write(danhsach.get(i).toString());
                            
            }
            fw.close();
            JOptionPane.showMessageDialog(null, "Lưu thành công");
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "File to save !");
        }
    }
    public synchronized void docFile(File tenFile){
        try {
            
            FileReader fr= new FileReader(tenFile);
            BufferedReader buff= new BufferedReader(fr);
            String line;
            while((line=buff.readLine())!=null){
                nhanvien obj= new nhanvien();
                String []n = line.split(";");
                obj.setHoten(n[0]);
                obj.setTrinhdo(n[2]);
                obj.setTuoi(Integer.parseInt(n[1]));
                obj.setGioitinh(n[3]);
                
                
                themMoi(obj);
            }fr.close();
            buff.close();
        } catch (Exception e) {
        }
    }
}
