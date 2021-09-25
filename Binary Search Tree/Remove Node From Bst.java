static int max(Node node){
      while(node.right != null)node = node.right;
      return node.data;
  }

  public static Node remove(Node node, int data) {
        
        if(data < node.data){
            node.left = remove(node.left, data);
            return node;
        }else if(node.data < data){
            node.right = remove(node.right, data);
            return node;
        }else{
            if(node.left == null && node.right == null){
                return null;
            }else if(node.left != null && node.right == null){
                return node.left;
            }else if(node.right != null && node.left == null){
                return node.right;
            }else{
                int max = max(node.left);
                node.data = max;
                node.left = remove(node.left, max);
                return node;
            }
        }
  }