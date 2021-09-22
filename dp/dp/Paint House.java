import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int cost[][] = new int[n][3];

        for(int i=0;i<n;i++){
            cost[i][0] = scn.nextInt();
            cost[i][1] = scn.nextInt();
            cost[i][2] = scn.nextInt();
        }

        int dp[][] = new int[n][3];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[i][0] = cost[i][0];
                dp[i][1] = cost[i][1];
                dp[i][2] = cost[i][2];
            }else{

                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + cost[i][2];
            }
        }

        int ans = Math.min(dp[n-1][0], dp[n-1][1]);
        ans = Math.min(ans, dp[n-1][2]);
        System.out.println(ans);

    }
}