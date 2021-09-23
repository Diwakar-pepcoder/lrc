public int size(){
        return size;
    }

    public void display(){
        Node tmp = head;
        
        while(tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }