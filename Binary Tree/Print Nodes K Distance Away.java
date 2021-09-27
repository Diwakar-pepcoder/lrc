  public static ArrayList<Node> nodeToRootPath(Node node, int data){
        if(node == null){
            ArrayList<Node> ans = new ArrayList<Node>();
            return ans;
        }
        if(node.data == data){
            ArrayList<Node> ans = new ArrayList<Node>();
            ans.add(node);
            return ans;
        }
        ArrayList<Node> lf = nodeToRootPath(node.left, data);
        if(lf.size() > 0){
            lf.add(node);
            return lf;
        }
        ArrayList<Node> rf = nodeToRootPath(node.right, data);
        if(rf.size() > 0){
            rf.add(node);
            return rf;
        }
        return new ArrayList<>();
  }

  public static void printKNodesFar(Node node, int data, int k) {
        
        ArrayList<Node>  paths = nodeToRootPath(node, data);
        
        for(int i=0;i<paths.size();i++){
            Node n = paths.get(i);
            
            Node exc = i==0?null:paths.get(i-1);
            
            if(k==0){
                System.out.println(n.data);
            }else{
                if(n.left != exc){
                    printKLevelsDown(n.left, k-1);
                }
                if(n.right != exc){
                    printKLevelsDown(n.right, k-1);
                }
            }
            k--;
        }
        
  }
  
  public static void printKLevelsDown(Node node, int k){
        
        if(node  == null)return;
        
        if(k==0){
            System.out.println(node.data);
            return;
        }
        
        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
        
        
  }
