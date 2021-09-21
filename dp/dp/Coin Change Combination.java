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
        
        int qb[] = new int[tar+1];
        qb[0] = 1;
        for(int i=0;i<n;i++){
            int coin = coins[i];
            // coin cant be used under targer < coin so start from target = coin
            for(int t=coin; t<=tar;t++){
                int req = t-coin;
                qb[t] += qb[req];
            }
        }
        
        System.out.println(qb[tar]);
    }

    public static int rec(int i, int coins[], int tar) {
        if(tar == 0)return 1;
        if(i==coins.length)return 0;

        int ans=0;
        if(coins[i] <= tar){
            ans += rec(i+1, coins, tar-coins[i]);
        }
        ans += rec(i+1, coins, tar);

        return ans;
    }

}