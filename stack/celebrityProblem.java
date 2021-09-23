import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)st.push(i);
        
        while(st.size() >= 2){
            int a = st.pop();
            int b = st.pop();
            
            if(arr[a][b] == 0){
                st.push(a);
            }else{
                st.push(b);
            }
        }
        
        int pc = st.pop();
        
        boolean ok = true;
        for(int i=0;i<n;i++){
            if(arr[pc][i] == 1){
                ok = false;
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            if(i!=pc && arr[i][pc] == 0){
                ok = false;break;
            }
        }
        if(ok){
            System.out.println(pc);
        }else{
            System.out.println("none");
        }
    }

}