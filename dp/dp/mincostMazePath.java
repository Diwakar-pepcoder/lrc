import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m = scn.nextInt();
        
        int cost[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cost[i][j] = scn.nextInt();
            }
        }
        int qb[][] = new int[n][m];
        for(int ar[]: qb){
            Arrays.fill(ar, -1);
        }
        int ans = tab(cost, qb);
        
        // for(int ar[]: qb){
        //     for(int val: ar){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(ans);
    }
    
    static int tab(int cost[][], int qb[][]){
        
        int dr = cost.length-1;
        int dc = cost[0].length-1;
        
        for(int r = cost.length-1;r>=0;r--){
            for(int c=cost[0].length-1;c>=0;c--){
                
                if(r == dr && c == dc){
                    qb[r][c] = cost[dr][dc];
                    continue;
                }
        
                // if(qb[sr][sc] != -1)return qb[sr][sc];
                
                int hFaith = Integer.MAX_VALUE;
                int vFaith = Integer.MAX_VALUE;
                
                if(c != dc){
                    hFaith = qb[r][c+1];//rec(r, c+1, dr, dc, cost, qb);
                }
                if(r != dr){
                    vFaith = qb[r+1][c];//rec(r+1, c, dr, dc, cost, qb);
                }
                
                int ans = Math.min(vFaith, hFaith) + cost[r][c];
                // qb[sr][sc] = ans;
                qb[r][c] = ans;
                
            }
        }
        return qb[0][0];
    }
    
    static int rec(int sr, int sc, int dr, int dc, int cost[][], int [][]qb){
        if(sr == dr && sc == dc)return cost[dr][dc];
        
        if(qb[sr][sc] != -1)return qb[sr][sc];
        
        int hFaith = Integer.MAX_VALUE;
        int vFaith = Integer.MAX_VALUE;
        
        if(sc != dc){
            hFaith = rec(sr, sc+1, dr, dc, cost, qb);
        }
        if(sr != dr){
            vFaith = rec(sr+1, sc, dr, dc, cost, qb);
        }
        
        int ans = Math.min(vFaith, hFaith) + cost[sr][sc];
        qb[sr][sc] = ans;
        return ans;
        
    }

}