import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k, long[][]qb) {
        if(n==k)return 1;
        if(n<k || k==0)return 0;
        
        if(qb[n][k] != -1)return qb[n][k];
        
        long nm1km1 = partitionKSubset(n-1, k-1, qb);
        long nm1k = partitionKSubset(n-1, k, qb);
        
        qb[n][k] = nm1km1 + nm1k*k;
        
        return nm1km1 + nm1k*k;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long qb[][] = new long[n+1][k+1];
        
        for(long ar[]: qb){
            Arrays.fill(ar, -1);
        }
        
        long res = partitionKSubset(n, k, qb);
        System.out.println(res);
    }
}