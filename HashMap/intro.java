import java.util.*;

public class Main{
    
    public static void main(String[]args){
        
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("IND", 150);
        map.put("US", 50);
        map.put("UK", 10);
        map.put("BAN", 15);
        
        System.out.println(map);
        
        map.put("CA", 30);
        
        System.out.println(map);
        
        Integer value =  map.get("IND");
        System.out.println(value);
        
        map.put("IND", 200);
        System.out.println(map);
        
        value =  map.get("ID");
        System.out.println(value);
        
        Set<String>keys = map.keySet();
        
        for(String key : keys){
            System.out.println(key+" -> "+map.get(key));
        }
    }
    
}