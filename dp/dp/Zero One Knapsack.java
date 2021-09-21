import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int v[] = new int[n];
        for(int i=0;i<n;i++)v[i] = scn.nextInt();
        
        int w[] = new int[n];
        for(int i=0;i<n;i++)w[i] = scn.nextInt();
        
        int cap = scn.nextInt();
        
        // code
        int qb[][] = new int[n+1][cap+1];
        
        for(int i=1;i<=n;i++){
            int value = v[i-1];
            int weight = w[i-1];
            for(int c=1;c<=cap;c++){
                // exclude
                int max = qb[i-1][c];
                
                // include
                if(weight <= c){
                    int rewe = c-weight;
                    max = Math.max(max, value+qb[i-1][rewe]);
                }
                qb[i][c] = max;
            }
        }System.out.println(qb[n][cap]);
        
    }

    static int maxValue(int v[], int w[], int i, int cap){
        if(cap == 0)return 0;
        if(i == v.length)return 0;
        
        int ans=0;
        if(w[i] <= cap){
            ans = maxValue(v, w, i+1, cap-w[i]) + v[i];
        }
        int exc = maxValue(v, w, i+1, cap);
        
        
        return Math.max(ans, exc);
    }

}