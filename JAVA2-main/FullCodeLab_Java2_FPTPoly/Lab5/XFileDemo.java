/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS14885_NguyenDoDuyAn_Lab5;

/**
 *
 * @author Admin
 */
public class XFileDemo {
    public static void main(String[] args) {
byte[] data = XFile.read("D:\\java\\temp/a.gif");
XFile.write("D:\\java\\temp/b.gif", data);
}
}
