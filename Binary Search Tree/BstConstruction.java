class Main {

    static class Node{
        int data;
        Node left,right;
    }

    static Node construct(int arr[], int l, int r){
        if(r<l)return null;

        int mid = (l+r)/2;
        Node node = new Node();
        node.data = arr[mid];

        node.left = construct(arr, l, mid-1);
        node.right = construct(arr, mid+1, r);
        
        return node;
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

    public static void main(String[] args) {
        int ar[] = {10,20,30,40,50,60,70,80,90};

        Node root = construct(ar, 0, ar.length-1);
        display(root);
    }
}
