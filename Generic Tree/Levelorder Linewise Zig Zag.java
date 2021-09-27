public static void levelOrderLinewiseZZ(Node node){
        
        Stack<Node> main = new Stack<>();
        Stack<Node> child = new Stack<>();
        
        main.push(node);
        boolean ltr = true;
        while(main.size() > 0){
            
            while(main.size() > 0){
                Node n = main.pop();
                System.out.print(n.data+" ");
                
                if(ltr){
                    for(Node c: n.children){
                        child.push(c);
                    }
                }else{
                    for(int i=n.children.size()-1;i>=0;i--){
                        Node c = n.children.get(i);
                        child.push(c);
                    }
                }
            }
            
            ltr = !ltr;
            System.out.println();
            
            var t = main;
            main = child;
            child = t;
        }
        
  }