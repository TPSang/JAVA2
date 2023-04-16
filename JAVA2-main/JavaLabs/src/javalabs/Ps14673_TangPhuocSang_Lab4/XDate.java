/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Ps14673_TangPhuocSang_Lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class XDate {
    public static Date parse(String text) throws ParseException{
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        return sd.parse(text);
    }
    public static Date parse(String text,String pattern) throws ParseException{
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        return sd.parse(text);
    }
    
}
