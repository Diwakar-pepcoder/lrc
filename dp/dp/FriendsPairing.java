import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int ans = rec(n, new int[n+1]);
        System.out.println(ans);
    }

    public static int rec(int n, int qb[]) {
        if(n<=2)return n;

        if(qb[n] > 0) return qb[n];
        int nm1 = rec(n-1, qb);
        int nm2 = rec(n-2, qb);
        int ans = nm1 + nm2*(n-1);
        qb[n] = ans;
        return ans;
    }

}