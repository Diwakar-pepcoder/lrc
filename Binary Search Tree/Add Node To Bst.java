public static Node add(Node node, int data) {
        if(node == null){
            Node n = new Node(data, null, null);
            return n;
        }
        
        if(data < node.data){
            node.left = add(node.left, data);
        }else if(node.data < data){
            node.right = add(node.right, data);
        }
        return node;
  }