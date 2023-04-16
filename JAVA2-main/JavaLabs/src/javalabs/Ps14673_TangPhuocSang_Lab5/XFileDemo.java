/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Ps14673_TangPhuocSang_Lab5;

/**
 *
 * @author Admin
 */
public class XFileDemo {
    public static void main(String[] args) {
byte[] data = XFile.read("D:\\JAVA2-main\\JavaLabs\\src\\javalabs\\Ps14673_TangPhuocSang_Lab5\\staffs.dat");
XFile.write("D:\\JAVA2-main\\JavaLabs\\src\\javalabs\\Ps14673_TangPhuocSang_Lab5\\staffs.dat", data);
        System.out.println(data);
}
}
