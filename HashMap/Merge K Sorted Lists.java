import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair implements Comparable<Pair> {
        ArrayList<Integer> al;
        int ind;
        Pair(ArrayList<Integer> a){
            al = a;
            ind = 0;
        }
        public int compareTo(Pair b){
            int x = this.al.get(ind);
            int y = b.al.get(b.ind);
            
            if(x<y)return -1;
            if(x>y)return +1;
            return 0;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(ArrayList<Integer> list: lists){
          pq.add(new Pair(list));
      }
      while(pq.size() > 0){
            Pair p = pq.remove();
            
            rv.add(p.al.get(p.ind));
            p.ind++;
            if(p.ind < p.al.size()){
                pq.add(p);
            }
      }
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}