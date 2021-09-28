import java.util.*;



public class construction {
    
    static class Node{
        int data;
        ArrayList<Node> children= new ArrayList<>();;

        // Node(){
        //     children 
        // }
    }
    public static void main(String[] args) {
        
        int ar[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> st = new Stack<>();

        int i=0;
        Node root = new Node();
        root.data = ar[0];
        st.push(root);
        i++;

        while(i<ar.length){

            if(ar[i] == -1){
                st.pop();
            }else{
                Node node = new Node();
                node.data = ar[i];
                st.peek().children.add(node);
                st.push(node);
            }

            i++;
        }

        display(root);
    }
    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
          str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
    
        for (Node child : node.children) {
          display(child);
        }
      }
}
