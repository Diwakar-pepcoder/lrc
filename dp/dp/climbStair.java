import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int count = cs(n, new int[n+1]);
        System.out.println(count);
    }
    
    static int cs(int n, int qb[]){
        if(n==0)return 1;
        if(n<0)return 0;
        
        if(qb[n]>0)return qb[n];
        int ans = cs(n-1, qb) + cs(n-2, qb) + cs(n-3, qb);
        qb[n] = ans;
        return ans;
    }

}