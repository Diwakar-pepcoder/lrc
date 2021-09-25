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
  
  static class BstPair{
        int min;
        int max;
        boolean isBst;
        int size;
        int largestBstSize;
        int lbstdata;
  }
  static BstPair lbst(Node node){
        if(node == null){
            BstPair ans = new BstPair();
            ans.min = Integer.MAX_VALUE;
            ans.max = Integer.MIN_VALUE;
            ans.isBst = true;
            ans.size = 0;
            ans.largestBstSize=0;
            ans.lbstdata=0;
            return ans;
        }
      
        var lp = lbst(node.left);
        var rp = lbst(node.right);
        
        BstPair ans = new BstPair();
        if(lp.largestBstSize >= rp.largestBstSize){
            ans.lbstdata = lp.lbstdata;
            ans.largestBstSize = lp.largestBstSize;
        }else{
            ans.lbstdata = rp.lbstdata;
            ans.largestBstSize = rp.largestBstSize;
        }
        
        if(lp.isBst && rp.isBst && lp.max < node.data && node.data < rp.min){
            ans.isBst = true;
            ans.largestBstSize = lp.size+rp.size+1;
            ans.lbstdata = node.data;
        }else{
            ans.isBst = false;
        }
        
        ans.min = Math.min(lp.min, node.data);
        ans.max = Math.max(rp.max, node.data);
        ans.size = lp.size+rp.size+1;
      
        return ans;
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
    
    var result = lbst(root);
    
    System.out.println(result.lbstdata+"@"+result.largestBstSize);
    
  }

}