public static boolean areMirror(Node n1, Node n2) {
        
        if(n1.children.size() != n2.children.size())return false;
        
        int i=0;
        int j = n2.children.size()-1;
        
        while(j>=0){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            
            if(false == areMirror(c1,c2)){
                return false;   
            }
            i++;
            j--;
        }
        
        return true;
  }