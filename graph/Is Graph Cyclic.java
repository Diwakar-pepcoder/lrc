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
      
      boolean vis[] = new boolean[vtces];

        boolean hasCycle = false;
        for(int i=0;i<vtces;i++){
            if(vis[i] == true)continue;
            // hasCycle = hasCycle(graph, i, -1, vis);
            hasCycle = hasCycleBFS(graph, i, vis);
            if(hasCycle)break;
        }

        System.out.println(hasCycle);
   }
   static boolean hasCycleBFS(ArrayList<Edge>graph[], int src, boolean[]visited){
        // boolean visited[] = new boolean[vtces];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
          while(q.size() > 0){
                Integer p = q.remove();
                
                if(visited[p]){
                    return true;
                }
                
                visited[p] = true;
                
                // System.out.println(p.node+"@"+p.path);
                
                for(Edge ed: graph[p]){
                    if(visited[ed.nbr] == false){
                        q.add(ed.nbr);
                    }
                }
          }
          return false;
   }
   
   static boolean hasCycle(ArrayList<Edge>graph[], int src, int parent, boolean vis[]){
       
       vis[src] = true;
       
       for(Edge ed: graph[src]){
           
           if(ed.nbr == parent)continue;
           
           if(vis[ed.nbr])return true;
           
           boolean cycle = hasCycle(graph, ed.nbr, src, vis);
           if(cycle)return true;
       }
       
       return false;
       
   }
   
}






