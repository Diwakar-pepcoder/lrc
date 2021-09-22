import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);

            String s = scn.nextLine();

            int n = s.length();

            int qb[] = new int[n];

            for(int i=0;i<n;i++){

                // single
                int val = s.charAt(i) - '0';
                if(1<= val && val <= 9){
                    qb[i] += i-1==-1?1:qb[i-1];
                }

                // pair
                if(i>0){
                    val = Integer.parseInt(s.substring(i-1, i+1));
                    if(10<=val && val <= 26){
                        qb[i] += i-2>=0?qb[i-2]:1;
                    } 
                }
            }

            System.out.println(qb[n-1]);
    }
}