public void addAt(int idx, int val){
        if(idx < 0 || idx > size){
            System.out.println("Invalid arguments");
        }else if(idx == 0){
            addFirst(val);
        }else if(idx == size){
            addLast(val);
        }else{
            Node tmp = head;
            int i=0;
            
            while(i < idx-1){
                tmp = tmp.next;
                i++;
            }
            
            Node node = new Node();
            node.data = val;
            
            node.next = tmp.next;
            tmp.next = node;
            size++;
        }
    }