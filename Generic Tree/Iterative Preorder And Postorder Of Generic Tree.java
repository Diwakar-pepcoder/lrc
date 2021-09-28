public static void IterativePreandPostOrder(Node node) {
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        
        while(st.size() > 0){
            Pair cp = st.peek();

            if(cp.status == -1){
                pre.append(cp.node.data+" ");
                cp.status++;
            }else if(cp.status==cp.node.children.size()){
                post.append(cp.node.data+" ");
                cp.status++;// not required
                st.pop();
            }else{
                Node child = cp.node.children.get(cp.status);
                st.push(new Pair(child, -1));
                cp.status++;
            }
        }
        
        System.out.println(pre);
        System.out.println(post);
        
        
  }