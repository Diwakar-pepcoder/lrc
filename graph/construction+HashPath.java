import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int s, int n, int w){
            src = s;
            nbr = n;
            wt = w;
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)graph[i] = new ArrayList<>();

        int e = scn.nextInt();
        for(int i=0;i<e;i++){
            int src = scn.nextInt();
            int nbr = scn.nextInt();
            int w = scn.nextInt();

            graph[src].add(new Edge(src, nbr, w));
            graph[nbr].add(new Edge(nbr, src, w));
        }

        int src = scn.nextInt();
        int des = scn.nextInt();

        boolean hasPath = hasPath(graph, src, des, new boolean[n]);   
        System.out.println(hasPath);
    }

    static boolean hasPath(ArrayList<Edge>[]graph, int src, int des, boolean[]visited){
        if(src == des)return true;

        visited[src] = true;

        for(Edge edg: graph[src]){

            if(visited[edg.nbr] == false && hasPath(graph, edg.nbr, des, visited)){
                return true;
            }

        }
        return false;
    }

}
