import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = scn.nextInt();
        }

        int tar = scn.nextInt();
        int ans = calPer(tar, ar, "");
        System.out.println(ans);
    }

    static int calPer(int tar, int ar[], String s){
        if(tar == 0){
            System.out.println(s);
            return 1;
        }

        int ans=0;
        for(int val: ar){
            if(tar-val >= 0)
            ans += calPer(tar-val, ar, s+" "+val);
        }
        return ans;
    }

    public static int tabulation(int coins[], int tar, int qb[]) {
        qb[0] = 1;
        int n = coins.length;

        for(int t=0; t<=tar;t++){
            for(int i=0;i<n;i++){
                int coin = coins[i];
                if(coin > t)continue;
                
                int req = t-coin;
                qb[t] += qb[req];
            }
        }
        
        return qb[tar];
    }
}