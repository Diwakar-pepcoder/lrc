public static Node createLeftCloneTree(Node node){
        if(node == null)return null;
        
        Node clone = new Node(node.data, null, null);
        
        clone.left = createLeftCloneTree(node.left);
        node.left = clone;
        createLeftCloneTree(node.right);
        
        return node;
  }