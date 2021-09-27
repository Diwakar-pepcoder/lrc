import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int ar[] = new int[n];
    for(int i=0;i<n;i++)ar[i] = scn.nextInt();
    
    HashMap<Integer, Boolean> map = new HashMap<>();
    
    for(int val: ar)map.put(val, true);
    
    Set<Integer> keys = map.keySet();
    
    int startMax=0;
    int maxSize=0;
    
    for(Integer start: keys){
        if(map.containsKey(start-1))continue;
        
        int size=1;
        
        Integer e=start+1;
        
        while(map.containsKey(e)){
            size++;
            e++;
        }
        
        if(size > maxSize || (size == maxSize&&startMax>start)){
            startMax = start;
            maxSize = size;
        }
    }
    
    for(int i=0;i<maxSize;i++){
        System.out.println(startMax+i);
    }
    
 }

}