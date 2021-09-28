static Node predecessor;
  static Node successor;
  static int flag=0;
  public static void predecessorAndSuccessor(Node node, int data) {
        
        if(node.data == data){
            flag = 1;
        }else if(flag == 1){
            successor = node;
            flag = 2;
        }else if(flag == 0){
            predecessor = node;
        }
        
        for(Node child: node.children){
            predecessorAndSuccessor(child, data);
        }
  }