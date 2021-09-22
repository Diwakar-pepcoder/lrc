import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    int qb0[] = new int[n+1];
    int qb1[] = new int[n+1];
    
    qb0[1] = qb1[1] = 1;
    
    for(int i=2;i<=n;i++){
        qb0[i] = qb1[i-1];
        qb1[i] = qb0[i-1] + qb1[i-1];
    }
    
    long total = qb0[n] + qb1[n];
    
    System.out.println(total*total);
    
 }

}