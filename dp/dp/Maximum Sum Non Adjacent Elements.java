import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ar[] = new int[n];
        for(int i=0;i<n;i++)ar[i] = scn.nextInt();

        int inc=0;
        int exc = 0;

        for(int i=0;i<n;i++){
            int nexc = Math.max(inc, exc);
            int ninc = exc + ar[i];

            inc = ninc;
            exc = nexc;
        }

        System.out.println(Math.max(inc, exc));
    }
}