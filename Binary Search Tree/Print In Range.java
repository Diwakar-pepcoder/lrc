public static void pir(Node node, int d1, int d2) {
        if(node == null)return;
        
        if(d1 > node.data && d2>node.data){
            
        }
        else pir(node.left, d1,d2);
        
        if(Math.min(d1,d2) <= node.data && node.data <= Math.max(d1,d2))
            System.out.println(node.data);
        
        if(d1<node.data && d2<node.data){
            
        }else
        pir(node.right, d1,d2);
  }