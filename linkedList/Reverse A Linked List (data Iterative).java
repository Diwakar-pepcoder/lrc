public Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp;
    }

    public void reverseDI() {
        int i=0;
        int j = size-1;
        
        while(i<j){
            Node a = getNodeAt(i++);
            Node b = getNodeAt(j--);
            int tmp = a.data;
            a.data = b.data;
            b.data = tmp;
        }
    }