import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int coins[] = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        int dp[][] = new int[n+1][tar+1];// 0 -> false  1 -> true
        
        for(int i=0;i<=n;i++){
            int coin = 0;
            if(i>0){
                coin = coins[i-1];
            }
            
            for(int j=0;j<=tar;j++){
                
                if(i==0){
                    if(j==0)dp[i][j] = 1;
                    else dp[i][j] = 0;
                    continue;
                }
                
                // without me
                if(dp[i-1][j] == 1){
                    dp[i][j] = 1;
                    continue;
                }
                
                int req = j - coin;
                
                if(req>=0 && dp[i-1][req] == 1){
                    dp[i][j] = 1;
                    continue;
                }
                
                dp[i][j] = 0;
            }
        }
        
        System.out.println(dp[n][tar] == 1);
    }
}