public void reversePI(){
        Node curr = head;
        Node rev = null;
        
        while(curr != null){
            Node tmp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = tmp;
        }
        
        Node tmp = head;
        head = tail;
        tail = tmp;
    }