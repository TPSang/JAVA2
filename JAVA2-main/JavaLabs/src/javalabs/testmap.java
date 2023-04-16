/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeObject.keys;

/**
 *
 * @author SAMPC
 */
public class testmap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "UDPM");
        map.put(2, "TKDH");
        map.put(3, "WEB");
        map.put(4, "TEST");
        map.put(5,"PTWEB");
        map.put(6, "DataAnylist");
     
        // Duyệt vòng lặp for
        
        
        Set<Integer> keys = map.keySet();
        for (Integer key : keys ){
        String ten = map.get(key);
        int index = key;
            System.out.println(index+" : "+ten);
        }
        
        // Duyệt bằng Entry 
        for(Map.Entry<Integer,String> entry : map.entrySet())
        {
        int index = entry.getKey();
        String nganh = entry.getValue();
            System.out.println(index+" : "+ nganh);
        }

    }
    
}
