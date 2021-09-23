import java.util.*;

public class Main{
    
    public static void main(String[]args){
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(5);
        q.add(9);
        
        System.out.println(q+" -> "+q.size());
        
        q.add(10);
        System.out.println(q+" -> "+q.size());
        
        int val = q.remove();
        System.out.println(val);
        
        System.out.println(q+" -> "+q.size());
        
        val = q.peek();
        System.out.println(val);
        
        System.out.println(q+" -> "+q.size());
        
    }
    
}




