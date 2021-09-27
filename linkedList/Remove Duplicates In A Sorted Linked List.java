public void removeDuplicates(){
        LinkedList list = new LinkedList();
        
        while(size > 0){
            int data = head.data;
            this.removeFirst();
            
            if(list.size() == 0 || list.tail.data != data){
                list.addLast(data);
            }
        }
        
        head = list.head;
        tail = list.tail;
        size = list.size;
        
    }