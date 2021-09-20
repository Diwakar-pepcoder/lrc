import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // int nthFib = fib(n);
    // int nthFib = fibM(n, new int[n+1]);// 0.. n
    // System.out.println(nthFib);
    
    int qb[] = new int[n+1];
    qb[1] = 1;
    for(int i=2;i<=n;i++){
        qb[i] = qb[i-1] + qb[i-2];
    }
    
    System.out.println(qb[n]);
 }
 
  static int fibM(int n, int qb[]){
        if(n<=1)return n;
        
        if(qb[n] > 0){
            return qb[n];
        }
        
        System.out.println(n);
        int fnm1 = fibM(n-1, qb);
        int fnm2 = fibM(n-2, qb);
        
        int ans = fnm1 + fnm2;
        qb[n] = ans;
        return ans;
 }
 
 static int fib(int n){
        if(n<=1)return n;
        
        System.out.println(n);
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        
        int ans = fnm1 + fnm2;
        
        return ans;
 }

}