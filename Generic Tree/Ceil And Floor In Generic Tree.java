static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
        
        if(node.data < data){
            floor = Math.max(floor, node.data);
        }else if(node.data > data){
            ceil = Math.min(ceil, node.data);
        }
        
        for(Node child: node.children){
            ceilAndFloor(child, data);
        }
        
  }