import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      hPC(graph, src, ""+src, new boolean[vtces], 0, src);
   }
    static void hPC(ArrayList<Edge>[]graph, int src, String path, boolean vis[], int count, int osrc){
        if(count == vis.length-1){
            
            boolean cycle = false;
            
            for(Edge ed: graph[src]){
                if(ed.nbr == osrc){
                    cycle = true;
                    break;
                }
            }
            if(cycle){
                System.out.println(path+'*');
            }else{
                System.out.println(path+'.');
            }
            
            return;
        }
        
        vis[src] = true;
        
        for(Edge ed: graph[src]){
            
            if(vis[ed.nbr])continue;
            
            hPC(graph, ed.nbr, path+ed.nbr, vis, count+1, osrc);
        }
        vis[src] = false;
    }

}




