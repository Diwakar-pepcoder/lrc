import java.io.*;
import java.util.*;

class Main {

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
}