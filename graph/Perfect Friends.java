import java.io.*;
import java.util.*;

public class Main {
   
   static class Edge{
       int src;
       int nbr;
       Edge(int s,int n){
           src = s;
           nbr = n;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      
      ArrayList<Edge> graph[] = new ArrayList[n];
      for(int i=0;i<n;i++)graph[i] = new ArrayList<>();
      
      for(int i=0;i<k;i++){
          String s = br.readLine();// "0 1"
          String []inp = s.split(" ");// ["0", "1"]
          int a = Integer.parseInt(inp[0]);
          int b = Integer.parseInt(inp[1]);
          
          graph[a].add(new Edge(a,b));
          graph[b].add(new Edge(b, a));
      }
      
        boolean visited[] = new boolean[n];
        
        ArrayList<Integer> size = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph, i, visited, comp);
                size.add(comp.size());
            }
        }
        
        int ans=0;
        
        // for(int i=0;i<size.size();i++){
        //     int sum=0;
        //     for(int j=i+1;j<size.size();j++)sum += size.get(j);
            
        //     ans += size.get(i)*sum;
        // }
        
        int sum=n;
        
        for(int i=0;i<size.size();i++){
            sum -= size.get(i);
            ans += size.get(i)*sum;
        }
        
        System.out.println(ans);
   }
   
   static void dfs(ArrayList<Edge>[]graph, int src, boolean[]visited, ArrayList<Integer> comp){
       
       visited[src] = true;
       
       comp.add(src);
       
       for(Edge ed: graph[src]){
           if(visited[ed.nbr] == true)continue;
           dfs(graph, ed.nbr, visited, comp);
       }
       
   }

}




