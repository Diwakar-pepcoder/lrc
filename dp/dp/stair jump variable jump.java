import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int jumps[] = new int[n];
        for(int i=0;i<n;i++)jumps[i] = scn.nextInt();
        
        int qb[] = new int[n+1];
        Arrays.fill(qb, -1);
        int ans = rec(0, n, jumps, qb);
        System.out.println(ans);
    }
    
    static int tab(int jumps[], int des, int qb[]){
        for(int i=des;i>=0;i--){
            if(i == des){
                qb[i] = 1;
                continue;
            }
            // if(curr>des)return 0;
            // if(qb[i] != -1)return qb[curr];
            int ans=0;
            for(int j=1;j<=jumps[i] && j+i <= des;j++){
                ans += qb[i+j];//rec(i+j, des, jumps, qb);
            }
            // qb[i] = ans;
            qb[i] = ans;
        }
        return qb[0];
    }
    
    static int rec(int curr, int des, int jumps[], int qb[]){
        if(curr == des)return 1;
        // if(curr>des)return 0;
        
        if(qb[curr] != -1)return qb[curr];
        
        int ans=0;
        for(int j=1;j<=jumps[curr] && j+curr <= des;j++){
            ans += rec(curr+j, des, jumps, qb);
        }
        
        qb[curr] = ans;
        return ans;
    }

}