/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Ps14673_TangPhuocSang_Lab5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Admin
 */
public class XFile {

public static byte[] read(String path) {
   try {
       byte[] data;
       try (FileInputStream fis = new FileInputStream(path)) {
           int n = fis.available();
           data = new byte[n];
           fis.read(data);
       }
return data;
}
catch (Exception e) {
throw new RuntimeException(e);
}

}
public static void write(String path, byte[] data) {
try {
    try (FileOutputStream fos = new FileOutputStream(path)) {
        fos.write(data);
    }
}
catch (Exception e) {
throw new RuntimeException(e);
}
}
public static Object readObject(String path) {
try {
ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
Object object = ois.readObject();
ois.close();
return object;
}
catch (Exception e) {
throw new RuntimeException(e);
}
}
public static void writeObject(String path, Object object) {
try {
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

oos.writeObject(object);
oos.close();
}
catch (Exception e) {
throw new RuntimeException(e);
}
}
}
