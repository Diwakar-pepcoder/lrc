private static Node getLeaf(Node node){
    while(node.children.size() >0){
        node = node.children.get(0);
    }
    return node;
} 

public static Node linearize2(Node node){
    
    if(node.children.size() == 0)return node;
    
    for(int i=0;i<node.children.size()-1;i++){
        Node child = node.children.get(i);
        Node nextChild = node.children.get(i+1);
        
        Node leaf = linearize2(child);
        
        leaf.children.add(nextChild);
    }
    
    
    Node leaf = linearize2(node.children.get(node.children.size()-1));
    
    for(int i=node.children.size()-1;i>=1;i--){
        node.children.remove(i);
    }
    
    return leaf;
}

public static void linearize(Node node){
    
    
    for(Node child: node.children){
        linearize(child);
    }
    
    for(int i=0;i<node.children.size()-1;i++){
        Node child = node.children.get(i);
        Node nextChild = node.children.get(i+1);
        
        
        Node leaf = getLeaf(child);
        leaf.children.add(nextChild);
    }
    
    for(int i=node.children.size()-1;i>=1;i--){
        node.children.remove(i);
    }

}