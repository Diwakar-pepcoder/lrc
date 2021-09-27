public static int size(Node node){
        
    int s=0;
    for(Node child: node.children){
        s += size(child);
    }
    s++;
    return s;
}