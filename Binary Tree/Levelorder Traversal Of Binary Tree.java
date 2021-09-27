public static void levelOrder(Node node) {
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        
        
        while(q.size() > 0){
            
            int count = q.size();
            
            for(int i=0;i<count;i++){
                Node r = q.remove();
                System.out.print(r.data+" ");
                if(r.left!= null)
                    q.add(r.left);
                if(r.right != null)
                    q.add(r.right);
            }
            
            System.out.println();
        }
        
  }