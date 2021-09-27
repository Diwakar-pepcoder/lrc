boolean fold(Node node){
    	if(node == null){
    		left = head;
    		return true;
    	}
    
    	if(false==fold(node.next))return false;
    	
    	if(left == node){
    		left.next = null;
    		tail = left;
    		return false;
    	}
    	if(left.next == node){
    		node.next = null;
    		tail = node;return false;
    	}
    
    	node.next = left.next;
    	left.next = node;
    	left = node.next;
    	return true;
    }
    Node left;
    public void fold() {
        fold(head);
    }