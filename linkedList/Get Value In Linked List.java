public int getFirst(){
        return getAt(0);
    }

    public int getLast(){
        return getAt(size-1);
    }

    public int getAt(int idx){
        if(size ==0){
            System.out.println("List is empty");
            return -1;
        }else if(idx < 0 || size <= idx){
            System.out.println("Invalid arguments");
            return -1;
        }else{
            if(idx == 0)return head.data;
            if(idx == size-1)return tail.data;
            
            Node tmp = head;
            int i =0 ;
            while(i < idx){
                tmp = tmp.next;
                i++;
            }
            
            return tmp.data;
        }
    }