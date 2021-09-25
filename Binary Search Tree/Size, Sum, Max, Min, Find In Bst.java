  public static int size(Node node) {
        if(node == null)return 0;
        
        return size(node.left) + size(node.right)+1;
  }

  public static int sum(Node node) {
        if(node == null)return 0;
        
        return sum(node.left) + sum(node.right)+node.data;
  }

  public static int max(Node node) {
        while(node.right != null){
            node = node.right;
        }
        return node.data;
  }

  public static int min(Node node) {
        while(node.left != null){
            node = node.left;
        }
        return node.data;
  }

  public static boolean find(Node node, int data){
        if(node == null)return false;
        
        if(node.data == data)return true;
        
        if(data < node.data)return find(node.left, data);
        return find(node.right, data);
  }