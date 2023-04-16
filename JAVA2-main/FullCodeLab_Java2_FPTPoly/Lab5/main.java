/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS14885_NguyenDoDuyAn_Lab5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
       List<Student> list = new ArrayList<>();
list.add(new Student("Tuấn", 5, "CNTT"));
list.add(new Student("Cường", 7.5, "TKTW"));
list.add(new Student("Hạnh", 8.5, "CNTT"));
XFile.writeObject("D:\\java\\temp/students.dat", list);
List<Student> list2 = (List<Student>) XFile.readObject("D:\\java\\temp/students.dat");

for(Student sv : list){
System.out.println(">Họ và tên: " + sv.name);
}  
    }

}
