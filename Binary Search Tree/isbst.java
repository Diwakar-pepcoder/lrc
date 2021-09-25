import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

 static boolean isBST1(Node node, int lo, int hi){
        if(node == null){
            return true;
        } 
        if(lo < node.data && node.data < hi){
            
        }else return false;
        
        boolean l = isBST1(node.left, lo, node.data);
        if(l == false)return l;
        
        boolean r = isBST1(node.right, node.data, hi);
        
        return r;
 }
 static class Pair2{
        int min;
        int max;
        boolean ok;
        Pair2(int min, int max, boolean ok){
            this.min = min;
            this.max = max;
            this.ok = ok;
        }
 }
 static Pair2 isBST2(Node node){
        if(node == null){
            return new Pair2(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
     
        Pair2 l = isBST2(node.left);
        Pair2 r = isBST2(node.right);
        
        int min = Math.min(l.min, node.data);
        int max = Math.max(r.max, node.data);
        boolean ok = l.max < node.data && node.data < r.min && l.ok && r.ok;
        
        Pair2 result = new Pair2(min, max, ok);  
        return result;
    }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    
    // boolean result = isBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    Pair2 result = isBST2(root);
    System.out.println(result.ok);
  }

}