public static int lca(Node node, int d1, int d2) {
        
        if(Math.min(d1,d2) <= node.data && node.data <= Math.max(d1,d2)){
            return node.data;
        }else if(d1 < node.data && d2 < node.data){
            return lca(node.left, d1, d2);
        }else{
            return lca(node.right, d1,d2);
        }
  }