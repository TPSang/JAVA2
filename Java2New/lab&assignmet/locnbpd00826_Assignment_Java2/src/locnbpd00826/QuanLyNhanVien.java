package locnbpd00826;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import locnbpd00826.NhanVien;

/**
 *
 * @author Ast
 */
public class QuanLyNhanVien {
   public int Vitrihienhanh;    
     public ArrayList <QUANLYSACH> danhsach;
    public QuanLyNhanVien(){
        danhsach= new ArrayList<>();
        
    }

    public QuanLyNhanVien(int Vitrihienhanh) {
        this.Vitrihienhanh = Vitrihienhanh;
    }

    public int getVitrihienhanh() {
        return Vitrihienhanh;
    }

    public void setVitrihienhanh(int Vitrihienhanh) {
        this.Vitrihienhanh = Vitrihienhanh;
    }

    public ArrayList<QUANLYSACH> getDanhsach() {
        return danhsach;
    }

    public void setDanhsach(ArrayList<QUANLYSACH> danhsach) {
        this.danhsach = danhsach;
    }
    
  public  QUANLYSACH next(){
        if (Vitrihienhanh<danhsach.size()-1)
            Vitrihienhanh++;
        else
            Vitrihienhanh=0;
        return (QUANLYSACH) danhsach.get(Vitrihienhanh);
    }
     
    public QUANLYSACH previous(){
         
        if(Vitrihienhanh < 1)
            Vitrihienhanh = 0;
        else
            Vitrihienhanh--;
        return (QUANLYSACH)danhsach.get(Vitrihienhanh);

     }
    public  QUANLYSACH first(){
        Vitrihienhanh=0;
        return (QUANLYSACH) danhsach.get(0);
    }
    public QUANLYSACH last(){
        Vitrihienhanh=danhsach.size()-1;
        return(QUANLYSACH) danhsach.get(danhsach.size()-1);
    }
    
    
    public  void themMoi(QUANLYSACH obj){
        danhsach.add(obj);
    }
//    public int timKiemById(String id){//tra ve vi tri tim thay nhan vien
//        for(int i=0; i<danhsach.size();i++){
//            if(id.equals(danhsach.get(i).getMaNV()))
//                return i;
//        }
//        return -1;
//    }
//    public void xoaById(String id){
//        int vitri=timKiemById(id);
//        if(vitri==-1){
//            JOptionPane.showMessageDialog(null, "không tìm thấy nhân viên cần xóa");
//            
//        }else{
//            danhsach.remove(vitri);
//            JOptionPane.showMessageDialog(null, "Xóa thành công");
//        }
//    }
    public synchronized void ghiFile(File tenFile){
        try{
            FileWriter fw= new FileWriter(tenFile, true);
            for(int i=0;i<danhsach.size();i++){
                fw.write(danhsach.get(i).toString());
                            
            }
            fw.close();
            JOptionPane.showMessageDialog(null, "Lưu thành công");
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "File không tồn tại");
        }
    }
    public synchronized void docFile(File tenFile){
        try {
            
            FileReader fr= new FileReader(tenFile);
            BufferedReader buff= new BufferedReader(fr);
            String line;
            while((line=buff.readLine())!=null){
                QUANLYSACH obj= new QUANLYSACH();
                String []n = line.split(";");
                obj.setMaSach(n[0]);
                obj.setTenSach(n[1]);
                obj.setDongia(Integer.parseInt(n[3]));
                obj.setLoaiSach(n[2]);
                //obj.setLuong(Double.parseDouble(n[4]));
                themMoi(obj);
            }fr.close();
            buff.close();
        } catch (Exception e) {
        }
    }
     
}

